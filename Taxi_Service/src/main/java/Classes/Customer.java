package Classes;

import java.io.Serializable;
import java.util.Scanner;

public class Customer implements Serializable, UserInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4589150761723404899L;
	private int phoneNumber;
	private String email;
	private String fname;
	private String lname;
	private boolean firstUse = false;
	
	public Customer() {
		this(0,"","","");
		firstUse = true;
	}
	
	public Customer(int phoneNumber, String email, String fname, String lname) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFName() {
		return fname;
	}

	public void setFName(String fname) {
		this.fname = fname;
	}
	
	

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Customer [phoneNumber=" + phoneNumber + ", email=" + email + ", fname=" + fname + ", lname=" + lname +"]";
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
			System.out.print("1)Enter 1 to update phone number: ");
			System.out.print("2)Enter 2 to update email: ");
			System.out.print("3)Enter 3 to update first name: ");
			System.out.print("4)Enter 4 to update last name: ");
			System.out.print("5)Enter 5 to quit: ");
			options = input.nextInt(); 
			switch(options)
			{
			case 1:
				System.out.println("Enter phone number: ");
				setPhoneNumber(input.nextInt());
				break;
			case 2:
				System.out.println("Enter email: ");
				setEmail(input.nextLine()); 
				break; 
			case 3:
				System.out.println("Enter first name: ");
				setFName(input.nextLine());
				break; 
			case 4:
				System.out.println("Enter last name: "); 
				setLname(input.nextLine());
				break; 
			case 5:
				break; 
			default:
				System.out.println("Oops that option doesn't exist."); 
				break; 
			}
			if(options == 5)
				break;
		}
		
		input.close();
	}

	public void populateFields() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter phone number: ");
		setPhoneNumber(input.nextInt());
		System.out.println("Enter email: ");
		setEmail(input.nextLine()); 
		System.out.println("Enter first name: ");
		setFName(input.nextLine());
		System.out.println("Enter last name: "); 
		setLname(input.nextLine());
		input.close(); 
	}
}
