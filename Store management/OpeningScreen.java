import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * 
 */
public class OpeningScreen extends JFrame 
{
    private JButton btnCashier = new JButton("Cashier Log In");
    private JButton btnManager   = new JButton("Manager Log In");
    
    public OpeningScreen()
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        btnCashier.setPreferredSize(new Dimension(120, 50));
        btnManager.setPreferredSize(new Dimension(130, 50));


        JLabel title = new JLabel("Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
                
        JPanel panelButton = new JPanel();
        panelButton.add(btnCashier);
        panelButton.add(btnManager);

        this.getContentPane().add(panelButton);
        
         btnCashier.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getCashierLogIn().setVisible(true);            
            }
        });

        btnManager.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getManagerLogIn().setVisible(true);
            }
        });
    }
}
