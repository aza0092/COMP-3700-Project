import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerHomeScreen extends JFrame 
{

	 NewUser user;
	    private Connection connection;
	    String name = "";
	    String role = "";

    private JButton btnManage = new JButton("Manage Products");
    private JButton btnCreateUser = new JButton("Create New User");
    private JButton btnReports = new JButton("View Reports");
    private JButton btnChangePassword = new JButton("Manage Account");
    private final JLabel lblNewLabel = new JLabel("");
    

    public ManagerHomeScreen() 
    {
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(430, 316);

        btnManage.setPreferredSize(new Dimension(150, 50));
        btnCreateUser.setPreferredSize(new Dimension(150, 50));
        btnReports.setPreferredSize(new Dimension(140, 50));
        btnChangePassword.setPreferredSize(new Dimension(150, 50));
        lblNewLabel.setPreferredSize(new Dimension(100, 100));
        Image images = new ImageIcon(this.getClass().getResource("/manager.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(images));


        JLabel title = new JLabel("Manager Home Screen");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        
        panelTitle.add(lblNewLabel);
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnManage);
        panelButton.add(btnCreateUser);
        panelButton.add(btnReports);
        panelButton.add(btnChangePassword);

        this.getContentPane().add(panelButton);

        btnManage.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getProductView().setVisible(true);
            }
        });
        
        btnChangePassword.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               Application.getInstance().getManageAccount().setVisible(true);
           }
        });
        
        btnCreateUser.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               Application.getInstance().getNewUser().setVisible(true);
           }
        });
        
        btnReports.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Application.getInstance().getViewReports().setVisible(true);
            }
        });
    }
}
