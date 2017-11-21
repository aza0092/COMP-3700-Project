
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChangeController implements ActionListener 
{
    private PasswordChange passwordChange;
    private DataAdapter dataAdapter;
    
     public PasswordChangeController(PasswordChange passwordChange, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.passwordChange = passwordChange;

        passwordChange.getBtnSave().addActionListener(this);
    }
     
      public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == passwordChange.getBtnSave())
           savePassword();
        }
       
     private void savePassword()
     {
        String userID = passwordChange.getTxtUserID().getText().trim();
        double oldPassword = Double.parseDouble(passwordChange.getTxtOldPassword().getText());
        double newPassword = Double.parseDouble(passwordChange.getTxtNewPassword().getText());
        String role = passwordChange.getTxtRole().getText().trim();
        
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
         boolean newPasswordChange = dataAdapter.passwordChange(userID, oldPassword, newPassword, role);
         
         if (newPasswordChange == false)
         {
            JOptionPane.showMessageDialog(null, "UserID or Password was entered incorrectly. Please re-enter userID and password.");
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Password successfully changed, please log back in with new password.");
            Application.getInstance().getOpeningScreen().setVisible(true); 
         }
     }
}