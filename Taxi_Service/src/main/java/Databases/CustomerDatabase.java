package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Customer;

public class CustomerDatabase extends SQLDatabase<Customer> {
	
<<<<<<< HEAD
	private static final String Table_Name = "Customer_Table";
	private final String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + "(phoneNumber INTEGER PRIMARY KEY, "
			+ "email varchar(10), fname varchar(20), lname varchar(20) )";
	public CustomerDatabase(){
		super();
=======
	private static final String Table_Name = "customer";//Table name lowercast

	private final String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + "(phoneNumber INTEGER PRIMARY KEY, "

			+ "email varchar(10), fname varchar(20), lname varchar(20) )";

	public CustomerDatabase(){

		super();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		try {

			stat = con.createStatement();
<<<<<<< HEAD
			if(stat.execute(sql)) 
				System.out.println("Table Created successfully for the first time.");
=======

			if(stat.execute(sql)) 

				System.out.println("Table Created successfully for the first time.");

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		}catch(SQLException e) {

			e.printStackTrace();

		}

		

	}



	@Override

	public List<Customer> selectAll() {
<<<<<<< HEAD
		List<Customer> customerList = new ArrayList<Customer>();
=======

		List<Customer> customerList = new ArrayList<Customer>();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		try {

			stat = con.createStatement();
<<<<<<< HEAD
			String sql ="SELECT * FROM " + Table_Name;
=======

			String sql ="SELECT * FROM " + Table_Name;

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
			rs = stat.executeQuery(sql);

			

			while(rs.next()) {

				Customer item = new Customer();

				item.setPhoneNumber(rs.getInt(1));

				item.setEmail(rs.getString(2));

				item.setFName(rs.getString(3));

				item.setLname(rs.getString(4));
<<<<<<< HEAD
				customerList.add(item);
=======

				customerList.add(item);

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
			}

		}catch(SQLException e) {

			e.printStackTrace();

		}
<<<<<<< HEAD
		return customerList;
	}


	public Customer show(int phoneNumber) {
		String search = "SELECT fname,lname, email FROM " + Table_Name + " WHERE phoneNumber = ? ";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(search);
			preparedStatement.setInt(1, phoneNumber);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
			Customer customer = new Customer();
			customer.setFName(rs.getString(1));
			customer.setLname(rs.getString(2));
			customer.setEmail(rs.getString(3));
			customer.setPhoneNumber(phoneNumber);
			return customer;
				
			}
=======

		return customerList;

	}





	public Customer show(int phoneNumber) {

		String search = "SELECT fname,lname, email FROM " + Table_Name + " WHERE phoneNumber = ? ";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(search);

			preparedStatement.setInt(1, phoneNumber);

			rs = preparedStatement.executeQuery();

			if(rs.next()) {

			Customer customer = new Customer();

			customer.setFName(rs.getString(1));

			customer.setLname(rs.getString(2));

			customer.setEmail(rs.getString(3));

			customer.setPhoneNumber(phoneNumber);

			return customer;

				

			}

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		} catch (SQLException e) {

			e.printStackTrace();

		}

		

		return null;

	}


<<<<<<< HEAD
	public int update(Customer Fields, int phoneNumber) {
		String update = "UPDATE "  + Table_Name + " SET phooneNumber = ?, SET email = ?, SET fname = ?"
				+ "SET lname = ? WHERE phoneNumber =  "+ phoneNumber;
		int affectedRows = 0; 
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(update); 
			preparedStatement.setInt(1, Fields.getPhoneNumber()); 
			preparedStatement.setString(2, Fields.getEmail());
			preparedStatement.setString(3, Fields.getFName());
			preparedStatement.setString(4, Fields.getLname());
			preparedStatement.setInt(5, phoneNumber);
			affectedRows = preparedStatement.executeUpdate();
=======



	public int update(Customer Fields, int phoneNumber) {

		String update = "UPDATE "  + Table_Name + " SET phooneNumber = ?, SET email = ?, SET fname = ?"

				+ "SET lname = ? WHERE phoneNumber =  "+ phoneNumber;

		int affectedRows = 0; 

		try {

			

			PreparedStatement preparedStatement = con.prepareStatement(update); 

			preparedStatement.setInt(1, Fields.getPhoneNumber()); 

			preparedStatement.setString(2, Fields.getEmail());

			preparedStatement.setString(3, Fields.getFName());

			preparedStatement.setString(4, Fields.getLname());

			preparedStatement.setInt(5, phoneNumber);

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

	public int delete(int phoneNumber) {
		String sql = "DELETE FROM"  + Table_Name + "WHERE phoneNumber = ?";
		int affectedRows = 0; 
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, phoneNumber);
			affectedRows = preparedStatement.executeUpdate();
=======

		return affectedRows;

	}



	public int delete(int phoneNumber) {

		String sql = "DELETE FROM"  + Table_Name + "WHERE phoneNumber = ?";

		int affectedRows = 0; 

		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setInt(1, phoneNumber);

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

		System.out.println("Record Deleted");
<<<<<<< HEAD
		return affectedRows;
=======

		return affectedRows;

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
	}



	



	@Override

	public int add(Customer Fields) {

		String sql = "INSERT INTO "+Table_Name+ " (phoneNumber, email, First Name, Last Name) values (?, ?, ?, ?)";

		try {

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, Fields.getPhoneNumber());

			st.setString(2, Fields.getEmail());

			st.setString(3, Fields.getFName());

			st.setString(4, Fields.getLname());

			return st.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}

		return 0;



	}


}
