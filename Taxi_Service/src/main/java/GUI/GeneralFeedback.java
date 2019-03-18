package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GeneralFeedback {

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadFeedback = new JLabel("CAB FEEDBACK");
		lblCadFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadFeedback.setBounds(152, 11, 195, 23);
		frame.getContentPane().add(lblCadFeedback);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(146, 64, 233, 30);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Field 1 :");
		label_1.setBounds(90, 72, 46, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 108, 233, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("Field 1 :");
		label_2.setBounds(90, 116, 46, 14);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 149, 233, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("Field 1 :");
		label_3.setBounds(90, 157, 46, 14);
		frame.getContentPane().add(label_3);
		
		JButton button = new JButton("Submit");
		button.setBounds(178, 214, 109, 36);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("back");
		button_1.setBounds(379, 221, 55, 23);
		frame.getContentPane().add(button_1);
	}

}
