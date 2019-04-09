package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CabDatabase {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CabDatabase window = new CabDatabase();
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
	public CabDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCab = new JLabel("CAB");
		lblCab.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCab.setBounds(191, 30, 68, 23);
		frame.getContentPane().add(lblCab);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCab AC= new AddCab();
				AC.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(145, 77, 141, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("VIEW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCab VC=new ViewCab();
				VC.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(145, 120, 141, 32);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("SEARCH");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCab SC= new SearchCab();
				SC.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setBounds(145, 163, 141, 32);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("UPDATE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCab UC= new UpdateCab();
				UC.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_2.setBounds(145, 206, 141, 32);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("DELETE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCab DC= new DeleteCab();
				DC.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_3.setBounds(145, 249, 141, 32);
		frame.getContentPane().add(button_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu M=new MainMenu();
				M.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(345, 305, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
