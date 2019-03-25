package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

abstract public class SQLDatabase<D> {

	protected Connection con = null;
	protected Statement stat = null;
	protected ResultSet rs = null;
	
	private static final String Driver= "com.mysql.cj.jdbc.Driver";
	
	public SQLDatabase() {
		try {
			Class.forName(Driver).newInstance();
			String url = "jdbc:mysql://127.0.0.1:3306";
			con = DriverManager.getConnection(url);		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		try {
			if(con != null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	abstract public List<D> selectAll();
	abstract public int add(D Fields);
}



