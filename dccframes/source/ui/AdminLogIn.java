package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class AdminLogIn extends JFrame{

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    LoginService ls=new LoginService();



    
    public AdminLogIn(){
        intcomponent();

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
        heading.setBounds(0,25,1200,100);

        JLabel name= new JLabel("Dhaka Correctional Centre");
        name.setBounds(250,15,1200,70);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);


        //back

        JButton backButton =new JButton("Back");
     //   backButton.setBackground(new Color(0,0,0,150));
        backButton.setBackground(Color.BLACK);
        backButton.setBounds(0, 150, 120,65);
        backButton.setFont(lf);
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LogIn lg=new LogIn();
                setVisible(false);

            }
        });


        //LogInBox

        JPanel logInBox =new JPanel();
        logInBox.setLayout(null);
        logInBox.setBackground(new Color(0,0,0,150));
        logInBox.setBounds(350, 160, 450,465);

        JLabel loginTitle=new JLabel("Login Here");
        loginTitle.setBounds(35,20,450,60);
        loginTitle.setFont(f);
        loginTitle.setForeground(Color.WHITE);
        logInBox.add(loginTitle);

        JLabel loginSubTitle=new JLabel("Admin Login Panel");
        loginSubTitle.setBounds(35,80,450,60);
        loginSubTitle.setFont(logf);
        loginSubTitle.setForeground(Color.WHITE); 
        logInBox.add(loginSubTitle);       

       JLabel userName=new JLabel("Username");
       userName.setBounds(35,180,120,60);
       userName.setFont(logf);
       userName.setForeground(Color.WHITE); 
       logInBox.add(userName);   
       
       JTextField userText =new JTextField();
        userText.setBounds(155,185,250,55);
        userText.setFont(logf);
        logInBox.add(userText);

        JLabel password=new JLabel("Password");
        password.setBounds(35,270,120,60);
        password.setFont(logf);
        password.setForeground(Color.WHITE); 
        logInBox.add(password);

        JPasswordField passwordText =new JPasswordField();
        passwordText.setBounds(155,275,250,55);
        passwordText.setFont(logf);
        logInBox.add(passwordText); 

        JButton loginButton =new JButton("Login");
        loginButton.setBounds(282,370,120,55);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(logf);
        logInBox.add(loginButton);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


                if(userText.getText().isEmpty() && passwordText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"username & password not inserted!","Username & Pasword",JOptionPane.ERROR_MESSAGE);
                }

                else if(userText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Username not inserted","Username",JOptionPane.ERROR_MESSAGE);
                }
                else if(passwordText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Password not interted","Passworld",JOptionPane.ERROR_MESSAGE);

                }
                else{
                     if(ls.adminValidation(userText.getText(),passwordText.getText())){
                        JOptionPane.showMessageDialog(null,"Login Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        AdminPortal ap=new AdminPortal();
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Login Failed !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                  
                }
                
                
            }
        });



        //background
        ImageIcon background_image=new ImageIcon("images/login.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);

        background.add(heading);
        background.add(backButton);
        background.add(logInBox);
        background.setBounds(0,0,1200,700);
        add(background);




       
    }
}




