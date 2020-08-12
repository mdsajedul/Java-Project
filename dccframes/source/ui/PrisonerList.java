package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import services.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;


public class PrisonerList extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    Connection con;
    ResultSet rs;

    
    private JScrollPane jScrollPane1;
    private JTable jTable1;


    
    public PrisonerList(){
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

        JLabel name= new JLabel("Prisoner Profile");
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
                   
  JLabel pAge=new JLabel("Age");
  pAge.setBounds(15,190,130,30);
  pAge.setFont(subF);
  pAge.setForeground(Color.WHITE);
  addField.add(pAge);

  JTextField pAgen=new JTextField();
  pAgen.setBounds(160,190,150,30);
  pAgen.setFont(subF);
  addField.add(pAgen);
                   
  JLabel pParent=new JLabel("Parent's Name:");
  pParent.setBounds(15,240,130,30);
  pParent.setFont(subF);
  pParent.setForeground(Color.WHITE);
  addField.add(pParent);

  JTextField pParentn=new JTextField();
  pParentn.setBounds(160,240,150,30);
  pParentn.setFont(subF);
  addField.add(pParentn);
                   
  JLabel pDob=new JLabel("Date of Birth:");
  pDob.setBounds(15,290,130,30);
  pDob.setFont(subF);
  pDob.setForeground(Color.WHITE);
  addField.add(pDob);

  JTextField pDobn=new JTextField();
  pDobn.setBounds(160,290,150,30);
  pDobn.setFont(subF);
  addField.add(pDobn);

                   
  JLabel pSex=new JLabel("Sex");
  pSex.setBounds(15,340,130,30);
  pSex.setFont(subF);
  pSex.setForeground(Color.WHITE);
  addField.add(pSex);

  JTextField pSexn=new JTextField();
  pSexn.setBounds(160,340,150,30);
  pSexn.setFont(subF);
  addField.add(pSexn);
                   
  JLabel pAddress=new JLabel("Address");
  pAddress.setBounds(15,390,130,30);
  pAddress.setFont(subF);
  pAddress.setForeground(Color.WHITE);
  addField.add(pAddress);


  JTextField pAddressn =new JTextField();
  pAddressn.setBounds(160,390,150,30);
  pAddressn.setFont(subF);
  addField.add(pAddressn);
                   
 
                   
           JLabel pHealth=new JLabel("Health Status");
            pHealth.setBounds(490,140,130,30);
            pHealth.setFont(subF);
           pHealth.setForeground(Color.WHITE);
           addField.add(pHealth);

           JTextField pHealthn=new JTextField();
           pHealthn.setBounds(635,140,150,30);
           pHealthn.setFont(subF);
           addField.add(pHealthn);
                   
            JLabel pCrime=new JLabel("Crime");
            pCrime.setBounds(490,190,130,30);
            pCrime.setFont(subF);
           pCrime.setForeground(Color.WHITE);
           addField.add(pCrime);
           
          JTextField pCrimen=new JTextField();
          pCrimen.setBounds(635,190,150,30);
         pCrimen.setFont(subF);
         addField.add(pCrimen);

          JLabel pEntry=new JLabel("Entry Date");
          pEntry.setBounds(490,240,130,30);
          pEntry.setFont(subF);
          pEntry.setForeground(Color.WHITE);
          addField.add(pEntry);

          JTextField pEntryn=new JTextField();
          pEntryn.setBounds(635,240,150,30);
          pEntryn.setFont(subF);
          addField.add(pEntryn);


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


                        String setAge=rs.getString("pAge");
                        pAgen.setText(setAge);

                        String setParentName=rs.getString("pParentName");
                        pParentn.setText(setParentName);

                        String setDob=rs.getString("pDob");
                        pDobn.setText(setDob);

                        String setSex=rs.getString("pSex");
                        pSexn.setText(setSex);

                        String setAddress=rs.getString("pAddress");
                        pAddressn.setText(setAddress);

                        String setHealth=rs.getString("pHealth");
                        pHealthn.setText(setHealth);


                       String setCrime=rs.getString("crime");
                       pCrimen.setText(setCrime);

                       String setEntry=rs.getString("entryDate");
                       pEntryn.setText(setEntry);

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