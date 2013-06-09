/*
 * File: TeamDB_Ruska.java
 * Author: ruska
 * -------------------------
 * გუნდზე ინფრომაციის ბაზიდან ამოღებაზე პასუხისგებელი კლასი.
 */

package model.dblayer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.mainclasses.Award;
import model.mainclasses.Player;
import model.mainclasses.Team;
import model.mainclasses.Team_Ruska;

public class TeamDB_Ruska implements TeamDB{

	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";

	private static Connection con;
	private static Statement stmt;

	public TeamDB_Ruska(){
		initConnection();
	}

	@Override
	public Team getTeam(int teamID) {

		Team result = new Team_Ruska(teamID);

		return null;
	}

	@Override
	public void createTeam(Team team) throws SQLException{
		int teamID = team.getID();
		String query = "SELECT * FROM teams WHERE team_id = " + teamID;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			team.setName(rs.getString("name"));
			team.setEmail(rs.getString("Email"));
			team.setImageURL(rs.getString("Image_URL"));
			team.setLogo(rs.getString("logo_url"));
			team.setTel(rs.getString("tel"));
			team.setRating(rs.getInt("rating"));
		}
	}

	public Team createTeamFromID(int teamID) throws SQLException{

		String query = "SELECT * FROM teams WHERE team_id = " + teamID;

		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
			System.out.println(rs.getString("name"));

		return null;

	}



	@Override
	public List<Player> getPlayers(int teamID, int champID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Award> getAwards(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Award getAwardInChampByTeam(int teamID, int ChampID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlayer(int teamID, int playerID) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player getCaptain(int teamID, int champID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeImage(int teamID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setImage(int teamID, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}