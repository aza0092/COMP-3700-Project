
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLogInController implements ActionListener 
{
    private CashierLogIn cashierLogIn;
    private DataAdapter dataAdapter;
    
     public CLogInController(CashierLogIn cashierLogIn, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.cashierLogIn = cashierLogIn;

        cashierLogIn.getBtnLogIn().addActionListener(this);
    }
     
      public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == cashierLogIn.getBtnLogIn())
           logIn();
        }
       
     private void logIn()
     {
        String userID = cashierLogIn.getTxtUserID().getText().trim();
        double password = Double.parseDouble(cashierLogIn.getTxtPassword().getText());
        
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
         boolean cashierLogIn = dataAdapter.cLogIn(userID, password);
         
         if (cashierLogIn == false)
         {
             JOptionPane.showMessageDialog(null, "UserID or Password was entered incorrectly. Please re-enter userID and password.");
         }
         else
         {
             Application.getInstance().getCashierHomeScreen().setVisible(true); 
         }
     }
}
