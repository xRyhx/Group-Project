package Databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Classes.Cab;


public class CabDatabase extends SQLDatabase<Cab> {
	private static final String Table_Name = "cabs";

	@Override
	protected void InitialSQLDatabase() {
		try {
			stat = con.createStatement();
			if(stat.execute("Create Table if not exsists " +Table_Name + "(LicenseNumber varchar(6) PRIMARY KEY, trn INTEGER, model varchar(30), driver varchar(30), status varchar(20),year INTEGER )")) {
				
			}else {
				System.out.println("Table Created");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Cab> selectAll() {
		List<Cab> Class = new ArrayList<Cab>();
		try {
			stat = con.createStatement();
			String sql ="SELECT * FROM " +Table_Name;
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Cab item = new Cab();
				item.setLicenseNumber(rs.getString(1));
				item.setTrn(rs.getInt(2));
				item.setModel(rs.getString(3));
				item.setDriver(rs.getString(4));
				item.setSatus(rs.getString(5));
				item.setYear(rs.getInt(6));
				
				Class.add(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Class;
	}

	@Override
	public Cab show(int licenseNumber) {
		String search = "SELECT trn,model,driver,status,year FROM +Table_Name WHERE licenseNumber = ? ";
		try {
			rs = stat.executeQuery(search);
			if(rs.next()) {
				do {
					System.out.println(rs.getString(1)+","+rs.getInt(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getInt(6));
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
	public int update(Cab Fields, int licenseNumber) {
		String update = "UPDATE +Table_Name WHERE requestNumber = ? ";
		try {
			stat.executeQuery(update);
			
			update = "SELECT licenseNumber,trn,model,driver,status,year FROM +Table_Name";
			rs = stat.executeQuery(update);
			while(rs.next()) {
				rs.getString(licenseNumber);
				int TRN = rs.getInt(2);
				String model = rs.getString(3);
				String driver = rs.getString(4);
				String status = rs.getString(5);
				int year = rs.getInt(6);
				
				
				System.out.println("Cab LicenseNumber:" +licenseNumber);
				System.out.println("Cab TRN: " +TRN);
				System.out.println("Cab Model: " +model);
				System.out.println("Cab Driver:" +driver);
				System.out.println("Status:" +status);
				System.out.println("Year:" +year);
				
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
	public int delete(int licenseNumber) {
		String delete = "DELETE FROM +Table_Name WHERE requestNumber = ?";
		try {
			stat.executeQuery(delete);
			
			
			delete = "SELECT licenseNumber,trn,model,driver,status,year FROM +Table_Name";
			
			rs = stat.executeQuery(delete);
			while(rs.next()) {
				rs.getString(licenseNumber);
				int TRN = rs.getInt(2);
				String model = rs.getString(3);
				String driver = rs.getString(4);
				String status = rs.getString(5);
				int year = rs.getInt(6);
				
				
				System.out.println("Cab LicenseNumber:" +licenseNumber);
				System.out.println("Cab TRN: " +TRN);
				System.out.println("Cab Model: " +model);
				System.out.println("Cab Driver:" +driver);
				System.out.println("Status:" +status);
				System.out.println("Year:" +year);
				
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
		System.out.println("Record Deleted");
		return 0;
	}

	@Override
	public int add(Cab Fields) {
		String sql = " INSERT INTO " +Table_Name+ " (licenseNumber, trn, model, driver, status, year) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,Fields.getLicenseNumber());
			st.setInt(2, Fields.getTrn());
			st.setString(3, Fields.getModel());
			st.setString(4, Fields.getDriver());
			st.setString(5, Fields.getSatus());;
			st.setInt(6, Fields.getYear());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
