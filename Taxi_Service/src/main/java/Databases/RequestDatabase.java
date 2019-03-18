package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Request;

public class RequestDatabase extends SQLDatabase<Request>{

	private static final String Table_Name = "cab_Request";
	@Override
	protected void InitialSQLDatabase() {
		try {
			stat = con.createStatement();
			if(stat.execute("Create Table if not exsists " +Table_Name + "(RequestNumber INTEGER PRIMARY KEY AUTOINCREMENT, time DATE, Location varchar(30), Distance INTEGER, Quote FLOAT,Avalability varchar(20) )")) {
				
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Request> selectAll() {
		List<Request> Class = new ArrayList<Request>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " +Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Request item = new Request();
				item.setRequestNumber(rs.getInt(1));
				item.setTime(rs.getDate(2));
				item.setLocation(rs.getString(3));
				item.setDistance(rs.getInt(4));
				item.setQuote(rs.getFloat(5));
				item.setAvailability(rs.getString(6));
				
				Class.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Class;
	}

	@Override
	public Request show(int requestNumber) {
		String search = "SELECT location,distance,quote,time FROM +Table_Name WHERE requestNumber = ? ";
		try {
			rs = stat.executeQuery(search);
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+","+rs.getDate(2)+","+rs.getString(3)+","+rs.getInt(4)+","+rs.getFloat(5)+","+rs.getString(6));
				}while(rs.next());
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
		String update = "UPDATE +Table_Name WHERE requestNumber = ? ";
		try {
			stat.executeQuery(update);
			
			update = "SELECT requestNumber,time,location,distance,quote,availability FROM +Table_Name";
			rs = stat.executeQuery(update);
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
		System.out.println("Record Updated");
		return 0;
	}

	@Override
	public int delete(int requestNumber) {
		String delete = "DELETE FROM +Table_Name WHERE requestNumber = ?";
		try {
			stat.executeQuery(delete);
			
			
			delete = "SELECT requestNumber,time,location,distance,quote,availability FROM +Table_Name";
			
			rs = stat.executeQuery(delete);
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
		System.out.println("Record Deleted");
		return 0;
	}

	@Override
	public int add(Request Fields) {
		String sql = " INSERT INTO " +Table_Name+ " (requestNumber, time, location, distance, quote, availability) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Fields.getRequestNumber());
			st.setDate(2, (java.sql.Date) Fields.getTime());
			st.setString(3, Fields.getLocation());
			st.setInt(4, Fields.getDistance());
			st.setFloat(5, Fields.getQuote());
			st.setString(6, Fields.getAvailability());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
