package Classes;

public class Customer {

	private int phoneNumber;
	private String email;
	private String fname;
	private String lname;
	
	public Customer() {
		this(0,"","","");
	}
	
	public Customer(int phoneNumber, String email, String fname, String lname) {
		super();
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
	
	
	
	
}
