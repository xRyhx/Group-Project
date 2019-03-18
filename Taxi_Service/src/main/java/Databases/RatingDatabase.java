package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Rating;

public class RatingDatabase extends SQLDatabase<Rating> {

	private static final String Table_Name = "ratings";
	@Override
	protected void InitialSQLDatabase() {
		try {
			stat = con.createStatement();
			if(stat.execute("create table if not exsists" +Table_Name+ " (requestNumber INTEGER, experience INTEGER, feedback varchar(50), date DATE) ")) {
				
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Rating> selectAll() {
		List<Rating> Class = new ArrayList<Rating>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " +Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Rating item = new Rating();
				item.setRequestNumber(rs.getInt(1));
				item.setExperience(rs.getInt(2));
				item.setFeedback(rs.getString(3));
				item.setDate(rs.getDate(4));
				
				Class.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Class;
	}

	@Override
	public Rating show(int requestNumber) {
		String search = "SELECT requestNumber,experience,feedback,date FROM +Table_Name WHERE requestNumber = ? ";
		try {
			rs = stat.executeQuery(search);
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+","+rs.getInt(2)+","+rs.getString(3)+","+rs.getDate(4));
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
	public int update(Rating Fields, int requestNumber) {
		String update = "UPDATE +Table_Name WHERE requestNumber = ?";
		try {
			stat.executeQuery(update);
			
			
			update = "SELECT requestNumber,experience,feedback,date FROM +Table_Name";
			
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
			rs.close();
			
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
		return 0;
	}

	@Override
	public int delete(int requestNumber) {
		String delete = "DELETE FROM +Table_Name WHERE requestNumber = ?";
		try {
			stat.executeQuery(delete);
			
			
			delete = "SELECT requestNumber,experience,feedback,date FROM +Table_Name";
			
			rs = stat.executeQuery(delete);
			while(rs.next()) {
				rs.getInt(requestNumber);
				int experience = rs.getInt(2);
				String Feedback = rs.getString(3);
				Date date = rs.getDate(4);
				
				System.out.println("Request Number for Rating: " +requestNumber);
				System.out.println("Cab experience: " +experience);
				System.out.println("Customer Feedback: " +Feedback);
				System.out.println("Date:" +date);
			}
			rs.close();
			
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
		return 0;
	}

	@Override
	public int add(Rating Fields) {
		String sql = "INSERT INTO "+Table_Name+ " (requestNumber, experience, feedback, date) values (?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Fields.getRequestNumber());
			st.setInt(2, Fields.getExperience());
			st.setString(3, Fields.getFeedback());
			st.setDate(4, (java.sql.Date) Fields.getDate());
			return st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
}


