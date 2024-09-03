package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentLogin extends JFrame implements ActionListener{

    JButton login, cancel;
    JTextField tfrollno, tfpassword;
    
    StudentLogin () {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\spider.jpg"));
    	setTitle("Student Login Page");
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JLabel lblusername = new JLabel("Roll Number");
        lblusername.setBounds(40, 98, 100, 20);
        getContentPane().add(lblusername);
        
        tfrollno = new JTextField();
        tfrollno.setBounds(150, 99, 150, 20);
        getContentPane().add(tfrollno);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 128, 100, 20);
        getContentPane().add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 129, 150, 20);
        getContentPane().add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(50, 171, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 171, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(cancel);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.jpg"));
       Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
        image.setBounds(346, 41, 217, 200);
        getContentPane().add(image);
        
        JButton btnRegister = new JButton("Signup");
        btnRegister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddStudent.main(null);
        	}
        });
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setBounds(180, 211, 120, 30);
        getContentPane().add(btnRegister);
        
        JLabel lblNewLabel = new JLabel("Welcome To Pune University");
        lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(90, 10, 409, 30);
        getContentPane().add(lblNewLabel);
        
        JLabel lblDontHaveAccount = new JLabel("Don't Have Account");
        lblDontHaveAccount.setBounds(40, 221, 120, 20);
        getContentPane().add(lblDontHaveAccount);
        
        JLabel lblNewLabel_1 = new JLabel("Student Login");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel_1.setBounds(179, 41, 208, 30);
        getContentPane().add(lblNewLabel_1);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String rollno = tfrollno.getText();
            String password = tfpassword.getText();
            
            String query = "select * from student where rollno='"+rollno+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                 //  new StudPage();
                    StudPage.main(null);
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
        new StudentLogin();
    }
}