package Classes;

public class Manager {

	private int id;
	private String email_Address;
	private String password;
	
	public Manager() {
		this(0,"","");
	}

	public Manager(int id, String email_Address, String password) {
		super();
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
	
	
	
	
}
