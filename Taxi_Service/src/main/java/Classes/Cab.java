package Classes;

public class Cab {

	private String licenseNumber;
	private int trn;
	private String model;
	private String driver;
	private String satus;
	private int year;
	
	public Cab() {
		this("",0,"","","",0);
	}

	public Cab(String licenseNumber, int trn, String model, String driver, String satus, int year) {
		super();
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
	
	
}
