import java.sql.*;

public class Application 
{

    private static Application instance;  

    public static Application getInstance() 
    {
        if (instance == null) 
        {
            instance = new Application();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() 
    {
        return connection;
    }

    private DataAdapter dataAdapter;

    private ProductView productView = new ProductView();

    private CheckoutScreen checkoutScreen = new CheckoutScreen();

    private MainScreen mainScreen = new MainScreen();

    public MainScreen getMainScreen() 
    {
        return mainScreen;
    }

    public ProductView getProductView() 
    {
        return productView;
    }

    public CheckoutScreen getCheckoutScreen() 
    {
        return checkoutScreen;
    }

    private ProductController productController;

    public ProductController getProductController() 
    {
        return productController;
    }

    private CheckoutController checkoutController;

    public CheckoutController getCheckoutController() 
    {
        return checkoutController;
    }

    public DataAdapter getDataAdapter() 
    {
        return dataAdapter;
    }

    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!
        String products = "create table product (ProductID integer,name varchar(100), price float,  quantity integer, taxrate float, primary key (ProductID))";
                       
        String orders = "create table orders (orderID integer, date varchar(100), total float, primary key (orderID))";
                     
        String orderLine = "create table orderline (orderID integer, productID integer, qty integer, total float,  primary key(orderID, productID))";
                     
        String initialProduct = "insert into product values (101500, 'pumpkin', 1.2, 10, 0.3), (10900, 'red onion', 4.0, 5, 0.9), (14500, 'paprika', 5.0, 12, 1.1), (18763, 'plain bagel', 6.1, 20, 0.2), (12870, 'eggs', 9, 34, 1.5)";
                            
        String initialOrders = "insert into orders values (11101, '07/05/2017', 102.43), (11141, '07/19/2017', 50.12), (11191, '07/22/2017', 12.94), (11120, '07/29/2017', 20.30), (11129, '07/30/2017', 200.12)";

        String initialOrderLine = "Insert into orderline values (2000, 101500, 1, 1.2),  (2000, 10900, 2, 8.0), (2000, 14500, 3, 15.0), (2000, 18763, 2, 12.2), (2000, 12870, 4, 36.0)";
        
        //populate database
        stmt.execute(products);
        stmt.execute(orders);
        stmt.execute(orderLine);
        stmt.execute(initialProduct);
        stmt.execute(initialOrders);
        stmt.execute(initialOrderLine);
        
        //stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");
        


    }

    private Application() {
        // create SQLite database connection here!
         Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:storenew.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:storenew.db");
            Statement stmt = connection.createStatement();
            //This if statement does not work if database doesn't exist. 
            //But it needs to be here in case database does exist.
            DatabaseMetaData dbm = connection.getMetaData();
            // check if "employee" table is there
            ResultSet tables = dbm.getTables(null, null, "product", null);
            if (tables.next()) {
              // Table exists
            }
            else {
            // Table does not exist
            initializeDatabase(stmt);
            }
            //if (!stmt.executeQuery("select * from product").next()) // product table does not exist
                
    


        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!" + ex.getMessage());

            System.exit(2);
        }

        
        dataAdapter = new DataAdapter(connection);

        productController = new ProductController(productView, dataAdapter);

        checkoutController = new CheckoutController(checkoutScreen, dataAdapter);
    }


    public static void main(String[] args) {
        Application.getInstance().getMainScreen().setVisible(true);
    }
}
