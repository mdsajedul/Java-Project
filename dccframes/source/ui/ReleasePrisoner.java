package ui;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import services.*;

public class ReleasePrisoner extends JFrame{
    Connection con;
    ResultSet rs;

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    UserService us=new UserService();
    RemoveService removeS=new RemoveService();


    
    public ReleasePrisoner(){
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



        //Option
        JPanel option =new JPanel();
        option.setLayout(new FlowLayout(5));
        option.setBounds(0,0,1200,25);
        option.setBackground(new Color(38, 38, 38));
        

        JButton addPrisoner =new JButton("Add Prisoner");
        addPrisoner.setBackground(new Color(64, 64, 64));
        addPrisoner.setForeground(Color.WHITE);

        option.add(addPrisoner);
        addPrisoner.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AddPrisoner apr=new AddPrisoner();
                setVisible(false);

            }
        });

        JButton releasePrisoner=new JButton("Release Prisoner");
        releasePrisoner.setBackground(new Color(64, 64, 64));
        releasePrisoner.setForeground(Color.WHITE);
        option.add(releasePrisoner);
        releasePrisoner.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ReleasePrisoner rpr=new ReleasePrisoner();
                setVisible(false);

            }
        });

        JButton prisonerList =new JButton("Prisoner Profile");
        prisonerList.setBackground(new Color(64, 64, 64)); 
        prisonerList.setForeground(Color.WHITE);
        option.add(prisonerList);
        prisonerList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PrisonerList prl=new PrisonerList();
                setVisible(false);

            }
        });


        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(new Color(0,0,0,150));
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Release Prisoner");
        name.setBounds(20,15,1200,70);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);


        //back

        JButton backButton =new JButton("Back");
        backButton.setBackground(new Color(64, 64, 64));
        backButton.setBounds(0, 150, 120,65);
        backButton.setFont(lf);
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AdminPortal apl=new AdminPortal();
                setVisible(false);

            }
        });


        //Field
       
        JPanel addField =new JPanel();
        addField.setBackground(new Color(0,0,0,0));
        addField.setBounds(145,150,1200,480);
        addField.setLayout (null);
                 

        JLabel searchPrisoner =new JLabel("Enter Prisoner Id");
        searchPrisoner.setFont(fieldF);
        searchPrisoner.setForeground(Color.WHITE);
        searchPrisoner.setBounds(15,25,170,50);
        addField.add(searchPrisoner);

        JTextField searchPrisonerText =new JTextField();
        searchPrisonerText.setBounds(180,35,200,40);
        searchPrisonerText.setFont(fieldF);
        addField.add(searchPrisonerText);

        JButton search =new JButton("Search");
        search.setFont(fieldF);
        search.setBackground(new Color(64, 64, 64));
        search.setForeground(Color.WHITE);
        search.setBounds(365,35,120,40);
        addField.add(search);
       

       
                           
                   
       JLabel pId=new JLabel("Prison Id:");
       pId.setBounds(15,90,130,30);
       pId.setFont(subF);
       pId.setForeground(Color.WHITE);
       addField.add(pId);
                   
       JTextField pIdn=new JTextField();
      pIdn.setBounds(160,90,150,30);
     pIdn.setFont(subF);
     addField.add(pIdn);
                           
                                           
  JLabel pName=new JLabel("Name");
  pName.setBounds(15,140,130,30);
  pName.setFont(subF);
  pName.setForeground(Color.WHITE);
  addField.add(pName);

  JTextField pNamen=new JTextField();
  pNamen.setBounds(160,140,150,30);
  pNamen.setFont(subF);
  addField.add(pNamen);
                   
  

          search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Dcc","root","");
                    String sql="Select * from prisoner where prisonerId =?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setString(1, searchPrisonerText.getText());
                    rs=pst.executeQuery();
                    if(rs.next()){
                        

                        String setId =rs.getString("prisonerId");
                        pIdn.setText(setId);

                        String setName=rs.getString("pFirstName");
                        pNamen.setText(setName);


                       
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Not Found!!");
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
                   
            }
        });


        

        
         //Release button

         JButton releaseButton =new JButton("Release");
         releaseButton.setBounds(870, 45, 120, 50);
         releaseButton.setBackground(new Color(64, 64, 64));
         releaseButton.setForeground(Color.WHITE);
         releaseButton.setFont(logf);
        addField.add(releaseButton);






        releaseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(searchPrisonerText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Prisoner Id Requaird !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(removeS.prisonerRemove(searchPrisonerText.getText())){
                        JOptionPane.showMessageDialog(null,"Remove  Successfull !!","Remove",JOptionPane.INFORMATION_MESSAGE);
                       
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Not Found  !!","Remove",JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        });


        c.add(option);
        c.add(heading);
        c.add(backButton);
        c.add(addField);


        c.setBackground(new Color(38, 38, 38));




       
    }
}