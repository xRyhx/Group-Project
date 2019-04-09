package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Customer;

public class CustomerDatabase extends SQLDatabase<Customer> {
	
	private static final String Table_Name = "customer_table";
	 
	public CustomerDatabase(){
		super();
		try {
			stat = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + " (phoneNumber INTEGER PRIMARY KEY, "
			+ "email varchar(10), First_Name varchar(20), Last_Name varchar(20) )";
			if(stat.execute(sql)) 
				System.out.println("Table Created successfully for the first time.");
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " + Table_Name;
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Customer item = new Customer();
				item.setPhoneNumber(rs.getInt(1));
				item.setEmail(rs.getString(2));
				item.setFName(rs.getString(3));
				item.setLname(rs.getString(4));
				customerList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}


	public Customer show(int phoneNumber) {
		String search = "SELECT First_Name,Last_Name, email FROM " + Table_Name + " WHERE phoneNumber = ? ";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(search);
			preparedStatement.setInt(1, phoneNumber);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
			Customer customer = new Customer();
			customer.setPhoneNumber(phoneNumber);
			customer.setFName(rs.getString(1));
			customer.setLname(rs.getString(2));
			customer.setEmail(rs.getString(3));
			
			return customer;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int update(Customer Fields, int phoneNumber) {
		String update = "UPDATE "  + Table_Name + " set phoneNumber = ?, email = ?, First_Name = ?"
				+ ", Last_Name = ? where phoneNumber = ? ";
		int affectedRows = 0; 
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(update); 
			preparedStatement.setInt(1, Fields.getPhoneNumber()); 
			preparedStatement.setString(2, Fields.getEmail());
			preparedStatement.setString(3, Fields.getFName());
			preparedStatement.setString(4, Fields.getLname());
			preparedStatement.setInt(5, phoneNumber);
			affectedRows = preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	public int delete(int phoneNumber) {
		String sql = "DELETE FROM "  + Table_Name + " WHERE phoneNumber = ?";
		int affectedRows = 0; 
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, phoneNumber);
			affectedRows = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	

	@Override
	public int add(Customer Fields) {
		String sql = "INSERT INTO " +Table_Name+ " (phoneNumber, email, First_Name, Last_Name) values (?, ?, ?, ?)";
		int affectedrow = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Fields.getPhoneNumber());
			ps.setString(2, Fields.getEmail());
			ps.setString(3, Fields.getFName());
			ps.setString(4, Fields.getLname());
			affectedrow = ps.executeUpdate();
			return affectedrow;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

}
