import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser extends JFrame
{
	    private JTextField txtNewUserName  = new JTextField(30);
	    private JTextField txtNewUserRole  = new JTextField(30);
	    
	    private JButton btnAdd = new JButton("Add New User");
	    
	    private DataAdapter dataAdapter;

	    public NewUser() 
	    {
	        this.setTitle("New User");
	        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
	        this.setSize(500, 200);
	        
	        JLabel title = new JLabel("New User");
	        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
	        JPanel panelTitle = new JPanel();
	        panelTitle.add(title);
	        this.getContentPane().add(panelTitle);
	        
	        JPanel panelNewUserName = new JPanel();
	        panelNewUserName.add(new JLabel("New User Name: "));
	        panelNewUserName.add(txtNewUserName);
	        txtNewUserName.setHorizontalAlignment(JTextField.RIGHT);
	        this.getContentPane().add(panelNewUserName);
	        
	        JPanel panelNewUserRole = new JPanel();
	        panelNewUserRole.add(new JLabel("New User Role(manager/cashier): "));
	        panelNewUserRole.add(txtNewUserRole);
	        txtNewUserRole.setHorizontalAlignment(JTextField.RIGHT);
	        this.getContentPane().add(panelNewUserRole);
	        
	        JPanel panelButton = new JPanel();
	        panelButton.add(btnAdd);
	        this.getContentPane().add(panelButton);
	    }
	    
	    
	    public JButton getBtnAdd() 
	    {
	        return btnAdd;
	    }
	    
	    public JTextField getTxtNewUserName() 
	    {
	        return txtNewUserName;
	    }
	    
	    public JTextField getTxtNewUserRole()
	    {
	        return txtNewUserRole;
	    }
	}