package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	public JFrame frame;

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
		frame.setBounds(100, 100, 450, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login L=new Login();
				L.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnLogin.setBounds(353, 31, 71, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(174, 27, 82, 23);
		frame.getContentPane().add(lblMenu);
		
		JButton btnNewButton = new JButton("CAB DATABASE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CabDatabase CD= new CabDatabase();
				CD.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(118, 77, 185, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("CUSTOMER DATABASE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDatabase CusD =new CustomerDatabase();
				CusD.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(118, 124, 185, 36);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("MANAGEMENT DATABASE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementDatabase MD = new ManagementDatabase();
				MD.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setBounds(118, 168, 185, 36);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("RATING DATABASE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RatingDatabase RD= new RatingDatabase();
				RD.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_2.setBounds(118, 215, 185, 36);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("RATING DATABASE");
		button_3.setBounds(118, 262, 185, 36);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("REQUEST DATABASE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(118, 309, 185, 36);
		frame.getContentPane().add(button_4);
		
		
	}
}
