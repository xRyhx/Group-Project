package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneralFeedback {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralFeedback window = new GeneralFeedback();
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
	public GeneralFeedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadFeedback = new JLabel("QUERY");
		lblCadFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadFeedback.setBounds(186, 11, 145, 23);
		frame.getContentPane().add(lblCadFeedback);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(129, 62, 289, 30);
		frame.getContentPane().add(textField);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setBounds(47, 70, 72, 14);
		frame.getContentPane().add(lblFullName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 106, 289, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(47, 114, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(129, 147, 289, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel lblQueryType = new JLabel("Query Type :");
		lblQueryType.setBounds(47, 155, 72, 14);
		frame.getContentPane().add(lblQueryType);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(129, 188, 289, 123);
		frame.getContentPane().add(textField_3);
		
		JLabel lblMessage = new JLabel("Message :");
		lblMessage.setBounds(47, 196, 72, 14);
		frame.getContentPane().add(lblMessage);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String email = textField_1.getText();
				String queryType = textField_2.getText();
				String message = textField_3.getText();
				
				//Pass info to function to store
				System.out.println(name+email+queryType+message);
				
			}
		});
		button.setBounds(172, 324, 109, 36);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu M= new MainMenu();
				M.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setBounds(350, 331, 68, 23);
		frame.getContentPane().add(button_1);
	}
}
