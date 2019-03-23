package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Manager;


public class ManagementDatabase extends SQLDatabase<Manager> {
	
	private static final String table_name = "management";

	@Override
	protected void InitialSQLDatabase() {
		try {
			String sql = "Create Table if not exsisted " + table_name +  " ( id INTEGER PRIMARY KEY AUTOINCREMENT, email_address varchar(45), password varchar(45) )";
			Statement statement = con.createStatement();
			if(statement.execute(sql)) {
				System.out.println("Table Successfully created for the first time.");
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Manager> selectAll() {
		List<Manager> managerList = new ArrayList<Manager>();
		try {
			Statement statement = con.createStatement();
			String sql = "SELECT * FROM " +table_name;
			rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Manager item = new Manager();
				item.setId(rs.getInt(1));
				item.setEmail_Address(rs.getString(2));
				item.setPassword(rs.getString(3));
				managerList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return managerList;
	}

	@Override
	public Manager show(int id) {
		String search = "SELECT email_address FROM" + table_name + " WHERE id = ?";
		try {
			stat = con.prepareStatement(search);
			rs = stat.executeQuery();
			if(rs.next()) 
					System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(Manager Fields, int id) {
		String update = "UPDATE" + table_name + " WHERE id =  " + id;
		try {
			stat.executeQuery(update);
			
			update = "SELECT id, email_address, password FROM " + table_name;
			rs = stat.executeQuery(update);
			while(rs.next()) {
				rs.getInt(id);
				String email = rs.getString(2);
				String pass = rs.getString(3);
				
				
				System.out.println("Manager ID:" +id);
				System.out.println("Manager Email: " +email);
				System.out.println("Manager Password: " +pass);
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
	public int delete(int id) {
		String delete = "DELETE FROM " + table_name + " WHERE id = " + id;
		try {
			stat.executeQuery(delete);
			
			
			delete = "SELECT id,email_address,password FROM "+ table_name;
			
			rs = stat.executeQuery(delete);
			while(rs.next()) {
				rs.getInt(id);
				String email = rs.getString(2);
				String pass = rs.getString(3);
				
				
				System.out.println("Manager id: " +id);
				System.out.println("Manager Email: " +email);
				System.out.println("Manager Password: " +pass);
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
	public int add(Manager Fields) {
		String sql = "INSERT INTO "+ table_name + " (id, email_address, password) values (?, ?, ?)";
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
