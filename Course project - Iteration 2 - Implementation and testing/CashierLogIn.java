import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierLogIn extends JFrame //implements ActionListener
{
    private JTextField txtUserID  = new JTextField(30);
    private JTextField txtPassword  = new JTextField(30);
    
    private JButton btnLogIn = new JButton("Log In");
    
    private DataAdapter dataAdapter;
    private CashierLogIn cashierLogIn;

    public CashierLogIn() 
    {
        this.setTitle("Cashier Log In");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);
        
        JLabel title = new JLabel("Cashier Log In");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
        
        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserID);
        txtUserID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);
        
        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        txtPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelPassword);
        
        JPanel panelButton = new JPanel();
        panelButton.add(btnLogIn);
        this.getContentPane().add(panelButton);
        
        /* btnLogIn.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getCashierHomeScreen().setVisible(true);
            }
        });*/
    }
    
    
    public JButton getBtnLogIn() 
    {
        return btnLogIn;
    }
    
    public JTextField getTxtUserID() 
    {
        return txtUserID;
    }
    
    public JTextField getTxtPassword()
    {
        return txtPassword;
    }
    
     
   /*public void CLogInController(CashierLogIn cashierLogIn, DataAdapter dataAdapter)
    {
        cashierLogIn.getBtnLogIn().addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == getBtnLogIn())
            JOptionPane.showMessageDialog(null, "YOU CAN CLICK THE BUTTON AND I WORK!");
        }
       
     private void logIn()
     {
      
        String userID = getTxtUserID().getText().trim();
        String password = getTxtPassword().getText().trim();
         
         
        if (userID.length() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Invalid user name! Please provide a non-empty user name!");
            return;
        }
         
        
        if (userID == null) 
        {
            JOptionPane.showMessageDialog(null, "This user name does not exist in the database!");
            return;
        }
        
         boolean cashierLogIn = dataAdapter.logIn(userID, password);
         
         if (cashierLogIn == false)
         {
             JOptionPane.showMessageDialog(null, "UserID or Password was entered incorrectly. Please re-enter userID and password.");
         }
         else
         {
             Application.getInstance().getCashierHomeScreen().setVisible(true); 
         }
     }*/
}
