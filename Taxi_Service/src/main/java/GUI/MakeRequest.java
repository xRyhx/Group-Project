package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MakeRequest {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeRequest window = new MakeRequest();
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
	public MakeRequest() {
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
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(178, 214, 109, 36);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(146, 64, 233, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblField = new JLabel("Field 1 :");
		lblField.setBounds(90, 72, 46, 14);
		frame.getContentPane().add(lblField);
		
		JLabel lblRequest = new JLabel("FEEDBACK");
		lblRequest.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequest.setBounds(181, 11, 134, 23);
		frame.getContentPane().add(lblRequest);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 108, 233, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel label = new JLabel("Field 1 :");
		label.setBounds(90, 116, 46, 14);
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 149, 233, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel label_1 = new JLabel("Field 1 :");
		label_1.setBounds(90, 157, 46, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
			}
		});
		btnBack.setBounds(379, 221, 55, 23);
		frame.getContentPane().add(btnBack);
	}

}
