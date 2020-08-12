package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class DoctorList extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    Connection con;
    ResultSet rs;


    
    public DoctorList(){
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
        

        JButton addDoctor =new JButton("Add Doctor");
        addDoctor.setBackground(new Color(64, 64, 64));
        addDoctor.setForeground(Color.WHITE);

        option.add(addDoctor);
        addDoctor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AddDoctor adr=new AddDoctor();
                setVisible(false);

            }
        });

        JButton deleteDoctor=new JButton("Delete Doctor");
        deleteDoctor.setBackground(new Color(64, 64, 64));
        deleteDoctor.setForeground(Color.WHITE);
        option.add(deleteDoctor);
        deleteDoctor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DeleteDoctor rpr=new DeleteDoctor();
                setVisible(false);

            }
        });

        JButton doctorList =new JButton("Doctor Profile");
        doctorList.setBackground(new Color(64, 64, 64));
        doctorList.setForeground(Color.WHITE);
        option.add(doctorList);
        doctorList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DoctorList prl=new DoctorList();
                setVisible(false);

            }
        });


        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(new Color(0,0,0,150));
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Doctor Profile");
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

        JLabel searchDoctor =new JLabel("Enter Doctor Id");
        searchDoctor.setFont(fieldF);
        searchDoctor.setForeground(Color.WHITE);
        searchDoctor.setBounds(15,25,170,50);
        addField.add(searchDoctor);

        JTextField searchDoctorText =new JTextField();
        searchDoctorText.setBounds(180,35,200,40);
        searchDoctor.setFont(fieldF);
        addField.add(searchDoctorText);

        JButton search =new JButton("Search");
        search.setFont(fieldF);
        search.setBackground(new Color(64, 64, 64));
        search.setForeground(Color.WHITE);
        search.setBounds(365,35,120,40);
        addField.add(search);

        //sub panel
        JLabel dId=new JLabel("Doctor Id");
        dId.setBounds(15,90,130,30);
        dId.setFont(subF);
        dId.setForeground(Color.WHITE);
        addField.add(dId);
                    
        JTextField dIdn=new JTextField();
        dIdn.setBounds(160,90,150,30);
        dIdn.setFont(subF);
      addField.add(dIdn);
                            
                                            
   JLabel dName=new JLabel("Name");
   dName.setBounds(15,140,130,30);
   dName.setFont(subF);
   dName.setForeground(Color.WHITE);
   addField.add(dName);
 
   JTextField dNamen=new JTextField();
   dNamen.setBounds(160,140,150,30);
   dNamen.setFont(subF);
   addField.add(dNamen);
                    
   JLabel dAge=new JLabel("Age");
   dAge.setBounds(15,190,130,30);
   dAge.setFont(subF);
   dAge.setForeground(Color.WHITE);
   addField.add(dAge);
 
   JTextField dAgen=new JTextField();
   dAgen.setBounds(160,190,150,30);
   dAgen.setFont(subF);
   addField.add(dAgen);
                    
   JLabel dEmail=new JLabel("Email:");
   dEmail.setBounds(15,240,130,30);
   dEmail.setFont(subF);
   dEmail.setForeground(Color.WHITE);
   addField.add(dEmail);
 
   JTextField dEmailn=new JTextField();
   dEmailn.setBounds(160,240,150,30);
   dEmailn.setFont(subF);
   addField.add(dEmailn);
                    
   JLabel dDob=new JLabel("Date of Birth:");
   dDob.setBounds(15,290,130,30);
   dDob.setFont(subF);
   dDob.setForeground(Color.WHITE);
   addField.add(dDob);
 
   JTextField dDobn=new JTextField();
   dDobn.setBounds(160,290,150,30);
   dDobn.setFont(subF);
   addField.add(dDobn);
 
                    
   JLabel dSex=new JLabel("Sex");
   dSex.setBounds(15,340,130,30);
   dSex.setFont(subF);
   dSex.setForeground(Color.WHITE);
   addField.add(dSex);
 
   JTextField dSexn=new JTextField();
   dSexn.setBounds(160,340,150,30);
   dSexn.setFont(subF);
   addField.add(dSexn);
                    
   JLabel dAddress=new JLabel("Address");
   dAddress.setBounds(15,390,130,30);
   dAddress.setFont(subF);
   dAddress.setForeground(Color.WHITE);
   addField.add(dAddress);
 
 
   JTextField dAddressn =new JTextField();
   dAddressn.setBounds(160,390,150,30);
   dAddressn.setFont(subF);
   addField.add(dAddressn);
  
                    
                    
 
           JLabel dEntry=new JLabel("Joining Date");
           dEntry.setBounds(490,140,130,30);
           dEntry.setFont(subF);
           dEntry.setForeground(Color.WHITE);
           addField.add(dEntry);
 
           JTextField dEntryn=new JTextField();
           dEntryn.setBounds(635,140,150,30);
           dEntryn.setFont(subF);
           addField.add(dEntryn);
 
 
           search.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 try{
                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Dcc","root","");
                     String sql="Select * from doctor where doctorId =?";
                     PreparedStatement pst =con.prepareStatement(sql);
                     pst.setString(1, searchDoctorText.getText());
                     rs=pst.executeQuery();
                     if(rs.next()){
                         
 
                         String setId =rs.getString("doctorId");
                         dIdn.setText(setId);
 
                         String setName=rs.getString("dFirstName");
                         dNamen.setText(setName);
 
                         String setAge=rs.getString("dAge");
                         dAgen.setText(setAge);
 
                         String setEmail=rs.getString("email");
                         dEmailn.setText(setEmail);
 
                         String setDob=rs.getString("dDob");
                         dDobn.setText(setDob);
 
                         String setSex=rs.getString("dSex");
                         dSexn.setText(setSex);
 
                         String setAddress=rs.getString("dAddress");
                         dAddressn.setText(setAddress);
 
                        String setEntry=rs.getString("dEntry");
                        dEntryn.setText(setEntry);
 
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
 
        //sub panel
    
       

        c.add(option);
        c.add(heading);
        c.add(backButton);
        c.add(addField);


        c.setBackground(new Color(38, 38, 38));




       
    }
}