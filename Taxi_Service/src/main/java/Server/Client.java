package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket = null; 
	private ObjectOutputStream output = null; 
	private ObjectInputStream input = null;
	private final String hostName = "localhost";
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
	
}
