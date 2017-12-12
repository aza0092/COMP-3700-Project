import javax.swing.*;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutController implements ActionListener 
{
    private CheckoutScreen view;
    private DataAdapter dataAdapter; // to save and load product
    private Order order = null;
    
    String[] row = new String[5];


    public CheckoutController(CheckoutScreen view, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.view = view;

        view.getBtnAdd().addActionListener(this);
        view.getBtnPay().addActionListener(this);
        view. getBtnPrintReceiptTXT().addActionListener(this);
        view.getBtnPrintReceiptHTML().addActionListener(this);

        order = new Order();
    }


    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == view.getBtnAdd())
            addProduct();
        
        if (e.getSource() == view.getBtnPay())
            saveOrder();
        
        if (e.getSource() == view.getBtnPrintReceiptTXT())
        	printReceiptTXT();
        	
        if (e.getSource() == view.getBtnPrintReceiptHTML())
        	printReceiptHTML();

    }

    private void saveOrder() 
    {
    	JOptionPane.showMessageDialog(null, "Checkout Completed.\n\nTotal: $" + order.getTotalCost());
        return;
        }

    private void addProduct() 
    {
        String id = JOptionPane.showInputDialog("Enter ProductID: ");
        Product product = dataAdapter.loadProduct(Integer.parseInt(id));
        if (product == null) 
        {
            JOptionPane.showMessageDialog(null, "This product does not exist!");
            return;
        }

        double quantity = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter quantity: "));

        if (quantity < 0 || quantity > product.getQuantity()) 
        {
            JOptionPane.showMessageDialog(null, "This quantity is not valid!");
            return;
        }

        OrderLine line = new OrderLine();
        line.setOrderID(this.order.getOrderID());
        line.setProductID(product.getProductID());
        line.setQuantity(quantity);
        line.setCost(quantity * product.getPrice());

        product.setQuantity(product.getQuantity() - quantity); // update new quantity
        dataAdapter.saveProduct(product);

        order.getLines().add(line);
        order.setTotalCost(order.getTotalCost() + line.getCost());

        //Object[] row = new Object[5];
        row[0] = String.valueOf(line.getProductID());
        row[1] = product.getName();
        row[2] = String.valueOf(product.getPrice());
        row[3] = String.valueOf(line.getQuantity());
        row[4] = String.valueOf(line.getCost());

        this.view.addRow(row);
        this.view.getLabTotal().setText("Total: " + order.getTotalCost());
        this.view.invalidate();
    }
    
    private void printReceiptTXT() {
    	
    	String totalCost = String.valueOf(order.getTotalCost());
    	    	
    	 try {
    	    JOptionPane.showMessageDialog(null, "receipt printed as text file. Check the following text file: ReceiptTXT");
             File newTextFile = new File("ReceiptTXT.txt");

             FileWriter fw = new FileWriter(newTextFile);
             fw.write("Product ID" + "  " + "Product Name" + "  " + "Product Price" + "  " + "Product Price" + "  "+ "Product qty" + "  "+ "Total Cost");
             fw.write("\r\n");
             for (int i = 0; i < 5; i++) {
            	 fw.write(row[i]+"    ");
            	 //fw.write("\n");

             }
             fw.write(totalCost);
            // fw.write(str);
             fw.close();

         } catch (IOException iox) {
     	    JOptionPane.showMessageDialog(null, "File failed to be created");
             iox.printStackTrace();
         }
    	
    }
    
    private void printReceiptHTML() {
    	
    	String totalCost = String.valueOf(order.getTotalCost());

   	 try {
 	    JOptionPane.showMessageDialog(null, "receipt printed as text file. Check the following text file: ReceiptHTML");
          File newTextFile = new File("ReceiptHTML.html");

          FileWriter fw = new FileWriter(newTextFile);
          fw.write("<span style=\"padding-left:30px\">Product ID" + "  " + "Product Name" + "  " + "Product Price" + "  " + "Product Price" + "  "+ "Product qty" + "  "+ "Total Cost</span>");
          fw.write("<pre> </pre>");
          for (int i = 0; i < 5; i++) {
         	 fw.write("<span style=\"padding-left:30px\">"+row[i]+"</span>");
         	 //fw.write("\n");

          }
          fw.write(totalCost);
          fw.write("<pre> </pre>");
         // fw.write(str);
          fw.close();

      } catch (IOException iox) {
  	    JOptionPane.showMessageDialog(null, "File failed to be created");
          iox.printStackTrace();
      }
    	
    }

}
