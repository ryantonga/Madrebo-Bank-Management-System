package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame  {
    
    MiniStatement(String pinnumber) {
        
        setTitle("Mini statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        
        add(mini);
        
        JLabel bank = new JLabel("BANK STATEMENT");
        bank.setBounds(150,20,300,20);  
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number: XXXXXXXXXXXX" + rs.getString("cardnumber").substring(12, 16));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + " " + rs.getString("type") + " " + rs.getString("amount") + "<br>");
                
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        setSize(500,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String [] args) {
        
        new MiniStatement("");
    }
    
}
