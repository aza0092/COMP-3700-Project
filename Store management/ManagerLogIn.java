import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerLogIn extends JFrame //implements ActionListener
{
    private JTextField txtUserID  = new JTextField(30);
    private JTextField txtPassword  = new JTextField(30);
    
    private JButton btnLogIn = new JButton("Log In");
    
    private DataAdapter dataAdapter;
    private CashierLogIn cashierLogIn;

    public ManagerLogIn() 
    {
        this.setTitle("Manager Log In");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);
        
        JLabel title = new JLabel("Manager Log In");
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
        
         btnLogIn.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getManagerHomeScreen().setVisible(true);
            }
        });
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
}