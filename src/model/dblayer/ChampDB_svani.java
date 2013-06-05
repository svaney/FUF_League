package model.dblayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChampDB_svani implements ChampDB{
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	private Connection con;

	/**
	 * კონსტრუქტორი, რომელშიც ხდება ბაზასთან კონექშენის დამყარება.
	 */
	public ChampDB_svani(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + MYSQL_DATABASE_SERVER, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int addChampionship(String type, Date startDate) throws SQLException {
		Statement st;
		ResultSet rs;
		String quer;
		int champId;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "insert into championships (start_date, championship_type) values (" + startDate + "," + type +");";
		st.executeUpdate(quer);
		quer = "select championship_ID from championships where start_date="+startDate +" and championship_type='" + type + "';";
		rs = st.executeQuery(quer);
		rs.next();
		champId = rs.getInt(1);
		st.close();

		return champId;
	}

	@Override
	public void setChampionshipType(String type, int champID) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update championships set championship_type='" + type + "' where championship_id= " + champID + ";";
		st.executeUpdate(quer);
		st.close();
		
	}

	@Override
	public void setStartDate(Date startDate, int champID) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update championships set start_date=" + startDate + " where championship_id= " + champID + ";";
		st.executeUpdate(quer);
		st.close();
		
	}

	@Override
	public void setEndDate(Date endDate, int champID) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update championships set start_date=" + endDate + " where championship_id= " + champID + ";";
		st.executeUpdate(quer);
		st.close();
		
	}
}
