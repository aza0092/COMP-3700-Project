import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomeScreen extends JFrame 
{

    private JButton btnManage = new JButton("Manage Products");
    private JButton btnCreateUser = new JButton("Create New User");
    private JButton btnReports = new JButton("View Reports");
    

    public ManagerHomeScreen() 
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        btnManage.setPreferredSize(new Dimension(150, 50));
        btnCreateUser.setPreferredSize(new Dimension(150, 50));
        btnReports.setPreferredSize(new Dimension(140, 50));


        JLabel title = new JLabel("Manager Home Screen");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnManage);
        panelButton.add(btnCreateUser);
        panelButton.add(btnReports);

        this.getContentPane().add(panelButton);

        btnManage.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getProductView().setVisible(true);
            }
        });
        
        btnCreateUser.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               //Application.getInstance().getCreateNewUser().setVisible(true);
           }
        });
        
        btnReports.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               // Application.getInstance().getViewReports().setVisible(true);
            }
        });
    }


}
