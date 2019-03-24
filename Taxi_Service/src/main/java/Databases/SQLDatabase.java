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

	

	private static final String Driver= "com.mysql.cj.jbdc.Driver";//Driver name

	

	public SQLDatabase() {

		try {

			Class.forName(Driver).newInstance();

			String url = "jbdc:mysql://localhost:3306/taxi_service";//database name

			con = DriverManager.getConnection(url,"root","");//user and  password should be added		

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

	

	abstract public List<D> selectAll();

	abstract public int add(D Fields);
}



