package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JButton change, back;
    JTextField pintextfield, pintextfield2;
    String pinnumber;
    
    public PinChange (String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pintextfield = new JTextField();
        pintextfield.setBounds(330, 320, 180, 25);
        pintextfield.setFont(new Font("Raleway",Font.BOLD,16));
        add(pintextfield);
        
        pintextfield2 = new JTextField();
        pintextfield2.setBounds(330, 360, 180, 25);
        pintextfield2.setFont(new Font("Raleway",Font.BOLD,16));
        add(pintextfield2);
        
        JLabel pintext2 = new JLabel("RE-ENTER PIN:");
        pintext2.setForeground(Color.WHITE);
        pintext2.setFont(new Font("Raleway",Font.BOLD,16));
        pintext2.setBounds(165,360,180,25);
        image.add(pintext2);
        
        change = new JButton("CHANGE");
        change.addActionListener(this);
        change.setBounds(355,485,150,30);
        image.add(change);
        
        back = new JButton("BACK");
        back.addActionListener(this);
        back.setBounds(355,520,150,30);
        image.add(back);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            
            try {
                
                String newpin = pintextfield.getText();
                String newpin2 = pintextfield.getText();
                
                if(!newpin.equals(newpin2)){
                    JOptionPane.showMessageDialog(null, "Passwords don't match");
                    return;
                }
                else if (newpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                else if(newpin2.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                } else {
                
                Conn conn = new Conn();
                String query1 = "update bank set pinnumber = '"+newpin2+"' where pinnumber = '"+pinnumber+"'";  
                String query2 = "update login set pinnumber = '"+newpin2+"' where pinnumber = '"+pinnumber+"'";  
                String query3 = "update signupthree set pinnumber = '"+newpin2+"' where pinnumber = '"+pinnumber+"'"; 
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
                
                setVisible(false);
                new Transactions(newpin2).setVisible(true);

                }
            
            } catch (Exception e) {
                System.out.println(e);
            }
        
        
        }
        
        if (ae.getSource()== back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    
    
    
    public static void main (String [] args ) {
        new PinChange("");
    }
    
}
