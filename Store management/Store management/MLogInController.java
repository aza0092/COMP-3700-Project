
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MLogInController implements ActionListener 
{
    private ManagerLogIn managerLogIn;
    private DataAdapter dataAdapter;
    
     public MLogInController(ManagerLogIn managerLogIn, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.managerLogIn = managerLogIn;

        managerLogIn.getBtnLogIn().addActionListener(this);
    }
     
      public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == managerLogIn.getBtnLogIn())
           logIn();
        }
       
     private void logIn()
     {
        String userID = managerLogIn.getTxtUserID().getText().trim();
        double password = Double.parseDouble(managerLogIn.getTxtPassword().getText());
        
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
         boolean managerLogIn = dataAdapter.mLogIn(userID, password);
         
         if (managerLogIn == false)
         {
             JOptionPane.showMessageDialog(null, "UserID or Password was entered incorrectly. Please re-enter userID and password.");
         }
         else
         {
             Application.getInstance().getManagerHomeScreen().setVisible(true); 
         }
     }
}
