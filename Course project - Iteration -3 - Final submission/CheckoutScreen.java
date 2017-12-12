import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckoutScreen extends JFrame 
{

    private JButton btnAdd = new JButton("Add a new item");
    private JButton btnPay = new JButton("Finish and Pay");
    private JButton btnPrintReceiptTXT = new JButton("Print receipt as Text File");
    private JButton btnPrintReceiptHTML = new JButton("Print receipt as HTML");


    private DefaultTableModel items = new DefaultTableModel();

    private JTable tblItems = new JTable(items); // null, new String[]{"ProductID", "Product Name", "Price", "Quantity", "Cost"});
    private JLabel labTotal = new JLabel("Total: ");

    public CheckoutScreen() 
    {

        this.setTitle("Checkout");
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(400, 600);


        items.addColumn("Product ID");
        items.addColumn("Name");
        items.addColumn("Price");
        items.addColumn("Quantity");
        items.addColumn("Cost");

        JPanel panelOrder = new JPanel();
        panelOrder.setPreferredSize(new Dimension(400, 450));
        panelOrder.setLayout(new BoxLayout(panelOrder, BoxLayout.PAGE_AXIS));
        tblItems.setBounds(0, 0, 400, 350);
        panelOrder.add(tblItems.getTableHeader());
        panelOrder.add(tblItems);
        panelOrder.add(labTotal);
        tblItems.setFillsViewportHeight(true);
        this.getContentPane().add(panelOrder);

        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panelButton.add(btnAdd);
        btnPay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        panelButton.add(btnPay);
        panelButton.add(btnPrintReceiptTXT);
        panelButton.add(btnPrintReceiptHTML);

        this.getContentPane().add(panelButton);

    }

    public JButton getBtnAdd() 
    {
        return btnAdd;
    }

    public JButton getBtnPay() 
    {
        return btnPay;
    }

    public JLabel getLabTotal() 
    {
        return labTotal;
    }
    
    public JButton getBtnPrintReceiptTXT() 
    {
        return btnPrintReceiptTXT;
    }
    
    public JButton getBtnPrintReceiptHTML() 
    {
        return btnPrintReceiptHTML;
    }

    public void addRow(Object[] row) 
    {
        items.addRow(row);              
        items.fireTableDataChanged();
    }
}