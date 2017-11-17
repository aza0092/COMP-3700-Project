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

    private OpeningScreen openingScreen = new OpeningScreen();
    
    private CashierHomeScreen cashierHomeScreen = new CashierHomeScreen();
    
    private CashierLogIn cashierLogIn = new CashierLogIn();
    
    private ManagerLogIn managerLogIn = new ManagerLogIn();
    
    private ManagerHomeScreen managerHomeScreen = new ManagerHomeScreen();
    
    private ManageAccount manageAccount = new ManageAccount();
    
    private PasswordChange passwordChange = new PasswordChange();
    
    public CashierHomeScreen getCashierHomeScreen() 
    {
        return cashierHomeScreen;
    }

    public ProductView getProductView() 
    {
        return productView;
    }

    public CheckoutScreen getCheckoutScreen() 
    {
        return checkoutScreen;
    }
    
    public OpeningScreen getOpeningScreen() 
    {
        return openingScreen;
    }
    
    public CashierLogIn getCashierLogIn() 
    {
        return cashierLogIn;
    }
    
    public ManagerLogIn getManagerLogIn()
    {
        return managerLogIn;
    }
    
    public ManagerHomeScreen getManagerHomeScreen()
    {
        return managerHomeScreen;
    }
    
    public ManageAccount getManageAccount()
    {
        return manageAccount;
    }
    
    public PasswordChange getPasswordChange()
    {
        return passwordChange;
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

   /* private CLogInController cLogInController;
     
    public CLogInController getCLogInController()
    {
        return cLogInController;
    }
    
    private MLogInController mLogInController;
    
    public MLogInController getMLogInController()
    {
        return mLogInController;
    }*/
    
    public DataAdapter getDataAdapter() 
    {
        return dataAdapter;
    }

    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!
        String products = "create table product (ProductID integer,name varchar(100), price float,  quantity integer, taxrate double, primary key (ProductID))";
                       
        String orders = "create table orders (orderID integer, date varchar(100), total float, primary key (orderID))";
                     
        String orderLine = "create table orderline (orderID integer, productID integer, qty integer, total float,  primary key(orderID, productID))";
        
        String users = "create table users (UserID varchar(100), password double, role varchar (10), primary key (UserID))"; //database for the users that can be added and log into the system
                     
        String initialProduct = "insert into product values (101500, 'pumpkin', 1.2, 10, 0.3), (10900, 'red onion', 4.0, 5, 0.9), (14500, 'paprika', 5.0, 12, 1.1), (18763, 'plain bagel', 6.1, 20, 0.2), (12870, 'eggs', 9, 34, 1.5)";
                            
        String initialOrders = "insert into orders values (11101, '07/05/2017', 102.43), (11141, '07/19/2017', 50.12), (11191, '07/22/2017', 12.94), (11120, '07/29/2017', 20.30), (11129, '07/30/2017', 200.12)";

        String initialOrderLine = "Insert into orderline values (2000, 101500, 1, 1.2),  (2000, 10900, 2, 8.0), (2000, 14500, 3, 15.0), (2000, 18763, 2, 12.2), (2000, 12870, 4, 36.0)";
        
        String initialUsers = "insert into users values (Jon Smith_m, 111111, manager), (Jon Smith_c, 111112, cashier)"; //Mr. Smith initially added to the database with different identifying userID's so when logging into cashier it doesn't take the manager one
        
        //populate database
        stmt.execute(products);
        stmt.execute(orders);
        stmt.execute(orderLine);
        stmt.execute(users);
        stmt.execute(initialProduct);
        stmt.execute(initialOrders);
        stmt.execute(initialOrderLine);
        stmt.execute(initialUsers);
        
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
        
       /* cLogInController = new CLogInController(cashierLogIn, dataAdapter);
        
        mLogInController = new MLogInController(managerLogIn, dataAdapter);*/
    }


    public static void main(String[] args) {
        Application.getInstance().getOpeningScreen().setVisible(true);
    }
}
