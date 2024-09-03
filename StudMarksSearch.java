package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudMarksSearch extends JFrame implements ActionListener {

    JTextField search;
    JButton submit, cancel;
    JTable table;
    private JLabel lblNewLabel;
    
    StudMarksSearch() {
        setSize(1000, 475);
        setLocation(300, 100);
        getContentPane().setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        getContentPane().add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        getContentPane().add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        getContentPane().add(jsp);
        
        try {
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select  from student  ");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
             lblNewLabel = new JLabel("New label");
             lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
             lblNewLabel.setBackground(Color.BLACK);
             lblNewLabel.setBounds(753, 15, 175, 86);
             getContentPane().add(lblNewLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            setVisible(false);    
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudMarksSearch();
    }
}