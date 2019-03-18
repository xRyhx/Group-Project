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
	
	private static final String Driver= "com.mysql.jbdc.Driver";
	
	public SQLDatabase() {
		try {
			Class.forName(Driver).newInstance();
			String url = "jbdc:mysql://localhost:3306/taxi_Service";
			con = DriverManager.getConnection(url);
			
			InitialSQLDatabase();
			
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
	abstract protected void InitialSQLDatabase();

	abstract public List<D> selectAll();

	abstract public D show(int id);

	abstract public int update(D Fields,int id);
	
	abstract public int delete(int id);
	
	abstract public int add(D Fields);
}



