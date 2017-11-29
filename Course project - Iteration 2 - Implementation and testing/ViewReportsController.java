import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;


public class ViewReportsController implements ActionListener 
{
    private ViewReports viewReports;
    private DataAdapter dataAdapter;
    private Order order = null;
    private Connection connection;
     List<OrderLine> orderLineList = new ArrayList<OrderLine>();


    
     public ViewReportsController(ViewReports viewReports, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.viewReports = viewReports;
        order = new Order();

        viewReports.getBtnLoadOrderLine().addActionListener(this);

    }
     
     public ViewReportsController(Connection connection)
     {
         this.connection = connection;
     }

     
      public void actionPerformed(ActionEvent e) 
        {
        
        if (e.getSource() == viewReports.getBtnLoadOrderLine()) {
        	load();
        }
        }
     
     private void load () {
    	 try {
             Connection conn =  DriverManager.getConnection("jdbc:sqlite:storenew.db");
             Statement statement = conn.createStatement();
               ResultSet resultSet;
             resultSet = statement.executeQuery("SELECT * FROM OrderLine");
             OrderLine line = new OrderLine();
           Object[] row = new Object[3];

             while (resultSet.next()) 
             {
                 line.setOrderID(resultSet.getInt(1));
                 line.setProductID(resultSet.getInt(2));
                 line.setQuantity(resultSet.getDouble(3));
                 line.setCost(resultSet.getDouble(4));
                 orderLineList.add(line);
               row[0] = line.getProductID();
               row[1] = line.getQuantity();
               row[2] = line.getCost();
      
               this.viewReports.addRow(row);
     }
             resultSet.close();
             statement.close();
    	 }
         catch (SQLException e) {
             System.out.println("Database access error!");
             e.printStackTrace();
         }
     } 
}
