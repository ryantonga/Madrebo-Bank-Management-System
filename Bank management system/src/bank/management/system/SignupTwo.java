package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
        JLabel additionalDetails, religion, category, income, occupation, education,qualification, Scitizen;
        JRadioButton syes, sno;
        JButton next;
        JComboBox religionbox, categorybox, incomebox, occupationbox, educationbox;
        String formno;
        

    SignupTwo() { 
   
        setLayout (null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetails = new JLabel("Page 2: Additional details");
        additionalDetails.setBounds(270, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add (additionalDetails);

        religion = new JLabel("Religion");
        religion.setBounds(70, 140, 100, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add (religion);

        String valReligion[] = {"Christian", "Hindu", "Sikh", "Muslim","Other"};
        religionbox = new JComboBox(valReligion);
        religionbox.setBounds(300,140,400,30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);
        
        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(70,190,200,30);
        add(category);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categorybox = new JComboBox(valcategory);
        categorybox.setBounds(300,190,400,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);
        
        income = new JLabel("Income:");
        income.setBounds(70, 240, 200, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add (income);
        
        String incomecategory[] = {"Null", "<1,500,000", "<2,500,000", "<5,000,000", "Upto 10,000,000"};
        incomebox = new JComboBox(incomecategory);
        incomebox.setBounds(300,240,400,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(70,290,250,30);
        add(education);
        
        qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(70,315,250,30);
        add(qualification);
        
        
        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationbox = new JComboBox(educationValues);
        educationbox.setBounds(300,307,400,30);
        educationbox.setBackground(Color.WHITE);
        add(educationbox);

        occupation = new JLabel("Occupation:");
        occupation.setBounds(70, 390, 200, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        add (occupation);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationbox = new JComboBox(occupationValues);
        occupationbox.setBounds(300,390,400,30);
        occupationbox.setBackground(Color.WHITE);
        add(occupationbox);
        

        Scitizen = new JLabel("Over 50?");
        Scitizen.setBounds(70, 490, 400, 30);
        Scitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        add (Scitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);  
         


        getContentPane().setBackground(Color.WHITE);

        setSize (850,800);
        setLocation(350,0);
        setVisible(true);

    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion = (String) religionbox.getSelectedItem();
        String scategory = (String) categorybox.getSelectedItem();
        String sincome = (String) incomebox.getSelectedItem();
        String seducation = (String) educationbox.getSelectedItem();
        String soccupation = (String) occupationbox.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected())
        {
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected())
        {
            seniorcitizen = "No";
        }
        

        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+seniorcitizen+"')";
                c.s.executeUpdate(query);
                
               setVisible(false);
               new SignupThree(formno).setVisible(true);
            } catch (Exception e) {
            System.out.println(e);     
        }
        
    }





    public static void main (String [] args)
    {
        new SignupTwo();

    }



}


