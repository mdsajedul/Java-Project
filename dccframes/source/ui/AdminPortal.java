package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class AdminPortal extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);


    
    public AdminPortal(){
        intcomponent();

        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        intcomponent();

        setVisible(true);


    }
    public void intcomponent(){
        c=this.getContentPane();
        setTitle("Dhaka Corretional Centre");
        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(Color.BLACK);
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Admin Portal");
        name.setBounds(20,15,1200,70);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);


        //back

        JButton backButton =new JButton("Back");
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setBounds(0, 150, 120,65);
        backButton.setFont(lf);
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LogIn lg=new LogIn();
                setVisible(false);

            }
        });


        //Field
        JPanel portalField =new JPanel();
        portalField.setBackground(new Color(0,0,0,0));
        portalField.setBounds(145,150,945,450);
        portalField.setLayout(new CardLayout());
        portalField.setLayout(new GridLayout(2,2,70,70));
        JButton prisoner =new JButton("Prisoner");
        prisoner.setBackground(new Color(64, 64, 64));
        prisoner.setForeground(Color.WHITE);
        prisoner.setFont(lf);
        portalField.add(prisoner);
        prisoner.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddPrisoner apr=new AddPrisoner();
                setVisible(false);

            }
        });

        JButton guard =new JButton("Guards");
        guard.setBackground(new Color(64, 64, 64));
        guard.setForeground(Color.WHITE);
        guard.setFont(lf);
        portalField.add(guard);
        guard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddGuard gpr=new AddGuard();
                setVisible(false);

            }
        });

        JButton doctor =new JButton("Doctors");
        doctor.setBackground(new Color(64, 64, 64));
        doctor.setForeground(Color.WHITE);
        doctor.setFont(lf);
        portalField.add(doctor);
        doctor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddDoctor adr=new AddDoctor();
                setVisible(false);

            }
        });

        JButton stuff =new JButton("Others Stuffs");
        stuff.setBackground(new Color(64, 64, 64));

        stuff.setForeground(Color.WHITE);
        stuff.setFont(lf);
        portalField.add(stuff);
        stuff.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AddStuffs asf=new AddStuffs();
                setVisible(false);

            }
        });


       



        //background
       // ImageIcon background_image=new ImageIcon("login.jpg");
      // Image img=background_image.getImage();
      //  Image temp_img=img.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
      //  background_image=new ImageIcon(temp_img);
      //  JLabel background=new JLabel("",background_image,JLabel.CENTER);

      // background.add(heading);
      //  background.add(backButton);
       // background.add(portalField);
       // background.setBounds(0,0,1200,700);
       // add(background);
        c.add(heading);
        c.add(backButton);
        c.add(portalField);
        

        c.setBackground(new Color(38, 38, 38));

       
    }
}