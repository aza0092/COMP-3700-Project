import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewReports extends JFrame
{

	 private JButton btnLoadOrderLine = new JButton("load OrderLine");


	    private DefaultTableModel items = new DefaultTableModel();

	    private JTable tblItems = new JTable(items); // null, new String[]{"ProductID", "Product Name", "Price", "Quantity", "Cost"});
	  //  private JLabel labTotal = new JLabel("Total: ");

	    public ViewReports() 
	    {

	        this.setTitle("View Reports");
	        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	        this.setSize(400, 600);


	        items.addColumn("Product ID");
	        items.addColumn("Quantity");
	        items.addColumn("Profit");

	        JPanel panelOrder = new JPanel();
	        panelOrder.setPreferredSize(new Dimension(400, 450));
	        panelOrder.setLayout(new BoxLayout(panelOrder, BoxLayout.PAGE_AXIS));
	        tblItems.setBounds(0, 0, 400, 350);
	        panelOrder.add(tblItems.getTableHeader());
	        panelOrder.add(tblItems);
	        tblItems.setFillsViewportHeight(true);
	        this.getContentPane().add(panelOrder);

	        JPanel panelButton = new JPanel();

	        
	        panelButton.setPreferredSize(new Dimension(400, 100));
	        btnLoadOrderLine.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        panelButton.add(btnLoadOrderLine);
	        this.getContentPane().add(panelButton);

	    }

	    
	    public JButton getBtnLoadOrderLine() 
	    {
	        return btnLoadOrderLine;
	    }

	    public void addRow(Object[] row) 
	    {
	        items.addRow(row);              
	        items.fireTableDataChanged();
	    }
	}