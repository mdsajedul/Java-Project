package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class DoctorPortal extends JFrame{

   // private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);


    
    public DoctorPortal(){
        intcomponent();

        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        intcomponent();

        setVisible(true);


    }
    public void intcomponent(){
       // c=this.getContentPane();
        setTitle("Dhaka Corretional Centre");
        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(Color.BLACK);
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Doctor Portal");
        name.setBounds(20,15,1200,70);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);


       // back;

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
        JButton Profile =new JButton("Profile");
        Profile.setBackground(new Color(64, 64, 64));
        Profile.setForeground(Color.WHITE);
        Profile.setFont(lf);
        Profile.setFont(lf);
        portalField.add(Profile);
        Profile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorProfile dpr=new  DoctorProfile();
                setVisible(false);

            }
        });

       JButton PrisonerList =new JButton("Prisoner  List");
       PrisonerList.setBackground(Color.DARK_GRAY);
        PrisonerList.setForeground(Color.WHITE);
        PrisonerList.setFont(lf);
        portalField.add( PrisonerList);
        PrisonerList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorPrisonerList dpl=new  DoctorPrisonerList();
                setVisible(false);

           }
        });
         




       


      ImageIcon background_image=new ImageIcon("images/doctorportal.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);


      // background.add(heading);
      //  background.add(backButton);
       // background.add(portalField);
       // background.setBounds(0,0,1200,700);
       // c.add(background);
        background.add(heading);
        background.add(backButton);
        background.add(portalField);
      //  c.add(background);
        

       // c.setBackground(Color.DARK_GRAY);
        background.setBounds(0,0,1200,700);
        add(background);


       
    }
  }