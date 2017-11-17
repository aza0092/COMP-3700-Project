import java.sql.*;

public class DataAdapter 
{
    private Connection connection;

    public DataAdapter(Connection connection) 
    {
        this.connection = connection;
    }

    public Product loadProduct(int id) 
    {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) 
            {
                Product product = new Product();
                product.setProductID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getDouble(4));
                product.setTaxRate(resultSet.getDouble(5));
                resultSet.close();
                statement.close();

                return product;
            }

        } 
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveProduct(Product product) 
    {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ?, TaxRate = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getProductID());
                statement.setDouble(5, product.getTaxRate());
            }
            else 
            { 
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setDouble(5, product.getTaxRate());
                statement.setInt(1, product.getProductID());
                
            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; 
        }
    }

    public Order loadOrder(int id) 
    {
        try {
            Order order = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Order WHERE OrderID = " + id);

            if (resultSet.next()) 
            {
                order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setCustomerName(resultSet.getString("Customer"));
                order.setTotalCost(resultSet.getDouble("TotalCost"));
                order.setDate(resultSet.getDate("OrderDate"));
                resultSet.close();
                statement.close();
            }

            // loading the order lines for this order
            resultSet = statement.executeQuery("SELECT * FROM OrderLine WHERE OrderID = " + id);

            while (resultSet.next()) 
            {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setQuantity(resultSet.getDouble(3));
                line.setCost(resultSet.getDouble(4));
                order.addLine(line);
            }

            return order;

        } 
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Order order) 
    {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Order VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, order.getOrderID());
            statement.setDate(2, order.getDate());
            statement.setString(3, order.getCustomerName());
            statement.setDouble(4, order.getTotalCost());
            statement.setDouble(5, order.getTotalTax());

            statement.execute();    
            statement.close();

            statement = connection.prepareStatement("INSERT INTO OrderLine VALUES (?, ?, ?, ?)");
            for (OrderLine line: order.getLines()) { // store for each order line
                statement.setInt(1, line.getOrderID());
                statement.setInt(2, line.getProductID());
                statement.setDouble(3, line.getQuantity());
                statement.setDouble(4, line.getCost());

                statement.execute();    // commit to the database;
            }
            statement.close();
            return true; 
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean cLogIn(String userID, double password) //checking the given cashier userID and password with the userID and password in the DB
    {
        String DbUserID = "";
        double DbPassword = 0;
        String DbRole = "";
        String role = "cashier";
        boolean correctLogIn = false;
         
        try {
            String query = "SELECT * FROM users WHERE userID = " + userID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            boolean has_results = resultSet.next();
            while (has_results) 
            {
                DbUserID = (resultSet.getString(0));
                DbPassword = (resultSet.getDouble(1));
                DbRole = (resultSet.getString(2));
            }
            
            while (!correctLogIn)
            {
               if(DbUserID.equals(userID))
               {
                   if(DbPassword == password)
                   {
                       if(DbRole.equals(role))
                       {
                           correctLogIn = true;
                       }
                    }
                }
               else 
               {
                   correctLogIn = false;
               }
            }
            if (correctLogIn = true)
            {
                return true;
            }
        } 
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean mLogIn(String userID, double password) //checking the given manager userID and password with the userID and password in the DB
    {
        String DbUserID = "";
        double DbPassword = 0;
        String DbRole = "";
        String role = "manager";
        boolean correctLogIn = false;
         
        try {
            String query = "SELECT * FROM users WHERE userID = " + userID;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            boolean has_results = resultSet.next();
            while (has_results) 
            {
                DbUserID = (resultSet.getString(0));
                DbPassword = (resultSet.getDouble(1));
                DbRole = (resultSet.getString(2));
            }
            
            while (!correctLogIn)
            {
               if(DbUserID.equals(userID))
               {
                   if(DbPassword == password)
                   {
                       if(DbRole.equals(role))
                       {
                           correctLogIn = true;
                       }
                    }
                }
               else 
               {
                   correctLogIn = false;
               }
            }
            if (correctLogIn = true)
            {
                return true;
            }
        } 
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return false;
     }
}
