package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
        JLabel formno, personDetails, name, dob, email, cemail, marital, address, city, state, pin;
        JTextField nameTextField, emailTextField, cemailTextField, addressTextField, cityTextField, stateTextField;
        JPasswordField pinPasswordField;
        JRadioButton married, unmarried, other;
        ButtonGroup maritalgroup;
        JButton next;
        JDateChooser dateChooser;
        

    SignupOne() { 

        setLayout (null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        formno = new JLabel("Application number: "+ random);
        formno.setBounds(160, 20, 600, 40);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        add (formno);

        personDetails = new JLabel("Page 1: Personal details");
        personDetails.setBounds(270, 80, 400, 30);
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add (personDetails);

        name = new JLabel("Name");
        name.setBounds(70, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add (name);

        nameTextField = new JTextField();
        nameTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        dob = new JLabel("Date of Birth");
        dob.setBounds(70, 190, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add (dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,190,200,30);
        add(dateChooser);

        email = new JLabel("Email");
        email.setBounds(70, 240, 100, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add (email);

        emailTextField = new JTextField();
        emailTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,240,400,30);
        add(emailTextField);

        cemail = new JLabel("Confirm Email");
        cemail.setBounds(70, 290, 200, 30);
        cemail.setFont(new Font("Raleway", Font.BOLD, 20));
        add (cemail);

        cemailTextField = new JTextField();
        cemailTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        cemailTextField.setBounds(300,290,400,30);
        add(cemailTextField);

        marital = new JLabel("Marital Status");
        marital.setBounds(70, 340, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add (marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,340,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(425,340,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(570,340,100,30);
        other.setBackground(Color.white);
        add(other);
        
        maritalgroup =new ButtonGroup ();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        address = new JLabel("Home address");
        address.setBounds(70, 390, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add (address);

        addressTextField = new JTextField();
        addressTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,390,400,30);
        add(addressTextField);



        city = new JLabel("City");
        city.setBounds(70, 440, 100, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add (city);

        cityTextField = new JTextField();
        cityTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,440,400,30);
        add(cityTextField);

        state = new JLabel("State");
        state.setBounds(70, 490, 400, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add (state);

        stateTextField = new JTextField();
        stateTextField.setFont (new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,490,400,30);
        add(stateTextField);

        pin = new JLabel("Pincode");
        pin.setBounds(70, 540, 400, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add (pin);

        pinPasswordField = new JPasswordField();
        pinPasswordField.setFont (new Font("Raleway", Font.BOLD, 14));
        pinPasswordField.setBounds(300,540,400,30);
        add(pinPasswordField);
        
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
        String formno = ""+ random;
        String name = nameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String email = emailTextField.getText();
        String cemail = cemailTextField.getText();
        String marital = null;
        if (married.isSelected())
        {
            marital = "Married";
        }
        else if (unmarried.isSelected())
        {
            marital = "unmarried";
        }
        else 
        {
            marital = "other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinPasswordField.getText();
        
        try 
        {
            if(name.equals("") )
            {
                JOptionPane.showMessageDialog(null,"Name is required");       
            }
            else if(!email.equals(cemail)) {
                JOptionPane.showMessageDialog(null,"Email doesn't match");   
            }
            else {
                
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+dob+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo().setVisible(true);
            }
            
            
        
        } catch (Exception e) {
            System.out.println(e);     
        }
        
    }





    public static void main (String [] args)
    {
        new SignupOne();

    }



}

