package Classes;

import java.io.Serializable;
import java.sql.Date;
import java.util.Scanner;

public class Rating implements Serializable, UserInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2333897549113293221L;
	private int requestNumber;
	private int experience;
	private String feedback;
	private Date date;
	private boolean firstUse = false;
	
	public Rating() {
		this(0,0,"");
	}
	
	public Rating(int requestNumber, int experience, String feedback) {
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
			System.out.println("Enter 2 to update to experience number: ");
			System.out.println("Enter 3 to update to feedback: "); 
			System.out.println("Enter 4 to quit: ");
			options = input.nextInt(); 
			switch(options)
			{
				case 1:
					System.out.println("Enter request number: "); 
					setRequestNumber(input.nextInt());
					break;
				case 2:
					System.out.println("Enter the experience number: "); 
					setExperience(input.nextInt());
					break; 
				case 3:
					System.out.println("Enter feedback: ");
					setFeedback(input.nextLine());
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
		System.out.println("Enter request number: "); 
		setRequestNumber(input.nextInt());
		System.out.println("Enter the experience number: "); 
		setExperience(input.nextInt());
		System.out.println("Enter feedback: ");
		setFeedback(input.nextLine());
		input.close();
	}
}
