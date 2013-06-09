/**
 * File: GoalDB_DLAPI.java
 * type: class
 * @author kire
 * -------------------------
 * GoalDB ინტერფეისის იმპლემენტაცია
 */

package model.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.mainclasses.Team;

public class GoalDB_kire implements GoalDB {
	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	private ResultSet rs;
	private Connection con;
	private Statement st;


	/**
	 * კონსტრუქტორი, რომელშიც ხდება ბაზასთან კონექშენის დამყარება.
	 */
	public GoalDB_kire(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"
					+ MYSQL_DATABASE_SERVER, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * სტარტავს statement ცვლადს და ეუბნება რომელი ბაზა გამოიყენოს
	 * @throws SQLException 
	 */
	private void startUpStatement() throws SQLException{
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
	}


	/**
	 * ამატებს გოლს
	 * @param playerID დამრტყმელის იდენტიფიკატორი
	 * @param teamID  გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param isAuto საკუთარ კარში გავიდა თუ არა გოლი
	 * @author gkire
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public int createGoal(int playerID, int teamID, int matchID, boolean isAuto) throws SQLException {
		startUpStatement();
		char auto;
		if(isAuto) auto = 'Y';
		auto = 'N';
		st.executeUpdate("insert into goals(player_id,team_id,auto_goal,match_id) values("+playerID+","+teamID+","+auto+","+matchID+")");
		st.close();
		startUpStatement();
		rs = st.executeQuery("select max(*) as total from goals");
		rs.next();
		int res = rs.getInt("total");
		st.close();
		return res;
	}

	@Override
	public void setScorer(int goalID, int playerID) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set player_id = "+playerID+" where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setMatchID(int goalID, int matchID) throws SQLException {
		startUpStatement();
		st.executeQuery("update goals set match_id = "+matchID+" where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setAssist(int goalID, int playerID) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set assistant_id = "+playerID+" where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setPenalty(int goalID, char c) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set penalty = '"+c+"' where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setExtra(int goalID, char c) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set extra_time = '"+c+"' where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setAuto(int goalID, char c) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set auto_goal = '"+c+"' where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public void setTeam(int goalID, int tmID) throws SQLException {
		startUpStatement();
		st.executeUpdate("update goals set team_id ="+tmID+" where goal_id="+goalID+";");
		st.close();
	}

	@Override
	public int getPlayerID(int goalID) throws SQLException {
		startUpStatement();
		
		st.close();
		return 0;
	}

	@Override
	public int getMatchID(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return 0;
	}

	@Override
	public int getAssistID(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return 0;
	}

	@Override
	public boolean isPenalty(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return false;
	}

	@Override
	public boolean isInExtra(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return false;
	}

	@Override
	public boolean isAutoGoal(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return false;
	}

	@Override
	public int getHalfTime() throws SQLException {
		startUpStatement();

		st.close();
		return 0;
	}

	@Override
	public int getInRow() throws SQLException {
		startUpStatement();

		st.close();
		return 0;
	}

	@Override
	public int getTeamID(int goalID) throws SQLException {
		startUpStatement();

		st.close();
		return 0;
	}
}
