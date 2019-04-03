package Classes;

import java.io.Serializable;
import java.util.Scanner;

public class Manager implements Serializable, UserInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1022789766420734192L;
	private int id;
	private String email_Address;
	private String password;
	private boolean firstUse = false; 
	public Manager() {
		this(0,"","");
		firstUse = true;
	}

	public Manager(int id, String email_Address, String password) {
		this.id = id;
		this.email_Address = email_Address;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail_Address() {
		return email_Address;
	}

	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", email_Address=" + email_Address + ", password=" + password + "]";
	}

	public void UpdateFields() {
		if(firstUse == true)
		{
			System.out.println("It's the first time your using this object will call populate fields."); 
			populateFields();
			return;
		}
		
		Scanner input = new Scanner(System.in); 
		int options;
		
		while(true)
		{
			System.out.println("Enter 1 to update id: ");
			System.out.println("Enter 2 to update email address: ");
			System.out.println("Enter 3 to update password: ");
			System.out.println("Enter 4 to quit: "); 
			options = input.nextInt(); 
				switch(options)
				{
				case 1:
					System.out.println("Enter id: ");
					setId(input.nextInt());
					break; 
				case 2:
					System.out.println("Enter email address: ");
					setEmail_Address(input.nextLine());
					break; 
				case 3:
					System.out.println("Enter password: ");
					setPassword(input.nextLine());
					break; 
				case 4:
					break;
				default:
					System.out.println("Oops that option doesn't exist."); 
					break;
				}
			if(options == 4)
				break;
		}
		
		input.close();
	}

	public void populateFields() {
		Scanner input = new Scanner(System.in);		
		System.out.println("Enter id: ");
		setId(input.nextInt());
		System.out.println("Enter email address: ");
		setEmail_Address(input.nextLine());
		System.out.println("Enter password: ");
		setPassword(input.nextLine()); 
		input.close();
	}
}
