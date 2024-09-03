package university.management.system;

import java.sql.*;

public class Conn {
    
    static Connection c;
    Statement s;

    Conn () {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "1234");
//            s = c.createStatement();
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("Got Driver");
    		
    		} catch (ClassNotFoundException e) {
    			
    			e.printStackTrace();
    			System.out.println("Problem In Loading Driver");
    		}
    		
    		
    		
    		try {
    			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","1234");
    			 s = c.createStatement();
    			System.out.println("Connection Ho gaya");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			System.out.println("Problem in connection");
    		}
    		
    }

    public static PreparedStatement prepareStatement(String query) {
        try {
            // Assuming con is a static field initialized elsewhere in the Conn class
            return c.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Return null in case of exception
        }
    }
}
    
    
