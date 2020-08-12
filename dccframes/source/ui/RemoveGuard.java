package ui;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import services.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class RemoveGuard extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    private Font subF=new Font("Serif",Font.PLAIN,18);
    RemoveService removeS=new RemoveService();
    Connection con;
    ResultSet rs;


    
    public RemoveGuard(){
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

        JLabel name= new JLabel("Remove Guard");
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
                if(searchGuardText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Guard Id Requaird !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(removeS.guardRemove(searchGuardText.getText())){
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