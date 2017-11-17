import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierHomeScreen extends JFrame 
{

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage = new JButton("Manage Account");

    public CashierHomeScreen() 
    {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        btnManage.setPreferredSize(new Dimension(140, 50));
        btnCheckout.setPreferredSize(new Dimension(140, 50));


        JLabel title = new JLabel("Cashier Home Screen");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnManage);

        this.getContentPane().add(panelButton);

        btnCheckout.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                Application.getInstance().getCheckoutScreen().setVisible(true);            
            }
        });
        
        btnManage.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Application.getInstance().getManageAccount().setVisible(true);
            }
        });
    }


}
