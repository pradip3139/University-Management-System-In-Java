package university.management.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RegistrationPage {

    private JFrame frmAdminRegistration;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrationPage window = new RegistrationPage();
                    window.frmAdminRegistration.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public RegistrationPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminRegistration = new JFrame();
        frmAdminRegistration.setTitle("Admin Registration");
        frmAdminRegistration.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\spider.jpg"));
        frmAdminRegistration.setBounds(500, 100, 600, 700);
        frmAdminRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdminRegistration.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Admin Registration");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(198, 21, 451, 42);
        frmAdminRegistration.getContentPane().add(lblNewLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(33, 85, 543, 2);
        frmAdminRegistration.getContentPane().add(separator);
        
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1.setBounds(64, 118, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("FirstName");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_1.setBounds(64, 204, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("LastName");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_2.setBounds(64, 272, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Password");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_3.setBounds(64, 351, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_3_1 = new JLabel("Email");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_3_1.setBounds(64, 429, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1_3_1);
        
        JLabel lblNewLabel_1_3_2 = new JLabel("Phone");
        lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_1_3_2.setBounds(64, 499, 139, 34);
        frmAdminRegistration.getContentPane().add(lblNewLabel_1_3_2);
        
        textField = new JTextField();
        textField.setBounds(242, 125, 283, 34);
        frmAdminRegistration.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(242, 204, 283, 34);
        frmAdminRegistration.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(242, 272, 283, 34);
        frmAdminRegistration.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(242, 429, 283, 34);
        frmAdminRegistration.getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(242, 499, 283, 34);
        frmAdminRegistration.getContentPane().add(textField_4);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(255, 351, 272, 34);
        frmAdminRegistration.getContentPane().add(passwordField);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(33, 568, 543, 2);
        frmAdminRegistration.getContentPane().add(separator_1);
        
        JButton submit = new JButton("Submit");
        submit.setForeground(new Color(255, 255, 255));
        submit.setBackground(new Color(0, 0, 0));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());
                try {
                    String query = "INSERT INTO login (username, password) VALUES ('" + username + "', '" + password + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "User registered successfully!");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        submit.setFont(new Font("Tahoma", Font.BOLD, 25));
        submit.setBounds(64, 592, 129, 47);
        frmAdminRegistration.getContentPane().add(submit);
        
        
        JButton btnClear = new JButton("Clear");
        btnClear.setBackground(new Color(0, 0, 0));
        btnClear.setForeground(new Color(255, 255, 255));
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                passwordField.setText("");
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnClear.setBounds(226, 592, 129, 47);
        frmAdminRegistration.getContentPane().add(btnClear);
        
        JButton btnLogin = new JButton("Back");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login.main(null);
        	}
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnLogin.setBounds(396, 592, 129, 47);
        frmAdminRegistration.getContentPane().add(btnLogin);
        
        JPanel panel = new JPanel();
        panel.setBounds(27, 10, 161, 77);
        frmAdminRegistration.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBackground(new Color(0, 0, 0));
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
        lblNewLabel_2.setBounds(0, 0, 161, 77);
        panel.add(lblNewLabel_2);
    }
}
