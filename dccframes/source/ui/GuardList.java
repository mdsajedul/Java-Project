package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import services.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class GuardList extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    Connection con;
    ResultSet rs;


    
    public GuardList(){
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
        

        JButton addGuard =new JButton("Add Guard");
        addGuard.setBackground(new Color(64, 64, 64));
        addGuard.setForeground(Color.WHITE);

        option.add(addGuard);
        addGuard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AddGuard agd=new AddGuard();
                setVisible(false);

            }
        });

        JButton removeGuard=new JButton("Remove Guard");
        removeGuard.setBackground(new Color(64, 64, 64));
        removeGuard.setForeground(Color.WHITE);
        option.add(removeGuard);
        removeGuard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                RemoveGuard rgd=new RemoveGuard();
                setVisible(false);

            }
        });

        JButton GuardList =new JButton("Guard Profile");
        GuardList.setBackground(new Color(64, 64, 64));
        GuardList.setForeground(Color.WHITE);
        option.add(GuardList);
        GuardList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GuardList gdl=new GuardList();
                setVisible(false);

            }
        });


        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(new Color(0,0,0,150));
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Guard Profile");
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

        JLabel searchGuard =new JLabel("Enter Guard Id");
        searchGuard.setFont(fieldF);
        searchGuard.setForeground(Color.WHITE);
        searchGuard.setBounds(15,25,170,50);
        addField.add(searchGuard);

        JTextField searchGuardText =new JTextField();
        searchGuardText.setBounds(180,35,200,40);
        searchGuardText.setFont(fieldF);
        addField.add(searchGuardText);

        JButton search =new JButton("Search");
        search.setFont(fieldF);
        search.setBackground(new Color(64, 64, 64));
        search.setForeground(Color.WHITE);
        search.setBounds(365,35,120,40);
        addField.add(search);

        //sub panel
            
        JLabel gId=new JLabel("Prison Id:");
        gId.setBounds(15,90,130,30);
        gId.setFont(subF);
        gId.setForeground(Color.WHITE);
        addField.add(gId);
                    
        JTextField gIdn=new JTextField();
        gIdn.setBounds(160,90,150,30);
        gIdn.setFont(subF);
      addField.add(gIdn);

        JLabel gName=new JLabel("Name");
        gName.setBounds(15,140,130,30);
        gName.setFont(subF);
        gName.setForeground(Color.WHITE);
        addField.add(gName);

  JTextField gNamen=new JTextField();
  gNamen.setBounds(160,140,150,30);
  gNamen.setFont(subF);
  addField.add(gNamen);
                   
  JLabel gAge=new JLabel("Age");
  gAge.setBounds(15,190,130,30);
  gAge.setFont(subF);
  gAge.setForeground(Color.WHITE);
  addField.add(gAge);

  JTextField gAgen=new JTextField();
  gAgen.setBounds(160,190,150,30);
  gAgen.setFont(subF);
  addField.add(gAgen);
                   
  JLabel gParent=new JLabel("Parent's Name:");
  gParent.setBounds(15,240,130,30);
  gParent.setFont(subF);
  gParent.setForeground(Color.WHITE);
  addField.add(gParent);

  JTextField gParentn=new JTextField();
  gParentn.setBounds(160,240,150,30);
  gParentn.setFont(subF);
  addField.add(gParentn);
                   
  JLabel gDob=new JLabel("Date of Birth:");
  gDob.setBounds(15,290,130,30);
  gDob.setFont(subF);
  gDob.setForeground(Color.WHITE);
  addField.add(gDob);

  JTextField gDobn=new JTextField();
  gDobn.setBounds(160,290,150,30);
  gDobn.setFont(subF);
  addField.add(gDobn);

                   
  JLabel gSex=new JLabel("Sex");
  gSex.setBounds(15,340,130,30);
  gSex.setFont(subF);
  gSex.setForeground(Color.WHITE);
  addField.add(gSex);

  JTextField gSexn=new JTextField();
  gSexn.setBounds(160,340,150,30);
  gSexn.setFont(subF);
  addField.add(gSexn);
                   
  JLabel gAddress=new JLabel("Address");
  gAddress.setBounds(15,390,130,30);
  gAddress.setFont(subF);
  gAddress.setForeground(Color.WHITE);
  addField.add(gAddress);


  JTextField gAddressn =new JTextField();
  gAddressn.setBounds(160,390,150,30);
  gAddressn.setFont(subF);
  addField.add(gAddressn);
                   
 
           
                   
            JLabel gPhone=new JLabel("Phone");
            gPhone.setBounds(490,140,130,30);
            gPhone.setFont(subF);
            gPhone.setForeground(Color.WHITE);
           addField.add(gPhone);
           
          JTextField gPhonen=new JTextField();
          gPhonen.setBounds(635,140,150,30);
          gPhonen.setFont(subF);
         addField.add(gPhonen);

          JLabel gEntry=new JLabel("Joining Date");
          gEntry.setBounds(490,190,130,30);
          gEntry.setFont(subF);
          gEntry.setForeground(Color.WHITE);
          addField.add(gEntry);

          JTextField gEntryn=new JTextField();
          gEntryn.setBounds(635,190,150,30);
          gEntryn.setFont(subF);
          addField.add(gEntryn);


          search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Dcc","root","");
                    String sql="Select * from guard where guardId =?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setString(1, searchGuardText.getText());
                    rs=pst.executeQuery();
                    if(rs.next()){
                        

                        String setId =rs.getString("guardId");
                        gIdn.setText(setId);

                        String setName=rs.getString("gFirstName");
                        gNamen.setText(setName);

                        String setAge=rs.getString("gAge");
                        gAgen.setText(setAge);

                        String setParentName=rs.getString("gParentName");
                        gParentn.setText(setParentName);

                        String setDob=rs.getString("gDob");
                        gDobn.setText(setDob);

                        String setSex=rs.getString("gSex");
                        gSexn.setText(setSex);

                        String setAddress=rs.getString("gAddress");
                        gAddressn.setText(setAddress);


                       String setPhone=rs.getString("gPhone");
                       gPhonen.setText(setPhone);

                       String setEntry=rs.getString("startDate");
                       gEntryn.setText(setEntry);

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
    
       

        c.add(option);
        c.add(heading);
        c.add(backButton);
        c.add(addField);


        c.setBackground(new Color(38, 38, 38));




       
    }
}