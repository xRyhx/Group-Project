package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Cab;
import Classes.Customer;


public class CabDatabase extends SQLDatabase<Cab> {
<<<<<<< HEAD
	private static final String Table_Name = "Cab_Table";

	
	 public CabDatabase() {
		// TODO Auto-generated constructor stub
		 super();
		 try {
			
			stat = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + "(LicenseNumber varchar(6) PRIMARY KEY, trn INTEGER, model varchar(30), driver varchar(30), status varchar(20),year INTEGER )";
			if(stat.execute(sql))
				System.out.println("Table created  for the first time."); 
=======
	private static final String Table_Name = "cab_table";//lowercase



	

	 public CabDatabase() {

		// TODO Auto-generated constructor stub

		 super();

		 try {

			

			stat = con.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + "(LicenseNumber varchar(6) PRIMARY KEY, trn INTEGER, model varchar(30), driver varchar(30), status varchar(20),year INTEGER )";

			if(stat.execute(sql))

				System.out.println("Table created  for the first time."); 

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		}catch(SQLException e) {

			e.printStackTrace();

		}

		

		

	}



	@Override

	public List<Cab> selectAll() {
<<<<<<< HEAD
		List<Cab> cabList = new ArrayList<Cab>();
=======

		List<Cab> cabList = new ArrayList<Cab>();

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

				Cab item = new Cab();

				item.setLicenseNumber(rs.getString(1));

				item.setTrn(rs.getInt(2));

				item.setModel(rs.getString(3));

				item.setDriver(rs.getString(4));

				item.setSatus(rs.getString(5));

				item.setYear(rs.getInt(6));
<<<<<<< HEAD
				cabList.add(item);
=======

				cabList.add(item);

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
			}

		}catch(SQLException e) {

			e.printStackTrace();

		}
<<<<<<< HEAD
		return cabList;
	}

	
	public Cab show(String licenseNumber) {
		String search = "SELECT trn, model,driver,status,year FROM " + Table_Name + "WHERE licenseNumber = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(search); 
			preparedStatement.setString(1, licenseNumber);
			rs = preparedStatement.executeQuery();
			if(rs.next()) 
			{
				Cab cab = new Cab(); 
				cab.setLicenseNumber(licenseNumber);
				cab.setTrn(rs.getInt(1));
				cab.setModel(rs.getString(2));
				cab.setDriver(rs.getString(3));
				cab.setSatus(rs.getString(4));
				cab.setYear(rs.getInt(5));
				return cab;
			}
			
=======

		return cabList;

	}



	

	public Cab show(String licenseNumber) {

		String search = "SELECT trn, model,driver,status,year FROM " + Table_Name + "WHERE licenseNumber = ?";

		try {

			PreparedStatement preparedStatement = con.prepareStatement(search); 

			preparedStatement.setString(1, licenseNumber);

			rs = preparedStatement.executeQuery();

			if(rs.next()) 

			{

				Cab cab = new Cab(); 

				cab.setLicenseNumber(licenseNumber);

				cab.setTrn(rs.getInt(1));

				cab.setModel(rs.getString(2));

				cab.setDriver(rs.getString(3));

				cab.setSatus(rs.getString(4));

				cab.setYear(rs.getInt(5));

				return cab;

			}

			

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;

	}


<<<<<<< HEAD
	public int update(Cab Fields, String licenseNumber) {
		String update = "UPDATE "  + Table_Name +  " SET licenseNumber = ?,"
				+ " SET trn = ?, SET model = ?, SET status = ?, SET year = ?, SET driver = ? WHERE licenseNumber = ?";
		int affectedRows = 0; 
		try{
			PreparedStatement preparedStatement = con.prepareStatement(update); 
			preparedStatement.setString(1, Fields.getLicenseNumber());
			preparedStatement.setInt(2, Fields.getTrn());
			preparedStatement.setString(3, Fields.getModel()); 
			preparedStatement.setString(4, Fields.getSatus());
			preparedStatement.setInt(5, Fields.getYear());
			preparedStatement.setString(6, Fields.getDriver());
			preparedStatement.setString(7, licenseNumber);
			affectedRows = preparedStatement.executeUpdate();
=======



	public int update(Cab Fields, String licenseNumber) {

		String update = "UPDATE "  + Table_Name +  " SET licenseNumber = ?,"

				+ " SET trn = ?, SET model = ?, SET status = ?, SET year = ?, SET driver = ? WHERE licenseNumber = ?";

		int affectedRows = 0; 

		try{

			PreparedStatement preparedStatement = con.prepareStatement(update); 

			preparedStatement.setString(1, Fields.getLicenseNumber());

			preparedStatement.setInt(2, Fields.getTrn());

			preparedStatement.setString(3, Fields.getModel()); 

			preparedStatement.setString(4, Fields.getSatus());

			preparedStatement.setInt(5, Fields.getYear());

			preparedStatement.setString(6, Fields.getDriver());

			preparedStatement.setString(7, licenseNumber);

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

	
	public int delete(String licenseNumber) {
		String sql = "DELETE FROM "+ Table_Name + "WHERE requestNumber = ?";
		int affectedRows = 0 ;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql); 
			preparedStatement.setString(1, licenseNumber);
			affectedRows = preparedStatement.executeUpdate(); 
=======

		return affectedRows;

	}



	

	public int delete(String licenseNumber) {

		String sql = "DELETE FROM "+ Table_Name + "WHERE requestNumber = ?";

		int affectedRows = 0 ;

		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql); 

			preparedStatement.setString(1, licenseNumber);

			affectedRows = preparedStatement.executeUpdate(); 

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		}catch(SQLException e) {

			e.printStackTrace();

		}catch(Exception e) {

			e.printStackTrace();
<<<<<<< HEAD
		}
		return affectedRows;
=======

		}

		return affectedRows;

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
	}



	@Override

	public int add(Cab Fields) {

		String sql = " INSERT INTO " +Table_Name+ " (licenseNumber, trn, model, driver, status, year) values (?, ?, ?, ?, ?, ?)";
<<<<<<< HEAD
		int affectedRows = 0; 
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,Fields.getLicenseNumber());
			preparedStatement.setInt(2, Fields.getTrn());
			preparedStatement.setString(3, Fields.getModel());
			preparedStatement.setString(4, Fields.getDriver());
			preparedStatement.setString(5, Fields.getSatus());;
			preparedStatement.setInt(6, Fields.getYear());
			affectedRows = preparedStatement.executeUpdate();
=======

		int affectedRows = 0; 

		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1,Fields.getLicenseNumber());

			preparedStatement.setInt(2, Fields.getTrn());

			preparedStatement.setString(3, Fields.getModel());

			preparedStatement.setString(4, Fields.getDriver());

			preparedStatement.setString(5, Fields.getSatus());;

			preparedStatement.setInt(6, Fields.getYear());

			affectedRows = preparedStatement.executeUpdate();

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
		}catch(SQLException e) {

			e.printStackTrace();

		}
<<<<<<< HEAD
		return affectedRows;	
	}
	
=======

		return affectedRows;	

	}
	

>>>>>>> 6bf8cbb00eb1ca980ce48698439d26403f43dc96
}
