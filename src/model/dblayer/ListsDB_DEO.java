package model.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	/**
	 * 
	 * @author DEO.Gochava
	 *
	 */

public class ListsDB_DEO implements ListsDB{
	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	
	// ცხრილების პარამეტრები
	private static final String TEAMS = "teams";
	private static final String TEAM_ID = "team_id";
	private static final String TEAM_NAME = "name";

	private static Connection con;
	private static Statement stmt;
	
	public ListsDB_DEO(){
		initConncection();
	}

	private void initConncection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("შეცვალე MySQL კონსტანტები შენი კონსტანტებით! (ან შეამოწმე გაშვებულია თუ არა სერვერი).");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("დაამატე MySQL jar ფაილი კონსტრუქტორის მისამართში!");
		}
	}

	@Override
	public String[][] listAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] listAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] listAllPositions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] listAllTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს მოთხოვნილი ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[][] getTeams() {
		String col = "team_id, name";
		String[][] teams = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getTeams()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+TEAMS+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getTeams(); error: "+sql);
			return null;
		}
		try {
			if(result.next()) {
				teams = (normalized(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}
	
	private String[][] normalized(ResultSet result){
		return null;
	}

}
