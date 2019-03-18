package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class MainMenu {

	private JFrame frame;

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
		btnGeneralFeedback.setBounds(152, 182, 119, 43);
		frame.getContentPane().add(btnGeneralFeedback);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(367, 11, 57, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnMakeARequest = new JButton("Make A Request");
		btnMakeARequest.setBounds(118, 84, 185, 68);
		frame.getContentPane().add(btnMakeARequest);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(174, 7, 82, 23);
		frame.getContentPane().add(lblMenu);
	}

}
