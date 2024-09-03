package university.management.system;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StudPage {

	private JFrame frmStudentDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudPage window = new StudPage();
					window.frmStudentDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		frmStudentDashboard = new JFrame();
		frmStudentDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\spider.jpg"));
		frmStudentDashboard.setTitle("Student Dashboard");
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
		frmStudentDashboard.setSize(width/2, height/2);
		frmStudentDashboard.setLocationRelativeTo(null);
		//frame.setBounds(100, 100, 450, 300);
		frmStudentDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentDashboard.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("RESULT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudMarksSearch.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(102, 148, 143, 138);
		frmStudentDashboard.getContentPane().add(btnNewButton);
		
		JButton btnLeave = new JButton("LEAVE");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudLeave.main(null);
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLeave.setForeground(Color.WHITE);
		btnLeave.setBackground(Color.BLACK);
		btnLeave.setBounds(350, 148, 143, 138);
		frmStudentDashboard.getContentPane().add(btnLeave);
		
		JLabel lblNewLabel = new JLabel("Welcome To Pune University");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(72, 10, 513, 46);
		frmStudentDashboard.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
		lblNewLabel_1.setBounds(554, 10, 175, 146);
		frmStudentDashboard.getContentPane().add(lblNewLabel_1);
		
		JLabel lblStudentDashboard = new JLabel("Student Dashboard");
		lblStudentDashboard.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		lblStudentDashboard.setBounds(148, 75, 346, 46);
		frmStudentDashboard.getContentPane().add(lblStudentDashboard);
		
		
	}
}
