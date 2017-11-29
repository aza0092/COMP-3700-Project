import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserController implements ActionListener 
{
    private NewUser newUser;
    private DataAdapter dataAdapter;
    
     public NewUserController(NewUser newUser, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.newUser = newUser;

        newUser.getBtnAdd().addActionListener(this);
    }
     
      public void actionPerformed(ActionEvent e) 
        {
        if (e.getSource() == newUser.getBtnAdd())
           addNewUser();
        }
       
     private void addNewUser()
     {
        String newUserName = newUser.getTxtNewUserName().getText().trim();
        String newUserRole = newUser.getTxtNewUserRole().getText().trim();

        
         if (newUserName.length() == 0) 
        {
            JOptionPane.showMessageDialog(null, "Invalid user name! Please provide a non-empty user name!");
            return;
        }
         Boolean stop = false;
          if (newUserRole.equals("manager")) {
             	JOptionPane.showMessageDialog(null, "New user created! Check default password in database");
             	stop = true;
          }
         	
          else if (newUserRole.equals("cashier")) {
             	JOptionPane.showMessageDialog(null, "New user created! Check default password in database");
           //  	user.setRole(role);
             	stop = true;
          }
          else {
           	JOptionPane.showMessageDialog(null, "please only type (manager) or (cashier)");
           	newUserRole = newUser.getTxtNewUserRole().getText().trim();
          }
         boolean newUser = dataAdapter.addNewUser(newUserName, newUserRole);
     }
}
