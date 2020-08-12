package ui;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class AddGuard extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    UserService us=new UserService();



    
    public AddGuard(){
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

        JLabel name= new JLabel("Add Guard");
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
        addField.setBounds(145,150,1200,450);
        addField.setLayout (null);
      // addField.setLayout(new CardLayout());



        JLabel guardId =new JLabel("Guard Id");
        guardId.setFont(fieldF);
        guardId.setForeground(Color.WHITE);
        guardId.setBounds(35,45,120,50);
        addField.add(guardId);

        JTextField guardIdText =new JTextField();
        guardIdText.setBounds(155,45,200,50);
        guardIdText.setFont(fieldF);
        addField.add(guardIdText);

        JLabel firstName =new JLabel("Name");
        firstName.setFont(fieldF);
        firstName.setForeground(Color.WHITE);
        firstName.setBounds(35,120,120,60);
        addField.add(firstName);

        JTextField firstNameText =new JTextField();
        firstNameText.setBounds(155,130,200,50);
        firstNameText.setFont(fieldF);
        addField.add(firstNameText);

        JLabel age =new JLabel("Age");
        age.setFont(fieldF);
        age.setForeground(Color.WHITE);
        age.setBounds(400,120,120,60);
        addField.add(age);

        JTextField ageText =new JTextField();
        ageText.setBounds(520,130,200,50);
        ageText.setFont(fieldF);
        addField.add(ageText);

        JLabel parant =new JLabel("Parent's Name");
        parant.setFont(fieldF);
        parant.setForeground(Color.WHITE);
        parant.setBounds(35,205,120,60);
        addField.add(parant);

        JTextField parentText =new JTextField();
        parentText.setBounds(155,215,200,50);
        parentText.setFont(fieldF);
        addField.add(parentText);

        JLabel dob =new JLabel("Date of Birth");
        dob.setFont(fieldF);
        dob.setForeground(Color.WHITE);
        dob.setBounds(400,205,120,60);
        addField.add(dob);

        JTextField dobText =new JTextField();
        dobText.setBounds(520,215,200,50);
        dobText.setFont(fieldF);
        addField.add(dobText);

        JLabel sex =new JLabel("Sex");
        sex.setFont(fieldF);
        sex.setForeground(Color.WHITE);
        sex.setBounds(35,290,120,60);
        addField.add(sex);

        JComboBox sexText=new JComboBox(new String[]{"Male","Female","Other"});
        sexText.setBounds(155,300,200,50);
        sexText.setFont(fieldF);
        addField.add(sexText);

        JLabel address =new JLabel("Address");
        address.setFont(fieldF);
        address.setForeground(Color.WHITE);
        address.setBounds(400,290,120,60);
        addField.add(address);

        JTextField addressText =new JTextField();
        addressText.setBounds(520,300,200,50);
        addressText.setFont(fieldF);
        addField.add(addressText);


        JLabel startDate =new JLabel("Joining Date");
        startDate.setFont(fieldF);
        startDate.setForeground(Color.WHITE);
        startDate.setBounds(35,375,120,60);
        addField.add(startDate);

        JTextField startText =new JTextField();
        startText.setBounds(155,385,200,50);
        startText.setFont(fieldF);
        addField.add(startText);

        JLabel phone =new JLabel("Phone Number");
        phone.setFont(fieldF);
        phone.setForeground(Color.WHITE);
        phone.setBounds(400,375,120,60);
        addField.add(phone);

        JTextField phoneText =new JTextField();
        phoneText.setBounds(520,385,200,50);
        phoneText.setFont(fieldF);
        addField.add(phoneText);

       

         //add button

         JButton addButton =new JButton("Add");
         addButton.setBounds(870, 45, 120, 50);
         addButton.setBackground(new Color(64, 64, 64));
         addButton.setForeground(Color.WHITE);
         addButton.setFont(logf);
        addField.add(addButton);

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(firstNameText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"First Name Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
               
                else if(guardIdText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Guard Id  Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(ageText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Age  Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(parentText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Parent's Name Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(dobText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Date of Birth  Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(addressText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Address Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(startText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Joining Date  Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(phoneText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Entry Date Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else{
                    if(us.addNewGuard(firstNameText.getText(),guardIdText.getText(),ageText.getText(),parentText.getText(),dobText.getText(),sexText.getSelectedItem().toString(),addressText.getText(),startText.getText(),phoneText.getText())){
                        JOptionPane.showMessageDialog(null,"Adding Successfull !!","Add Guard",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Adding Failed !!","Add Guard",JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });
      
      //  pictureChooser.add(chooser);
      ///  addField.add(pictureChooser);





        




       



        //background
       // ImageIcon background_image=new ImageIcon("login.jpg");
        //Image img=background_image.getImage();
       // Image temp_img=img.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
       // background_image=new ImageIcon(temp_img);
       // JLabel background=new JLabel("",background_image,JLabel.CENTER);

       // background.add(option);
      //  background.add(heading);
      //  background.add(backButton);
      //  background.add(portalField);
        //background.setBounds(0,0,1200,700);
       // add(background);

        c.add(option);
        c.add(heading);
        c.add(backButton);
        c.add(addField);


        c.setBackground(new Color(38, 38, 38));




       
    }
}