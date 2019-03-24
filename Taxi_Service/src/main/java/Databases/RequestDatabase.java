package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Request;

public class RequestDatabase extends SQLDatabase<Request>{


private static final String Table_Name = "cab_request";//lowercase for table name.

	

	public RequestDatabase(){

		super();

		String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + "(RequestNumber INTEGER PRIMARY KEY"

				+ " AUTOINCREMENT, time DATE, Location "

				+ "varchar(30), Distance INTEGER, Quote FLOAT,Avalability varchar(20) )";

		try {

			

			if(stat.execute(sql)) 

				System.out.println("Table created successfully for the first time.");

		}catch(SQLException e) {

			e.printStackTrace();

		}

		

	}



	@Override

	public List<Request> selectAll() {

		List<Request> requestList = new ArrayList<Request>();

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

				requestList.add(item);

			}

		}catch(SQLException e) {

			e.printStackTrace();

		}

		

		return requestList;

		

	}





	public Request show(int requestNumber) {

		String search = "SELECT * FROM"  + Table_Name + " WHERE requestNumber = ? ";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(search);

			preparedStatement.setInt(1, requestNumber);

			rs  = preparedStatement.executeQuery(); 

			

			if(rs.next()) {

				Request request  = new Request();

				request.setRequestNumber(rs.getInt(1));

				request.setTime(rs.getDate(2));

				request.setLocation(rs.getString(3));

				request.setDistance(rs.getInt(4));

				request.setQuote(rs.getFloat(5));

				request.setAvailability(rs.getString(5));

				return request;

			}

			

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;

	}



	

	public int update(Request Fields, int requestNumber) {

		String update = "UPDATE "+ Table_Name+ " SET requestNumber = ?, SET time = ?, SET location = ?, SET distance = ?, "

				+ ", availability = ?"

				+  "WHERE requestNumber = ? ";

		int affectedRows = 0; 

		try {

			PreparedStatement preparedStatement = con.prepareStatement(update); 

			preparedStatement.setInt(1, Fields.getRequestNumber());

			preparedStatement.setDate(2, (java.sql.Date) Fields.getTime());//cast

			preparedStatement.setString(3, Fields.getLocation());

			preparedStatement.setInt(4, Fields.getDistance());

			preparedStatement.setString(5, Fields.getAvailability());

			preparedStatement.setInt(6, requestNumber);

			affectedRows = preparedStatement.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}catch(Exception e) {

			e.printStackTrace();

		}

		return affectedRows;

	}



	

	public int delete(int requestNumber) {

		String delete = "DELETE FROM " + Table_Name +" WHERE requestNumber = ?";

		int affectedRows = 0;

		try {

			PreparedStatement preparedStatement = con.prepareStatement(delete); 

			preparedStatement.setInt(1, requestNumber);

			affectedRows = preparedStatement.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}catch(Exception e) {

			e.printStackTrace();

		}

		

		return affectedRows; 

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

			return st.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}

		return 0;

	}
}
