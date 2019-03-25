package Classes;

import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;

public class Request implements Serializable, UserInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008250346227216927L;
	private int requestNumber;
	private Date time;
	private String location;
	private int distance;
	private float quote;
	private String availability;
	private boolean firstUse = false;
	public Request() {
	this(0,"",0,0.0f,"");
	}
	
	public Request(int requestNumber, String location, int distance, float quote, String availability) {
		this.requestNumber = requestNumber;
		this.location = location;
		this.distance = distance;
		this.quote = quote;
		this.availability = availability;
	}



	public int getRequestNumber() {
		return requestNumber;
	}



	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}



	public Date getTime() {
		return time;
	}



	public void setTime(Date time) {
		this.time = time;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getDistance() {
		return distance;
	}



	public void setDistance(int distance) {
		this.distance = distance;
	}



	public float getQuote() {
		return quote;
	}



	public void setQuote(float quote) {
		this.quote = quote;
	}



	public String getAvailability() {
		return availability;
	}



	public void setAvailability(String availability) {
		this.availability = availability;
	}



	@Override
	public String toString() {
		return "Request [requestNumber=" + requestNumber + ", time=" + time + ", location=" + location + ", distance="
				+ distance + ", quote=" + quote + ", availability=" + availability + "]";
	}

	public void UpdateFields() 
	{
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
			System.out.println("Enter 1 to update request number: ");
			System.out.println("Enter 2 to update location: ");
			System.out.println("Enter 3 to update to distance: "); 
			System.out.println("Enter 4 to update quote: "); 
			System.out.println("Enter 5 to availability: ");
			System.out.println("Enter 6 to quit: "); 
			options = input.nextInt();
			
			switch(options)
			{
				case 1:
					System.out.println("Enter request number: ");
					setRequestNumber(input.nextInt());
					break; 
				case 2:
					System.out.println("Enter location: ");
					setLocation(input.nextLine());
					break; 
				case 3:
					System.out.println("Enter distance: ");
					setDistance(input.nextInt());
					break; 
				case 4:
					System.out.println("Enter quote: ");
					setQuote(input.nextInt());
					break; 
				case 5:
					System.out.println("Enter availability: "); 
					setAvailability(input.nextLine());
					break;
				case 6:
					break;
				default:
					System.out.println("Oops that option doesn't exist."); 
					break;
			}
			
			if(options == 6)
				break;
		}
		input.close();
	}

	public void populateFields()
	{
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter request number: ");
		setRequestNumber(input.nextInt());
		System.out.println("Enter location: ");
		setLocation(input.nextLine());
		System.out.println("Enter distance: ");
		setDistance(input.nextInt());
		System.out.println("Enter quote: ");
		setQuote(input.nextInt());
		System.out.println("Enter availability: "); 
		setAvailability(input.nextLine());
		input.close();
		
	}	
}
