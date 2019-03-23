package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	private ServerSocket server = null; 
	private Socket client = null; 
	private ObjectOutputStream output = null; 
	private ObjectInputStream input = null; 
	int portNumber = 55000;
	
	public Server()
	{
		try {
			server = new ServerSocket(portNumber);//creates a SeverSocket and connects it to port 55,000
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void connectStreams()
	{
		
		try {
			output = new ObjectOutputStream(client.getOutputStream());
			input = new ObjectInputStream(client.getInputStream());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void closeStreams()
	{
		try {
			output.close();
			input.close(); 
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 
	public void makeConnection()//waits for a connection from a client
	{
			try {
				client = server.accept();
				connectStreams(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
	}
	
}
