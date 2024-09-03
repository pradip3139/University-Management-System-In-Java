package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudLeave extends JFrame implements ActionListener {

    Choice ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    private JTextField textField;
    private JTextField textField_1;
    
    StudLeave() {
        
        setSize(500, 550);
        setLocation(550, 100);
        getContentPane().setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(heading);
        
        JLabel lblrollno = new JLabel("Enter Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblrollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
              //  textField.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        getContentPane().add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lbltime);
        
        ctime = new Choice();
        ctime.setBackground(new Color(255, 255, 255));
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        getContentPane().add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 395, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 395, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(cancel);
        
        textField = new JTextField();
        textField.setBounds(60, 130, 184, 30);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblStatus = new JLabel("Type pending");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblStatus.setBounds(60, 333, 200, 20);
        getContentPane().add(lblStatus);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(60, 355, 184, 30);
        getContentPane().add(textField_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
        lblNewLabel.setBounds(311, 10, 165, 162);
        getContentPane().add(lblNewLabel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = textField.getText();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String status = textField_1.getText();
            
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"', '"+status+"')";
            
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Leave Request Submitted");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudLeave();
    }
}