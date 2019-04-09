package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGeneralFeedback = new JButton("General Feedback");
		btnGeneralFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralFeedback GF = new GeneralFeedback();
				GF.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnGeneralFeedback.setBounds(134, 183, 151, 43);
		frame.getContentPane().add(btnGeneralFeedback);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login L=new Login();
				L.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnLogin.setBounds(353, 11, 71, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnMakeARequest = new JButton("Make A Request");
		btnMakeARequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MakeRequest MR=new MakeRequest();
				MR.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnMakeARequest.setBounds(118, 84, 185, 68);
		frame.getContentPane().add(btnMakeARequest);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(174, 7, 82, 23);
		frame.getContentPane().add(lblMenu);
	}
}
