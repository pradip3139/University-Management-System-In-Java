package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    JLabel lblStatus;
    Choice cStatus;
    
    StudentLeaveDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        getContentPane().add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        getContentPane().add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        getContentPane().add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        getContentPane().add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        getContentPane().add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        getContentPane().add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        
        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(330, 20, 100, 20);
        getContentPane().add(lblStatus);

        cStatus = new Choice();
        cStatus.add("Pending");
        cStatus.add("Approved");
        cStatus.add("Rejected");
        cStatus.setBounds(380, 20, 100, 20);
        getContentPane().add(cStatus);

        update = new JButton("Update");
        update.setBounds(480, 20, 80, 20);
        update.addActionListener(this);
        getContentPane().add(update);

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
        else if (ae.getSource() == update) {
            // Get selected roll number and status
            String rollNumber = crollno.getSelectedItem();
            String status = cStatus.getSelectedItem();

            // Update status in the database
            try {
                Conn c = new Conn();
                String query = "UPDATE studentleave SET status = ? WHERE rollno = ?";
                PreparedStatement pstmt = c.prepareStatement(query);
                pstmt.setString(1, status);
                pstmt.setString(2, rollNumber);
                pstmt.executeUpdate();

                // Update table display
                String selectQuery = "SELECT * FROM studentleave WHERE rollno = ?";
                pstmt = c.prepareStatement(selectQuery);
                pstmt.setString(1, rollNumber);
                ResultSet rs = pstmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        else {
            setVisible(false);
        }
        
        
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}