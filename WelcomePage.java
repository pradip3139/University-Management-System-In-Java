package university.management.system;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.datatransfer.Clipboard;
import java.awt.font.TextAttribute;
import java.awt.im.InputMethodHighlight;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WelcomePage {

	public JFrame frmRegistrationPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frmRegistrationPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationPage = new JFrame();
		frmRegistrationPage.setForeground(new Color(0, 0, 0));
		frmRegistrationPage.setBackground(new Color(0, 0, 0));
		frmRegistrationPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\spider.jpg"));
		frmRegistrationPage.setTitle("Welcome Page");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dim=kit.getScreenSize();
		int w = (int)dim.getWidth();
		int h = (int)dim.getHeight();
		frmRegistrationPage.setSize(w/2,h/2);
		frmRegistrationPage.setLocationRelativeTo(null);
		frmRegistrationPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationPage.getContentPane().setLayout(null);
		 frmRegistrationPage.getContentPane().setBackground(new Color(255, 255, 255));
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setBackground(new Color(0, 0, 0));
		btnAdmin.setIcon(new ImageIcon("C:\\newad.jpg"));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				
			}
		});
	//	btnAdmin.setIcon(new ImageIcon(RegistrationPage.class.getResource("/images/admin.jpg")));
		btnAdmin.setBounds(94, 113, 201, 192);
		frmRegistrationPage.getContentPane().add(btnAdmin);
		
		JButton btnUser = new JButton("");
		btnUser.setBackground(new Color(0, 0, 0));
		btnUser.setIcon(new ImageIcon("C:\\newus.jpg"));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin.main(null);
			}
		});
	//	btnUser.setIcon(new ImageIcon(RegistrationPage.class.getResource("/images/user.jpg")));
		btnUser.setBounds(438, 113, 189, 192);
		frmRegistrationPage.getContentPane().add(btnUser);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(94, 315, 179, 29);
		frmRegistrationPage.getContentPane().add(lblNewLabel);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUser.setBounds(438, 315, 179, 29);
		frmRegistrationPage.getContentPane().add(lblUser);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Pune University");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Castellar", Font.BOLD, 30));
		lblNewLabel_1.setBounds(139, 22, 666, 46);
		frmRegistrationPage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\pradi\\Downloads\\images.jpg"));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(-24, 10, 175, 86);
		frmRegistrationPage.getContentPane().add(lblNewLabel_2);
	}
	
}
