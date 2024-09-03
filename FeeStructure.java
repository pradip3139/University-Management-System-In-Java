package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    
    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        getContentPane().setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(58, 35, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        getContentPane().add(heading);
        
        JTable table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 107, 1000, 653);
        getContentPane().add(jsp);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setBounds(717, 11, 175, 86);
        getContentPane().add(lblNewLabel);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}