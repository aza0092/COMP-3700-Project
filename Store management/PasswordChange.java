import javax.swing.*;
import java.awt.*;

public class PasswordChange extends JFrame //create the controller to update and change the passwords in the database.
{
    private JTextField txtOldPassword  = new JTextField(20);
    private JTextField txtUserID = new JTextField(30);
    private JTextField txtNewPassword  = new JTextField(20);
    
    private JButton btnSave = new JButton("Save New Password");

    public PasswordChange() 
    {
        this.setTitle("Password Change");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 300);
        btnSave.setPreferredSize(new Dimension(180, 50));
        
        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserID);
        txtUserID.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);
        
        JPanel panelOldPassword = new JPanel();
        panelOldPassword.add(new JLabel("Old Password: "));
        panelOldPassword.add(txtOldPassword);
        txtOldPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelOldPassword);
        
        JPanel panelNewPassword = new JPanel();
        panelNewPassword.add(new JLabel("New Password: "));
        panelNewPassword.add(txtNewPassword);
        txtNewPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelNewPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnSave);
        this.getContentPane().add(panelButton);
    }
    
    public JButton getBtnSave() 
    {
        return btnSave;
    }

    public JTextField getTxtUserID() 
    {
        return txtUserID;
    }

    public JTextField getTxtOldPassword() 
    {
        return txtOldPassword;
    }

    public JTextField getTxtNewPassword() 
    {
        return txtNewPassword;
    }
}
