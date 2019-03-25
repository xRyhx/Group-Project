package Classes;

import java.io.Serializable;
import java.util.Scanner;

public class Cab implements Serializable, UserInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3815172707468702683L;
	private String licenseNumber;
	private int trn;
	private String model;
	private String driver;
	private String satus;
	private int year;
	private boolean firstUse = false; //notes if the default constructor was called to prevent a malformed updated
	public Cab() {
		this("",0,"","","",0);
		firstUse = true;
	}

	public Cab(String licenseNumber, int trn, String model, String driver, String satus, int year) {
		this.licenseNumber = licenseNumber;
		this.trn = trn;
		this.model = model;
		this.driver = driver;
		this.satus = satus;
		this.year = year;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getTrn() {
		return trn;
	}

	public void setTrn(int trn) {
		this.trn = trn;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getSatus() {
		return satus;
	}

	public void setSatus(String satus) {
		this.satus = satus;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Cab [licenseNumber=" + licenseNumber + ", trn=" + trn + ", model=" + model + ", driver=" + driver
				+ ", satus=" + satus + ", year=" + year + "]";
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
		System.out.println("1)Enter 1 to update lincense number.");
		System.out.println("2)Enter 2 to update trn."); 
		System.out.println("3)Enter 3 to update model."); 
		System.out.println("4)Enter 4 to update driver."); 
		System.out.println("5)Enter 5 to update status");
		System.out.println("6)Enter 5 to update year");
		System.out.println("7)Enter 7 to quit"); 
		options = input.nextInt(); 
		switch(options)
		{
			case 1: 
				System.out.println("Enter license number: ");
				setLicenseNumber(input.nextLine()); 
				break;
			case 2:
				System.out.println("Enter trn: ");
				setTrn(input.nextInt());
				break; 
			case 3: 
				System.out.println("Enter model number: "); 
				setModel(input.nextLine()); 
				break; 
			case 4:
				System.out.println("Enter driver");
				setDriver(input.nextLine());
				break; 
			case 5:
				System.out.println("Enter driver");
				setDriver(input.nextLine());
				break; 
			case 6: 
				System.out.println("Enter year: "); 
				setYear(input.nextInt()); 
				break; 
			case 7:
				break; 
			default: 
				System.out.println("Oops that option doesn't exist."); 
				break; 
		}
		if(options == 7)
			break;
	}
		input.close();
	}

	public void populateFields() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter license number: ");
		setLicenseNumber(input.nextLine()); 
		System.out.println("Enter trn: ");
		setTrn(input.nextInt());
		input.nextLine();
		System.out.println("Enter model number: "); 
		setModel(input.nextLine()); 
		System.out.println("Enter driver");
		setDriver(input.nextLine());
		System.out.println("Enter staus: "); 
		setDriver(input.nextLine()); 
		System.out.println("Enter year: "); 
		setYear(input.nextInt()); 
		input.close(); 
	}
}
