import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageAccount extends JFrame 
{

    private JButton btnChangePassword = new JButton("Change Password");
    private JButton btnChangePic = new JButton("Change Display Picture");

    public ManageAccount() 
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        btnChangePassword.setPreferredSize(new Dimension(150, 50));
        btnChangePic.setPreferredSize(new Dimension(180, 50));


        JLabel title = new JLabel("Manage Account");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnChangePassword);
        panelButton.add(btnChangePic);

        this.getContentPane().add(panelButton);

        btnChangePassword.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
              Application.getInstance().getPasswordChange().setVisible(true);            
            }
        });
        
        btnChangePic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Application.getInstance().getPictureChange().setVisible(true);
            }
        });
    }


}

