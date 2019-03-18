package Classes;

import java.util.Date;

public class Rating {

	private int requestNumber;
	private int experience;
	private String feedback;
	private Date date;
	
	public Rating() {
		this(0,0,"");
	}
	
	public Rating(int requestNumber, int experience, String feedback) {
		super();
		this.requestNumber = requestNumber;
		this.experience = experience;
		this.feedback = feedback;
	}


	public int getRequestNumber() {
		return requestNumber;
	}


	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Rating [requestNumber=" + requestNumber + ", experience=" + experience + ", feedback=" + feedback
				+ ", date=" + date + "]";
	}
	
	
	
	
}
