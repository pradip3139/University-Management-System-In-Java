package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login () {
    	setTitle("Pune University");
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 59, 100, 20);
        getContentPane().add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 60, 150, 20);
        getContentPane().add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 89, 100, 20);
        getContentPane().add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 90, 150, 20);
        getContentPane().add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(cancel);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(363, 41, 200, 200);
        getContentPane().add(image);
        
        JButton btnRegister = new JButton("Signup");
        btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegistrationPage.main(null);
        	}
        });
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setBounds(180, 193, 120, 30);
        getContentPane().add(btnRegister);
        
        JLabel lblNewLabel = new JLabel("Welcome To Pune University");
        lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(90, 10, 409, 30);
        getContentPane().add(lblNewLabel);
        
        JLabel lblDontHaveAccount = new JLabel("Don't Have Account");
        lblDontHaveAccount.setBounds(40, 200, 120, 20);
        getContentPane().add(lblDontHaveAccount);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                   new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}