import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.*;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;  
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.applet.*;
import java.applet.Applet;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class ManageAccount extends JFrame
{
	
    private JButton btnChangePassword = new JButton("Change Password");
    private JButton btnChangePic = new JButton("Change Display Picture");


    public ManageAccount() 
    {   
    	
    	//private List<BufferedImage> list = new ArrayList<BufferedImage>();

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
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitle.add(lblNewLabel);
        lblNewLabel.setPreferredSize(new Dimension(100,100));
        
//        JLabel lblNewLabel = new JLabel(icon);
//        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panelTitle.add(lblNewLabel);
//        lblNewLabel.setPreferredSize(new Dimension(100,100));
       // Image images = new ImageIcon(this.getClass().getResource(path)).getImage();
      //  lblNewLabel.setIcon(new ImageIcon(images));

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
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                 //if the user click on save in Jfilechooser
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                  //  lblNewLabel.setText(path);
               	 ImageIcon icon = new ImageIcon(path);

                    lblNewLabel.setIcon((icon));
                    
                
//
//                    ArrayList<Image> cards = new ArrayList<Image>();
//                    		cards.add(new Image(path));
                    		


                  //  lblNewLabel = new JLabel(icon);

                //    lblNewLabel.setIcon(new ImageIcon(path));
                    
                    //Image images = new ImageIcon(this.getClass().getResource(path)).getImage();
                 //   buffImg = ImageIO.read(new File(path));
                   // lblNewLabel.add(new JLabel(new ImageIcon(path)));

                  //  lblNewLabel.setIcon(new ImageIcon(images));
                    

                }
                 //if the user click on save in Jfilechooser


                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
            }
        });
    }


}
