package ui;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import services.*;

public class AddPrisoner extends JFrame{

    private Container c;

    private Font f=new Font("Serif",Font.BOLD,50);
    private Font lf=new Font("Serif",Font.BOLD,30);
    private Font logf=new Font("Serif",Font.PLAIN,25);
    private Font fieldF=new Font("Serif",Font.PLAIN,20);
    UserService us=new UserService();



    
    public AddPrisoner(){
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

        JLabel name= new JLabel("Add Prisoner");
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

        
        JLabel prisonId =new JLabel("Prison Id");
        prisonId.setFont(fieldF);
        prisonId.setForeground(Color.WHITE);
        prisonId.setBounds(35,45,120,50);
        addField.add(prisonId);

        JTextField prisonIdText =new JTextField();
        prisonIdText.setBounds(155,45,200,50);
        prisonIdText.setFont(fieldF);
        addField.add(prisonIdText);

        
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
       // sexText.getSelectedItem().toString();
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

        JLabel crime =new JLabel("Crime");
        crime.setFont(fieldF);
        crime.setForeground(Color.WHITE);
        crime.setBounds(35,375,120,60);
        addField.add(crime);

        JTextField crimeText =new JTextField();
        crimeText.setBounds(155,385,200,50);
        crimeText.setFont(fieldF);
        addField.add(crimeText);

        JLabel entryDate =new JLabel("Entry Date");
        entryDate.setFont(fieldF);
        entryDate.setForeground(Color.WHITE);
        entryDate.setBounds(400,375,120,60);
        addField.add(entryDate);

        JTextField entryText =new JTextField();
        entryText.setBounds(520,385,200,50);
        entryText.setFont(fieldF);
        addField.add(entryText);

       

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
              
                else if(prisonIdText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Prison Id  Required !!","Error",JOptionPane.ERROR_MESSAGE);

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
                else if(crimeText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Crime Name Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else if(entryText.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Entry Date Required !!","Error",JOptionPane.ERROR_MESSAGE);

                }
                else{
                    if(us.addNewPrisoner(firstNameText.getText(),prisonIdText.getText(),ageText.getText(),parentText.getText(),dobText.getText(),sexText.getSelectedItem().toString(),addressText.getText(),crimeText.getText(),entryText.getText())){
                        JOptionPane.showMessageDialog(null,"Adding Successfull !!","Add Prisoner",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Adding Failed !!","Add Prisoner",JOptionPane.ERROR_MESSAGE);

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