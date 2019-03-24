package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Classes.Rating;

public class RatingDatabase extends SQLDatabase<Rating> {

private static final String Table_Name = "ratings_table";//lowercase for table name.

	

	public RatingDatabase(){

		super(); 

		String sql = "CREATE TABLE IF NOT EXISTS " + Table_Name + 

				" (requestNumber INTEGER, experience INTEGER, feedback varchar(50), date DATE)";

		try {

			stat = con.createStatement();

			if(stat.execute(sql)) 

				System.out.println("Table created for the first time");

		}catch(SQLException e) {

			e.printStackTrace();

		}

		

	}



	@Override

	public List<Rating> selectAll() {

		List<Rating> ratingList = new ArrayList<Rating>();

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

				

				ratingList.add(item);

			}

		}catch(SQLException e) {

			e.printStackTrace();

		}

		return ratingList;

	}





	public Rating show(int requestNumber) {

		String search = "SELECT * FROM" + Table_Name + "WHERE requestNumber = ?";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(search); 

			preparedStatement.setInt(1, requestNumber); 

			rs  = preparedStatement.executeQuery();

			if(rs.next()) {

				Rating rating = new Rating();

				rating.setRequestNumber(rs.getInt(1));

				rating.setExperience(rs.getInt(2));

				rating.setFeedback(rs.getString(3));

				rating.setDate(rs.getDate(4));

				return rating;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;

	}





	public int update(Rating Fields, int requestNumber) {

		String update = "UPDATE  SET requestNumber = ?, SET experience = ?, SET feedback = ?,"

				+ " SET date = ?" + Table_Name+ " WHERE requestNumber = ?";

		

		int affectedRows = 0;

		

		try {

			

			PreparedStatement preparedStatement = con.prepareStatement(update); 

			preparedStatement.setInt(1, Fields.getRequestNumber());

			preparedStatement.setInt(2, Fields.getExperience()); 

			preparedStatement.setString(3, Fields.getFeedback());

			preparedStatement.setDate(4, (java.sql.Date) Fields.getDate());//cast

			preparedStatement.setInt(5, Fields.getRequestNumber());

			affectedRows = preparedStatement.executeUpdate();	

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



		return affectedRows;

	}





	public int delete(int requestNumber) {

		String delete = "DELETE FROM " +Table_Name + " WHERE requestNumber = ?";

		int affectedRows = 0;

		try {

			PreparedStatement preparedStatement = con.prepareStatement(delete); 

			preparedStatement.setInt(1, requestNumber);

			affectedRows = preparedStatement.executeUpdate();

			rs = stat.executeQuery(delete);	

		} catch (SQLException e) {

			e.printStackTrace();

		}catch(Exception e) {

			e.printStackTrace();

		}

		

		return affectedRows;

	}



	@Override

	public int add(Rating Fields) {

		String sql = "INSERT INTO "+Table_Name+ " (requestNumber, experience, feedback, date) values (?, ?, ?, ?)";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, Fields.getRequestNumber());

			st.setInt(2, Fields.getExperience());

			st.setString(3, Fields.getFeedback());

			st.setDate(4, (java.sql.Date) Fields.getDate());//cast

			return st.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}

		return 0;



	}
}



