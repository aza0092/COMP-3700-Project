import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutController implements ActionListener 
{
	/**
	 * @wbp.parser.entryPoint
	 */
    private CheckoutScreen view;
    private DataAdapter dataAdapter; // to save and load product
    private Order order = null;
    //private double displayTotal = 0.0;

    /**
     * @wbp.parser.entryPoint
     */
    public CheckoutController(CheckoutScreen view, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.view = view;

        view.getBtnAdd().addActionListener(this);
        view.getBtnPay().addActionListener(this);

        order = new Order();
    }


    /**
     * @wbp.parser.entryPoint
     */
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == view.getBtnAdd())
            addProduct();
        else
        if (e.getSource() == view.getBtnPay())
            saveOrder();
    }

    /**
     * @wbp.parser.entryPoint
     */
    private void saveOrder() 
    {
    	JOptionPane.showMessageDialog(null, "Total: " + order.getTotalCost());
        return;
    }

    /**
     * @wbp.parser.entryPoint
     */
    private void addProduct() 
    {
        String id = JOptionPane.showInputDialog("Enter ProductID: ");
        Product product = dataAdapter.loadProduct(Integer.parseInt(id));
        if (product == null) 
        {
            JOptionPane.showMessageDialog(null, "This product does not exist!");
            return;
        }

        double quantity1 = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter quantity: "));

        if (quantity1 < 0 || quantity1 > product.getQuantity()) 
        {
            JOptionPane.showMessageDialog(null, "This quantity is not valid! Change the quantity");
            return;
        }

        
        OrderLine line = new OrderLine();
        line.setOrderID(this.order.getOrderID());
        line.setProductID(product.getProductID());
        line.setQuantity(quantity1);
        line.setCost(quantity1 * product.getPrice());

        product.setQuantity((product.getQuantity() - quantity1)); // update new quantity
        dataAdapter.saveProduct(product);

        order.getLines().add(line);
        order.setTotalCost(order.getTotalCost() + line.getCost());

        Object[] row = new Object[5]; /*here*/
        row[0] = line.getProductID();
        row[1] = product.getName();
        row[2] = product.getPrice();
        row[3] = line.getQuantity();
        row[4] = line.getCost();
       // row[5] = line.getTax(); /*here*/


        this.view.addRow(row);
        this.view.getLabTotal().setText("Total: " + order.getTotalCost());
        this.view.invalidate();
    }
    
    /**
     * @wbp.parser.entryPoint
     */
//    private void finalCheckout() 
//    {
//    }

}