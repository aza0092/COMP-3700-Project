import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierHomeScreen extends JFrame
{

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage = new JButton("Manage Account");

    public CashierHomeScreen() 
    {
    	
        getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        btnManage.setPreferredSize(new Dimension(140, 50));
        btnCheckout.setPreferredSize(new Dimension(140, 50));


        JLabel title = new JLabel("Cashier Home Screen");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitle.add(lblNewLabel);
        lblNewLabel.setPreferredSize(new Dimension(100,100));
        Image images = new ImageIcon(this.getClass().getResource("/cashier.jpg")).getImage();
        lblNewLabel.setIcon(new ImageIcon(images));

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
