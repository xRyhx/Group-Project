package Databases;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Rating;

public class RatingDatabase extends SQLDatabase<Rating> {

	private static final String Table_Name = "ratings";
	@Override
	protected void InitialSQLDatabase() {
		try {
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS" + Table_Name + " (requestNumber INTEGER, experience INTEGER, feedback varchar(50), date DATE)" ;
			if(statement.execute(sql)) 
				System.out.println("Table successfully created for the first time.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Rating> selectAll() {
		List<Rating> ratingList = new ArrayList<Rating>();
		try {
			Statement stat = con.createStatement();
			String sql ="SELECT * FROM " +Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Rating item = new Rating();
				item.setRequestNumber(rs.getInt(1));
				item.setExperience(rs.getInt(2));
				item.setFeedback(rs.getString(3));
				item.setDate(rs.getDate(4));
				ratingList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ratingList;
	}

	@Override
	public Rating show(int requestNumber) {
		String search = "SELECT requestNumber,experience,feedback,date FROM" + Table_Name + "WHERE requestNumber = ? ";
	
		try {
			stat = con.prepareStatement(search); 
			rs = stat.executeQuery();
			if(rs.next()) 
					System.out.println(rs.getInt(1)+","+rs.getInt(2)+","+rs.getString(3)+","+rs.getDate(4));
			else 
				System.out.println("Record not found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Rating Fields, int requestNumber) {
		String update = "UPDATE " + Table_Name+ " WHERE requestNumber = ?";
		try {
			stat.executeQuery(update);
			
			
			update = "SELECT requestNumber,experience,feedback,date FROM" + Table_Name;
			
			rs = stat.executeQuery(update);
			while(rs.next()) {
				rs.getInt(requestNumber);
				int experience = rs.getInt(2);
				String Feedback = rs.getString(3);
				Date date = rs.getDate(4);
				
				System.out.println("Request Number for Rating: " +requestNumber);
				System.out.println("Cab experience: " +experience);
				System.out.println("Customer Feedbacl: " +Feedback);
				System.out.println("Date:" +date);
			}
			
		} catch (SQLException e) {
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
			affectedRows = stat.executeUpdate();
		} catch (SQLException e) {
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
		return affectedRows;
	}

	@Override
	public int add(Rating Fields) {
		String sql = "INSERT INTO " + Table_Name +" (requestNumber, experience, feedback, date) values (?, ?, ?, ?)";
		int affectedRows = 0;
		try {
			stat = con.prepareStatement(sql);
			stat.setInt(1, Fields.getRequestNumber());
			stat.setInt(2, Fields.getExperience());
			stat.setString(3, Fields.getFeedback());
			stat.setDate(4, (java.sql.Date) Fields.getDate());
			affectedRows = stat.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}


