package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","bladifakin1");
            s = c.createStatement();
        
        } catch(Exception e) {
            System.out.println(e);
        }
    
    
    }
    
}
