package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class CabFeedback {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CabFeedback window = new CabFeedback();
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
	public CabFeedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(-8, -29, 450, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeedback.setBounds(171, 11, 134, 23);
		frame.getContentPane().add(lblFeedback);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(175, 51, 233, 30);
		frame.getContentPane().add(textField);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(80, 58, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setBounds(80, 102, 46, 14);
		frame.getContentPane().add(lblRating);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 140, 233, 95);
		frame.getContentPane().add(textField_2);
		
		JLabel lblComments = new JLabel("Comments :");
		lblComments.setBounds(80, 147, 85, 14);
		frame.getContentPane().add(lblComments);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBounds(173, 98, 38, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(213, 98, 38, 23);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("4");
		radioButton_2.setBounds(295, 97, 38, 23);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		radioButton_3.setBounds(255, 97, 38, 23);
		frame.getContentPane().add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setBounds(336, 97, 38, 23);
		frame.getContentPane().add(radioButton_4);
		
		final ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		group.add(radioButton_2);
		group.add(radioButton_3);
		group.add(radioButton_4);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String rating = null;
				Enumeration<AbstractButton> allRadioButton=group.getElements();  
		        while(allRadioButton.hasMoreElements())  
		        {  
		           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
		           if(temp.isSelected()){
		        	   rating=temp.getText();  
		           }  
		        }
				String comment = textField_2.getText();
				
				//Write to function
				System.out.println(name+rating+comment);
				
			}
		});
		button.setBounds(168, 252, 109, 36);
		frame.getContentPane().add(button);
		
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MakeRequest MR = new MakeRequest();
				MR.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnBack.setBounds(336, 259, 89, 23);
		frame.getContentPane().add(btnBack);
		
	}
}
