package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Cab;


public class CabDatabase extends SQLDatabase<Cab> {
	private static final String  Table_Name = "cab_table";
	 public CabDatabase() {
		// TODO Auto-generated constructor stub
		 super();
		 try {
			stat = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS " +Table_Name + 
					" (LicenseNumber varchar(6) PRIMARY KEY, trn INTEGER,"
					+ " model varchar(30), driver varchar(30), status varchar(20),year INTEGER )";
			if(stat.execute(sql))
				System.out.println("Table created  for the first time."); 
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cab> selectAll() {
		List<Cab> cabList = new ArrayList<Cab>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " + Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Cab item = new Cab();
				item.setLicenseNumber(rs.getString(1));
				item.setTrn(rs.getInt(2));
				item.setModel(rs.getString(3));
				item.setDriver(rs.getString(4));
				item.setSatus(rs.getString(5));
				item.setYear(rs.getInt(6));
				cabList.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cabList;
	}
	
	public Cab show(String licenseNumber) {
		String search = "SELECT trn, model,driver,status,year FROM " + Table_Name + " WHERE licenseNumber = ?";
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public int update(Cab Fields, String licenseNumber) {//working
		String update = "UPDATE "  + Table_Name +  " set licenseNumber = ?,"
				+ "  trn = ?, model = ?, status = ?, year = ?, driver = ? where licenseNumber = ?";
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
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	
	public int delete(String licenseNumber) { //not working
		try {
			String query ="delete from +Table_Name+ where licenseNumber = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, licenseNumber);
			
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int add(Cab Fields) {
		String sql = " INSERT INTO " +Table_Name+ " (licenseNumber, trn, model, driver, status, year) values (?, ?, ?, ?, ?, ?)";
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
			return affectedRows; 
			}catch(SQLException e) { 
			e.printStackTrace();
		}
		return 0;	
	}
	
}
