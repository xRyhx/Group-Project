package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminManageCab {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManageCab window = new AdminManageCab();
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
	public AdminManageCab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(335, 303, 89, 23);
		frame.getContentPane().add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 414, 247);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAdministrator = new JLabel("ADMINISTRATOR");
		lblAdministrator.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdministrator.setBounds(132, 11, 223, 23);
		frame.getContentPane().add(lblAdministrator);
	}

}
