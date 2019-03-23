package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Request;

public class RequestDatabase extends SQLDatabase<Request>{

	private static final String Table_Name = "cab_Request";
	@Override
	protected void InitialSQLDatabase() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS " + Table_Name + " (RequestNumber INTEGER PRIMARY KEY AUTOINCREMENT, time DATE, Location varchar(30), Distance INTEGER, Quote FLOAT, Avalability varchar(20) )"; 
			Statement statement = con.createStatement(); 
			if(statement.execute(sql)) {
				System.out.println("Created " + Table_Name + " for the first time.");
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Request> selectAll() {
		List<Request> requestList = new ArrayList<Request>();
		try {
			Statement statement = con.createStatement(); 
			String sql = "SELECT * FROM " + Table_Name;
		
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Request item = new Request();
				item.setRequestNumber(rs.getInt(1));
				item.setTime(rs.getDate(2));
				item.setLocation(rs.getString(3));
				item.setDistance(rs.getInt(4));
				item.setQuote(rs.getFloat(5));
				item.setAvailability(rs.getString(6));
				
				requestList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return requestList;
	}

	@Override
	public Request show(int requestNumber) {
		String search = "SELECT location,distance,quote,time FROM " + Table_Name + " WHERE requestNumber = ? "; 
		try {
			stat = con.prepareStatement(search);
			stat.setInt(1, requestNumber);
			rs = stat.executeQuery();
			Request request = new Request();
			if(rs.next()) 
			{
					request.setRequestNumber(rs.getInt(1));
					request.setTime(rs.getDate(2));
					request.setLocation(rs.getString(3));
					request.setDistance(rs.getInt(4));
					request.setQuote(rs.getInt(5));
					request.setAvailability(rs.getString(6));
					
	
			}else {
				System.out.println("Record not Found");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Request Fields, int requestNumber) {
		String update = "UPDATE " + Table_Name + " WHERE requestNumber = ?";
		try {
			stat = con.prepareStatement(update); 
			stat.setInt(1, requestNumber);
			rs = stat.executeQuery();
			update = "SELECT requestNumber,time,location,distance,quote,availability FROM " + Table_Name;
		
			while(rs.next()) {
				rs.getInt(requestNumber);
				Date time = rs.getDate(2);
				String Location = rs.getString(3);
				int Distance = rs.getInt(4);
				float Quote = rs.getFloat(5);
				String Availability = rs.getString(6);
				System.out.println("Request Number:" +requestNumber);
				System.out.println("Time of Request: " +time);
				System.out.println("Location: " +Location);
				System.out.println("Distance:" +Distance);
				System.out.println("Quote:" +Quote);
				System.out.println("Availability:" +Availability);
				
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stat!=null) {
					con.close();
				}
			}catch(SQLException e) {
				
			}try {
				if(con!=null) {
					con.close();
				}
				
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(int requestNumber) {
		String delete = "DELETE FROM " + Table_Name + "WHERE requestNumber = ?";
		int affectedRows = 0;
		try {
			stat = con.prepareStatement(delete); 
			stat.setInt(1, requestNumber);
			affectedRows = stat.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stat!=null) {
					con.close();
				}
			}catch(SQLException e) {
				
			}try {
				if(con!=null) {
					con.close();
				}
				
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
	
		return affectedRows;
	}

	@Override
	public int add(Request Fields) {
		int affectedRows = 0;
		String sql = "INSERT INTO " + Table_Name + " (requestNumber, time, location, distance, quote, availability) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setInt(1, Fields.getRequestNumber());
			stat.setDate(2, (java.sql.Date) Fields.getTime());
			stat.setString(3, Fields.getLocation());
			stat.setInt(4, Fields.getDistance());
			stat.setFloat(5, Fields.getQuote());
			stat.setString(6, Fields.getAvailability());
			affectedRows = stat.executeUpdate(); 
			if(affectedRows != 0)
				System.out.println("Record successfully added");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}
