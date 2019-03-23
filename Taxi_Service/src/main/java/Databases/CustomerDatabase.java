package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Customer;

public class CustomerDatabase extends SQLDatabase<Customer> {
	
	private static final String Table_Name = "customer";

	@Override
	protected void InitialSQLDatabase() {
		try {
			stat = con.createStatement();
			if(stat.execute("Create Table if not exsists " +Table_Name + "(phoneNumber INTEGER PRIMARY KEY, email varchar(10), fname varchar(20), lname varchar(20) )")) {
				
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> Class = new ArrayList<Customer>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " +Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Customer item = new Customer();
				item.setPhoneNumber(rs.getInt(1));
				item.setEmail(rs.getString(2));
				item.setFName(rs.getString(3));
				item.setLname(rs.getString(4));
				
				Class.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Class;
	}

	@Override
	public Customer show(int phoneNumber) {
		String search = "SELECT fname,lname FROM " + Table_Name + " WHERE phoneNumber = ? ";
		try {
			rs = stat.executeQuery(search);
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
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
	public int update(Customer Fields, int phoneNumber) {
		String update = "UPDATE"  +Table_Name + " WHERE phoneNumber =  "+ phoneNumber;
		try {
			stat.executeQuery(update);
			
			update = "SELECT phoneNumber, email, fname, lname FROM +Table_Name";
			rs = stat.executeQuery(update);
			while(rs.next()) {
				rs.getInt(phoneNumber);
				String email = rs.getString(2);
				String Fname = rs.getString(3);
				String Lname = rs.getString(4);
				
				System.out.println("Customer Phone Number" +phoneNumber);
				System.out.println("Customer Email: " +email);
				System.out.println("Customer Name: " +Fname +Lname);
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
	public int delete(int phoneNumber) {
		String delete = "DELETE FROM"  + Table_Name + "WHERE phoneNumber = " + phoneNumber;
		try {
			stat.executeQuery(delete);
			
			
			delete = "SELECT phoneNumber,email,Fname,Lname FROM +Table_Name";
			
			rs = stat.executeQuery(delete);
			while(rs.next()) {
				rs.getInt(phoneNumber);
				String email = rs.getString(2);
				String FName = rs.getString(3);
				String LName = rs.getString(4);
				
				System.out.println("Customer Phone Number: " +phoneNumber);
				System.out.println("Customer Email: " +email);
				System.out.println("Customer Name: " +FName +LName);
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
