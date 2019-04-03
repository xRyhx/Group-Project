package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Classes.*;

public class Client {
	private Socket socket = null; 
	private ObjectOutputStream output = null; 
	private ObjectInputStream input = null;
	private final String hostName = "127.0.0.1";
	private final int portNumber = 55000;
	
	public Client()
	{
		try {
			socket = new Socket(hostName, portNumber);
			setOutput(new ObjectOutputStream(socket.getOutputStream())); 
			setInput(new ObjectInputStream(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage()); 
			e.printStackTrace(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
			e.printStackTrace();
		} //connects to a socket on a port specified by port number
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public void setInput(ObjectInputStream input) {
		this.input = input;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public void setOutput(ObjectOutputStream output) {
		this.output = output;
	}
	
	public void close()
	{
		try {
			input.close();
			output.close(); 
			socket.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(NullPointerException e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void databaseActions()
	{
		System.out.println("Welcome, to our test server!!!");
		System.out.println("This is our taxi service.");
		int [] option = new int[2];
		try {
			
			while(true)
			{
			 Scanner in = new Scanner(System.in);
			 display(); 
			 option[0] = in.nextInt(); 
			 output.writeInt(option[0]);
			 output.flush();
			 databaseOptions();
			 option[1] = in.nextInt(); 
			 output.writeInt(option[1]);
			 output.flush(); 
			 switch(option[0])
			{
				case 1:
					Operations(option[1], new Cab());
					break; 
				case 2:
					Operations(option[1], new Customer());
					break; 
				case 3:
					Operations(option[1], new Manager());
					break; 
				case 4:
					Operations(option[1], new Rating());
					break; 
				case 5:
					Operations(option[1], new Request());
					break; 
				default:
					System.out.println("Option doesn't exist");
					break;
			}
			 in.close();
			}
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}

		}

	public void Operations(int option, Cab cab)
	{ 
		Scanner input = new Scanner(System.in); 
		switch(option)
		{
			case 1:
				cab.populateFields();	
			try {
				output.writeObject(cab);
				if(this.input.readInt() > 0)
					System.out.println("Successfully added!!!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				break; 
			case 2:
			try {
				List<Cab> cabList =  (List<Cab>) this.input.readObject();
				for(Cab item : cabList)
					System.out.println(item.toString());
			
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			break;
			case 3:
				System.out.println("Enter licencse number to search for: ");
			try {
				output.writeObject(input.nextLine());
				output.flush();
				cab = (Cab) this.input.readObject(); 
				if(cab != null)
				System.out.println(cab.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			break; 
			case 4:
				System.out.println("Enter licencse number to delete: ");
			try {
				output.writeObject(input.nextLine());
				cab = (Cab) this.input.readObject(); 
				cab.UpdateFields();
				output.writeObject(cab);
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated!!!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
			case 5:
				System.out.println("Enter licencse number to delete: ");
			try {
				output.writeObject(input.nextLine());
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			default:
			break;
			}
		input.close();
	}

	
	public void Operations(int option, Customer customer)
	{ 
		Scanner input = new Scanner(System.in); 
		switch(option)
		{
			case 1:

			try {
				output.writeObject(customer);
				if(this.input.readInt() > 0)
					System.out.println("Successfully added!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			case 2:
			try {
				List<Customer> customerList = (List<Customer>) this.input.readObject();
				for(Customer item : customerList)
					System.out.println(item);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 3:
				System.out.println("Enter phone number of the customer to search: ");
			try {
				output.writeObject(input.nextInt());
				output.flush();
				customer = (Customer) this.input.readObject(); 
				System.out.println(customer.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4:
				System.out.println("Enter phone number of the customer to update: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				customer = (Customer) this.input.readObject();
				customer.UpdateFields();
				output.writeObject(customer);
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			case 5:
				System.out.println("Enter phone number of the customer to update: ");
			try {
				output.writeInt(input.nextInt());
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
			break;
		} 
		input.close();
	}
	
	public void Operations(int option, Manager manager)
	{ 
		Scanner input = new Scanner(System.in); 
		switch(option)
		{
			case 1:
				manager.populateFields();
			try {
				output.writeObject(manager);
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully added");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			break;
			case 2:
			List<Manager> managerList;
			try {
				managerList = (List<Manager>) this.input.readObject();
				for(Manager item : managerList)
					System.out.println(item.toString());
				break; 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			case 3:
				System.out.println("Please enter id to search for: "); 
			try {
				output.writeInt(input.nextInt());
				output.flush();
				manager = (Manager) this.input.readObject(); 
				System.out.println(manager.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 4:
				System.out.println("Please enter id to update for: "); 
			try {
				output.writeInt(input.nextInt());
				output.flush();
				manager = (Manager) this.input.readObject(); 
				manager.UpdateFields();
				output.writeObject(manager); 
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
			break;
			case 5:
				System.out.println("Please enter id to delete: "); 
			try {
				output.writeInt(input.nextInt());
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully deleted");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			default:
			break; 
		}
		 input.close();
	}
	
	public void Operations(int option, Request request)
	{ 
		Scanner input = new Scanner(System.in);
		switch(option)
		{
			case 1:
				request.populateFields();
			try {
				output.writeObject(request);
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully added");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 2:
			try {
				List<Request> requestList = (List<Request>) this.input.readObject();
				for(Request item: requestList)
					System.out.println(item.toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			case 3:
				System.out.println("Enter request number to search for: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				try {
					request = (Request) this.input.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
				System.out.println(request.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4:
				System.out.println("Enter request number to update: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				request = (Request) this.input.readObject();
				request.UpdateFields();
				output.writeObject(request);
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			break;
			case 5:
				System.out.println("Enter request number to update: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully deleted");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
			break; 
		}
		input.close();
	}
	
	public void Operations(int option, Rating rating)
	{ 
		Scanner input = new Scanner(System.in);
		switch(option)
		{
			case 1:
				rating.populateFields();
			try {
				output.writeObject(rating);
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully added");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
			break;
			case 2: 
			try {
				List<Rating> ratingList = (List<Rating>) this.input.readObject();
				for(Rating item: ratingList)
					System.out.println(item.toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break; 
			case 3:
				System.out.println("Enter request number to search for: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				rating = (Rating) this.input.readObject();
				System.out.println(rating.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
			case 4:
				System.out.println("Enter request number to update: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				rating = (Rating) this.input.readObject();
				rating.UpdateFields();
				output.writeObject(rating);
				if(this.input.readInt() > 0)
					System.out.println("Successfully updated");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 5:
				System.out.println("Enter request number to update: ");
			try {
				output.writeInt(input.nextInt());
				output.flush();
				if(this.input.readInt() > 0)
					System.out.println("Successfully deleted");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
			break;
		}
		input.close();
	}
 	public void display()
	{
		System.out.println("1)Enter 1 to carry out operations on cab database.");
		System.out.println("2)Enter 2 to carry out operations on customer database.");
		System.out.println("3)Enter 3 to carry out operations on management database");
		System.out.println("4)Enter 4 to carry out operations on rating database");
		System.out.println("5)Enter 5 to carry out operations on request databse");
	}
	
	public void databaseOptions()
	{
		System.out.println("1)Enter 1 to add an record.");
		System.out.println("2)Enter 2 to view records."); 
		System.out.println("3)Enter 3 to search for a record.");
		System.out.println("4)Enter 4 to update a record.");
		System.out.println("5)Enter 5 to delete a record.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client taxiClient = new Client(); 
		taxiClient.databaseActions();
		taxiClient.close();
	}
}
