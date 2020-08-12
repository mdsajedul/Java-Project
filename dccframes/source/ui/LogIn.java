package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class LogIn extends JFrame{

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
   // Border emptyBorder=BorderFactory.createEmptyBorder();

    
    public LogIn(){
       // intcomponent();

        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        intcomponent();

        setVisible(true);


    }
    public void intcomponent(){
        setTitle("Dhaka Corretional Centre");
        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(new Color(0,0,0,150));
        heading.setBounds(0,0,1200,100);

        JLabel name= new JLabel("Dhaka Correctional Centre");
        name.setBounds(250,15,1200,70);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);


        //LogInAss

       JPanel logInAs =new JPanel();
        logInAs.setLayout(null);
        logInAs.setBounds(0, 175, 250,65);
       logInAs.setBackground(new Color(0,0,0,150));
        JLabel logText =new JLabel("Login As");
        logText.setBounds(100, 3, 250,65);
        logText.setFont(lf);
        logText.setForeground(Color.WHITE);
        logInAs.add(logText);

        //LogInMain

        //JPanel logInMain =new JPanel();
      //  logInMain.setLayout(null);
       // logInMain.setBackground(new Color(0,0,0,0));
       // logInMain.setBounds(350, 300, 500,300);

        ImageIcon adminImg =new ImageIcon("images/admin.png");
        
        JButton admin =new JButton(adminImg);
       // admin.setBackground(new Color(0,0,0,150));
        admin.setOpaque(false);
        admin.setContentAreaFilled(false);
        admin.setBorderPainted(false);

        admin.setBounds(260, 300, 250,240);

        admin.setBorder(null);
       
       // logInMain.add(admin);

       ImageIcon doctorImg =new ImageIcon("images/doctor.png");
       JButton doctor =new JButton(doctorImg);
      // doctor.setBackground(new Color(0,0,0,150));

       doctor.setOpaque(false);
       doctor.setContentAreaFilled(false);
       doctor.setBorderPainted(false);

       doctor.setBounds(610, 300, 250,240);

       doctor.setBorder(null);
       //logInMain.add(doctor);


        admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminLogIn al=new AdminLogIn();
                setVisible(false);
                
            }
        });
        
        
        doctor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorLogIn dl=new DoctorLogIn();
                setVisible(false);

            }
        });





        //background
        ImageIcon background_image=new ImageIcon("images/pic.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);

        background.add(heading);
        background.add(logInAs);
        //background.add(logInMain);
        background.add(admin);
        background.add(doctor);
        background.setBounds(0,0,1200,700);
        add(background);

        




       
    }
}




