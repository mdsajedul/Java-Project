package ui;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import services.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class DeleteStuffs extends JFrame{
    Connection con;
    ResultSet rs;

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    RemoveService removeS=new RemoveService();


    
    public DeleteStuffs(){
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
        

        JButton addStuffs =new JButton("Add Stuffs");
        addStuffs.setBackground(new Color(64, 64, 64));
        addStuffs.setForeground(Color.WHITE);

        option.add(addStuffs);
        addStuffs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               AddStuffs ast=new AddStuffs();
                setVisible(false);

            }
        });

        JButton deleteStuffs=new JButton("Delete Stuffs");
        deleteStuffs.setBackground(new Color(64, 64, 64));
        deleteStuffs.setForeground(Color.WHITE);
        option.add(deleteStuffs);
        deleteStuffs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DeleteStuffs dst=new DeleteStuffs();
                setVisible(false);

            }
        });

        JButton stuffsList =new JButton("Stuffs Profile");
        stuffsList.setBackground(new Color(64, 64, 64));
        stuffsList.setForeground(Color.WHITE);
        option.add(stuffsList);
        stuffsList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StuffsList stl=new StuffsList();
                setVisible(false);

            }
        });


        
        //header

        JPanel heading =new JPanel();
        heading.setBackground(new Color(0,0,0,150));
        heading.setBounds(0,25,1200,100);
        heading.setLayout(null);

        JLabel name= new JLabel("Delete Stuffs");
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

        JLabel searchStuffs =new JLabel("Enter Stuffs Id");
        searchStuffs.setFont(fieldF);
        searchStuffs.setForeground(Color.WHITE);
        searchStuffs.setBounds(15,25,170,50);
        addField.add(searchStuffs);

        JTextField searchStuffsText =new JTextField();
        searchStuffsText.setBounds(180,35,200,40);
        searchStuffsText.setFont(fieldF);
        addField.add(searchStuffsText);

        JButton search =new JButton("Search");
        search.setFont(fieldF);
        search.setBackground(new Color(64, 64, 64));
        search.setForeground(Color.WHITE);
        search.setBounds(365,35,120,40);
        addField.add(search);

        //sub panel
        JLabel sId=new JLabel("Stuff Id:");
        sId.setBounds(15,90,130,30);
        sId.setFont(subF);
        sId.setForeground(Color.WHITE);
       addField.add(sId);
                   
       JTextField sIdn=new JTextField();
       sIdn.setBounds(160,90,150,30);
       sIdn.setFont(subF);
     addField.add(sIdn);
                           
                                           
  JLabel sName=new JLabel("Name");
  sName.setBounds(15,140,130,30);
  sName.setFont(subF);
  sName.setForeground(Color.WHITE);
  addField.add(sName);

  JTextField sNamen=new JTextField();
  sNamen.setBounds(160,140,150,30);
  sNamen.setFont(subF);
  addField.add(sNamen);
                   
 

          search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Dcc","root","");
                    String sql="Select * from stuff where stuffId =?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setString(1, searchStuffsText.getText());
                    rs=pst.executeQuery();
                    if(rs.next()){
                        

                        String setId =rs.getString("stuffId");
                        sIdn.setText(setId);

                        String setName=rs.getString("sFirstName");
                        sNamen.setText(setName);
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

         JButton deleteButton =new JButton("Delete");
         deleteButton.setBounds(870, 45, 120, 50);
         deleteButton.setBackground(new Color(64, 64, 64));
         deleteButton.setForeground(Color.WHITE);
         deleteButton.setFont(logf);
        addField.add(deleteButton);

       
        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(searchStuffsText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Stuff Id Requaird !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(removeS.stuffRemove(searchStuffsText.getText())){
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