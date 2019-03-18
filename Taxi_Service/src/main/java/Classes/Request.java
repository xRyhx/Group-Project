package Classes;

import java.util.Date;

public class Request {

	private int requestNumber;
	private Date time;
	private String location;
	private int distance;
	private float quote;
	private String availability;
	
	public Request() {
	this(0,"",0,0.0f,"");
	}
	
	public Request(int requestNumber, String location, int distance, float quote, String availability) {
		super();
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
	
	
	
	
}
