package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Classes.Cab;
import Server.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class AddCab {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCab window = new AddCab();
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
	public AddCab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddCab = new JLabel("ADD CAB");
		lblAddCab.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddCab.setBounds(157, 24, 183, 23);
		frame.getContentPane().add(lblAddCab);
		
		JLabel lblLicenseNumber = new JLabel("License Number :");
		lblLicenseNumber.setBounds(95, 72, 108, 14);
		frame.getContentPane().add(lblLicenseNumber);
		
		textField = new JTextField();
		textField.setBounds(213, 69, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 100, 127, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblTrnNumber = new JLabel("Trn Number :");
		lblTrnNumber.setBounds(95, 103, 108, 14);
		frame.getContentPane().add(lblTrnNumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(213, 131, 127, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblModelNumber = new JLabel("Model Number :");
		lblModelNumber.setBounds(95, 134, 108, 14);
		frame.getContentPane().add(lblModelNumber);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(213, 162, 127, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblDriver = new JLabel("Driver :");
		lblDriver.setBounds(95, 165, 108, 14);
		frame.getContentPane().add(lblDriver);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(213, 193, 127, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(95, 196, 108, 14);
		frame.getContentPane().add(lblStatus);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(213, 224, 127, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(95, 227, 108, 14);
		frame.getContentPane().add(lblYear);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String license = textField.getText();
				int trn = Integer.parseInt(textField_1.getText());
				String model = textField_2.getText();
				String driver = textField_3.getText();
				String status = textField_4.getText();
				int year = Integer.parseInt(textField_5.getText());
				
				ObjectOutputStream output = null;
				ObjectInputStream input;
				
				Cab cab = new Cab(license, trn, model, driver, status, year);
				
				try {
					output.writeObject(cab);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println(license+""+""+driver+""+status+"");
			}
		});
		btnNewButton.setBounds(157, 265, 102, 30);
		frame.getContentPane().add(btnNewButton);
	}
}
