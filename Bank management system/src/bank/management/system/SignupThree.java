package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
            
    SignupThree(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Additional Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,100,400,40);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setBounds(100,150,210,20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,150,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,190,170,20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,190,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        
        
        JLabel cardnum = new JLabel("Card Number");
        cardnum.setBounds(100,240,150,30);
        cardnum.setFont(new Font("Raleway", Font.BOLD,22));
        add(cardnum);
        
        JLabel com1 = new JLabel ("Your 16 Digit Card Number");
        com1.setBounds(100, 270, 200, 20);
        com1.setFont(new Font("Raleway",Font.BOLD,12));
        add(com1);
        
        JLabel num = new JLabel("XXXX-XXXX-XXXX-1234");
        num.setBounds(350,240,300,30);
        num.setFont(new Font("Raleway", Font.BOLD,22));
        add(num);
        
        JLabel pin = new JLabel("PIN");
        pin.setBounds(100,320,200,30);
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        add(pin);
        
        JLabel com2 = new JLabel ("Your 4 Digit Password");
        com2.setBounds(100, 350, 200, 20);
        com2.setFont(new Font("Raleway",Font.BOLD,12));
        add(com2);
        
        
        JLabel pinnum = new JLabel("XXXX");
        pinnum.setBounds(350,320,150,30);
        pinnum.setFont(new Font("Raleway", Font.BOLD,22));
        add(pinnum);
        
        JLabel services = new JLabel ("Services Offered");
        services.setBounds(100, 390, 200, 30);
        services.setFont(new Font("Raleway",Font.BOLD,22));
        add(services);
        
        c1 = new JCheckBox ("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,430,200,20);
        add(c1);
        
        c2 = new JCheckBox ("Mobile Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,430,200,20);
        add(c2);
        
        c3 = new JCheckBox ("SMS alerts");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,480,200,20);
        add(c3);
        
        c4 = new JCheckBox ("E-Statement");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,480,200,20);
        add(c4);
        
        c5 = new JCheckBox ("Email alerts");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,530,200,20);
        add(c5);
        
        c6 = new JCheckBox ("Cheque Book");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,530,200,20);
        add(c6);
        
        c7 = new JCheckBox ("I hereby declare that the aforementioned details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,20);
        add(c7);
        
        submit = new JButton ("Submit");
        submit.setBounds(200,630,100,20);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton ("Cancel");
        cancel.setBounds(400,630,100,20);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway", Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        
        ButtonGroup savings = new ButtonGroup();
        savings.add(r1);
        savings.add(r2);
        savings.add(r3);
        savings.add(r4);
        
    }
         public void actionPerformed (ActionEvent ae) {
    
        

            if(ae.getSource()==submit){
                String accountType = null;
                if(r1.isSelected()) {
                    accountType = "Savings Account";
                } else if (r2.isSelected()){
                    accountType = "Fixed Deposit Account";
                }else if (r3.isSelected()){
                    accountType = "Current Account";
                }else if (r4.isSelected()){
                    accountType = "Recurring Deposit Account";
                }
                
                Random random = new Random ();
                String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
                String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
                
                
                String facility = "";
                if (c1.isSelected()){
                    facility = facility + "ATM Card";
                } else if (c2.isSelected()){
                    facility = facility + "Mobile Banking";
                } else if (c3.isSelected()){
                    facility = facility + "SMS alerts";
                }else if (c4.isSelected()){
                    facility = facility + "E-Statement";
                }else if (c5.isSelected()){
                    facility = facility + "Email alerts";
                }else if (c6.isSelected()){
                    facility = facility + "Cheque Book";
                }
                
                try {
                    if (accountType.equals("")){
                        JOptionPane.showMessageDialog(null, "Account Type is Required");
                    } else {
                        Conn conn = new Conn();
                        String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')" ;
                        String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')" ;

                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                        
                         setVisible(false);
                         new Deposit(pinnumber).setVisible(false);
                    }
                        
                    
                } catch (Exception e){
                    System.out.print(e);
                }
                    
                
            } else if (ae.getSource()==cancel ){
              setVisible(false);
              new Login().setVisible(true);
            }
            
            }
        
        
        
        
        
    
    public static void main(String [] args) {
        
        new SignupThree("");
    
    
    
    }
    
}
