package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Databases.*;
import Classes.*;

public class RequestHandler implements Runnable{
	
	private final Socket client;
	private ObjectOutputStream output = null; 
	private ObjectInputStream input = null;
	
	public RequestHandler(Socket clientConnection)
	{
		client = clientConnection;
	}
	
	public void connectStreams()
	{
		try {
		output = new ObjectOutputStream(client.getOutputStream());
		input = new ObjectInputStream(client.getInputStream()); 
		}catch(IOException e)
		{
			System.err.println(e.getMessage()); 
			e.printStackTrace();
		}
	}

	public void run() {
		//TODO Auto-generated method stub
		int options = 0; 
		
			try {
				connectStreams();
				options = input.readInt();
				switch(options)
				{
				case 1:
					options = input.readInt();	
					dbActions(options, new CabDatabase());
				break; 
				case 2: 
					options = input.readInt();
					dbActions(options, new CustomerDatabase());
				break; 
				case 3:
					options = input.readInt();
					dbActions(options, new ManagementDatabase());
				break; 
				case 4: 
					options = input.readInt();
					dbActions(options, new RatingDatabase());
				break; 
				case 5:
					options = input.readInt();
					dbActions(options, new RequestDatabase());
				break;
				default: 
					System.out.print("Something happened, the wrong option may have been chosen.");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void dbActions(int options, CabDatabase cabDB)
	{
		switch(options)
		{
			case 1:
			try {
				Cab cab = (Cab)input.readObject();
				output.writeInt(cabDB.add(cab)); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			case 2: 
			try {
				output.writeObject(cabDB.selectAll());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break; 
			case 3:
			try {
				String licenseNumber = (String)input.readObject();
				output.writeObject(cabDB.show(licenseNumber));
				output.flush();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4: 
			try {
				String licenseNumber = (String)input.readObject();
				output.writeObject(cabDB.show(licenseNumber));
				Cab cab = (Cab)input.readObject();
				output.writeInt(cabDB.update(cab, cab.getLicenseNumber()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 5:
			try {
				String licenseNumber  = (String)input.readObject();
				output.writeInt(cabDB.delete(licenseNumber)); 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default: 
				System.out.println("An error occured please try again!!!"); 
			break; 
		}
		try {
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dbActions(int options, CustomerDatabase customerDB)
	{
		switch(options)
		{
			case 1:
			try {
				Customer customer = (Customer)input.readObject();
				output.writeInt(customerDB.add(customer));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			case 2: 
			try {
				output.writeObject(customerDB.selectAll());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break; 
			case 3:
			try {
				int phoneNumber = input.readInt();
				output.writeObject(customerDB.show(phoneNumber));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4: 
			try {
				int phoneNumber = input.readInt();
				output.writeObject(customerDB.show(phoneNumber));
				Customer customer = (Customer)input.readObject();
				output.writeInt(customerDB.update(customer, customer.getPhoneNumber()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 5:
			try {
				int phoneNumber  = input.readInt();
				output.writeInt(customerDB.delete(phoneNumber)); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default: 
				System.out.println("An error occured please try again!!!"); 
			break; 
		}
	}
	
	public void dbActions(int options,  ManagementDatabase manageDB)
	{
		switch(options)
		{
			case 1:
			try {
				Manager manager = (Manager)input.readObject();
				output.writeInt(manageDB.add(manager));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			case 2: 
			try {
				output.writeObject(manageDB.selectAll());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break; 
			case 3:
			try {
				int id = input.readInt();
				output.writeObject(manageDB.show(id));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4: 
			try {
				int id = input.readInt();
				output.writeObject(manageDB.show(id));
				Manager manager = (Manager)input.readObject();
				output.writeInt(manageDB.update(manager, manager.getId()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 5:
			try {
				int id  = input.readInt();
				output.writeInt(manageDB.delete(id)); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default: 
				System.out.println("An error occured please try again!!!"); 
			break; 
		}
	}
	
	public void dbActions(int options, RatingDatabase ratingDB)
	{
		switch(options)
		{
			case 1:
			try {
				Rating rating = (Rating)input.readObject();
				output.writeInt(ratingDB.add(rating));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			case 2: 
			try {
				output.writeObject(ratingDB.selectAll());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break; 
			case 3:
			try {
				int requestNumber = input.readInt();
				output.writeObject(ratingDB.show(requestNumber));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4: 
			try {
				int requestNumber = input.readInt();
				output.writeObject(ratingDB.show(requestNumber));
				Rating rating = (Rating)input.readObject();
				output.writeInt(ratingDB.update(rating, rating.getRequestNumber()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 5:
			try {
				int requestNumber = input.readInt();
				output.writeInt(ratingDB.delete(requestNumber)); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default: 
				System.out.println("An error occured please try again!!!"); 
			break; 
		}
	}
	
	public void dbActions(int options, RequestDatabase requestDB)
	{
		switch(options)
		{
			case 1:
			try {
				Request request = (Request)input.readObject();
				output.writeInt(requestDB.add(request));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break; 
			case 2: 
			try {
				output.writeObject(requestDB.selectAll());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break; 
			case 3:
			try {
				int requestNumber = input.readInt();
				output.writeObject(requestDB.show(requestNumber));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4: 
			try {
				int requestNumber = input.readInt();
				output.writeObject(requestDB.show(requestNumber));
				Request request = (Request)input.readObject();
				output.writeInt(requestDB.update(request, request.getRequestNumber()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 5:
			try {
				int requestNumber = input.readInt(); 
				output.writeInt(requestDB.delete(requestNumber)); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default: 
				System.out.println("An error occured please try again!!!"); 
			break; 
		}
	}
}
