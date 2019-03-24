package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Manager;


public class ManagementDatabase extends SQLDatabase<Manager> {
	
<<<<<<< HEAD
	private static final String table_name = "Management_Table";

	
	public  ManagementDatabase() {
		super();
		try {
			String sql = "CREATE TABLE IF NOT EXISTS" + table_name +  " ( id INTEGER PRIMARY KEY AUTOINCREMENT, email_address varchar(45), "
					+ "password varchar(45) )";
			stat = con.createStatement();
			if(stat.execute(sql)) 
				System.out.println("Table Created for the first time");
=======
private static final String table_name = "management_table";//lowercase



	

	public  ManagementDatabase() {

		super();

		try {

			String sql = "CREATE TABLE IF NOT EXISTS" + table_name +  " ( id INTEGER PRIMARY KEY AUTOINCREMENT, email_address varchar(45), "

					+ "password varchar(45) )";

			stat = con.createStatement();

			if(stat.execute(sql)) 

				System.out.println("Table Created for the first time");

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		}catch(SQLException e) {

			e.printStackTrace();

		}

		

	}



	@Override

	public List<Manager> selectAll() {
<<<<<<< HEAD
		List<Manager> managerList = new ArrayList<Manager>();
=======

		List<Manager> managerList = new ArrayList<Manager>();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		try {

			stat = con.createStatement();

			String sql = "SELECT * FROM " +table_name;

			

			rs = stat.executeQuery(sql);

			

			while(rs.next()) {

				Manager item = new Manager();

				item.setId(rs.getInt(1));

				item.setEmail_Address(rs.getString(2));

				item.setPassword(rs.getString(3));

				
<<<<<<< HEAD
				managerList.add(item);
=======

				managerList.add(item);

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
			}

		}catch(SQLException e) {

			e.printStackTrace();

		}
<<<<<<< HEAD
		return managerList;
	}

	
	public Manager show(int id) {
		String search = "SELECT * FROM" + table_name + " WHERE id = ? " + id;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(search);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				 Manager manager = new Manager(); 
				 manager.setId(rs.getInt(1));
				 manager.setEmail_Address(rs.getString(2));
				 manager.setPassword(rs.getString(3));
				 return manager;
		
			}	
=======

		return managerList;

	}



	

	public Manager show(int id) {

		String search = "SELECT * FROM" + table_name + " WHERE id = ? " + id;

		try {

			PreparedStatement preparedStatement = con.prepareStatement(search);

			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			if(rs.next()) {

				 Manager manager = new Manager(); 

				 manager.setId(rs.getInt(1));

				 manager.setEmail_Address(rs.getString(2));

				 manager.setPassword(rs.getString(3));

				 return manager;

		

			}	

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		} catch (SQLException e) {

			e.printStackTrace();

		}

		

		return null;

	}

<<<<<<< HEAD
	
	public int update(Manager Fields, int id) {
		String update = "UPDATE SET id = ?, SET email_address = ?, SET password = ?"
	   + table_name + " WHERE id = ? ";
		
		int affectedRows = 0; 
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(update); 
			preparedStatement.setInt(1, Fields.getId());
			preparedStatement.setString(2, Fields.getEmail_Address());
			preparedStatement.setString(3, Fields.getPassword());
			preparedStatement.setInt(4, id);
			affectedRows = preparedStatement.executeUpdate();
=======


	

	public int update(Manager Fields, int id) {

		String update = "UPDATE SET id = ?, SET email_address = ?, SET password = ?"

	   + table_name + " WHERE id = ? ";

		

		int affectedRows = 0; 

		

		try {

			PreparedStatement preparedStatement = con.prepareStatement(update); 

			preparedStatement.setInt(1, Fields.getId());

			preparedStatement.setString(2, Fields.getEmail_Address());

			preparedStatement.setString(3, Fields.getPassword());

			preparedStatement.setInt(4, id);

			affectedRows = preparedStatement.executeUpdate();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
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
<<<<<<< HEAD
		return affectedRows;
	}

	
	public int delete(int id) {
		String delete = "DELETE FROM " + table_name + " WHERE id = ?";
		int affectedRows = 0; 
		try {
			PreparedStatement preparedStatement = con.prepareStatement(delete); 
			preparedStatement.setInt(1, id);
			affectedRows = preparedStatement.executeUpdate();
=======

		return affectedRows;

	}



	

	public int delete(int id) {

		String delete = "DELETE FROM " + table_name + " WHERE id = ?";

		int affectedRows = 0; 

		try {

			PreparedStatement preparedStatement = con.prepareStatement(delete); 

			preparedStatement.setInt(1, id);

			affectedRows = preparedStatement.executeUpdate();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
			

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
<<<<<<< HEAD
		
		return affectedRows;
=======

		

		return affectedRows;

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
	}



	@Override

	public int add(Manager Fields) {
<<<<<<< HEAD
		String sql = "INSERT INTO "+ table_name + " (id, email_address, password) values (?, ?, ?)";
=======

		String sql = "INSERT INTO "+ table_name + " (id, email_address, password) values (?, ?, ?)";

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, Fields.getId());

			st.setString(2, Fields.getEmail_Address());

			st.setString(3, Fields.getPassword());

			return st.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}

		return 0;

	}



}
