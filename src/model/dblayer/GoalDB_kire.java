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
	public void setScorer(int goalID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMatchID(int goalID, int matchID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAssist(int goalID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPenalty(int goalID, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExtra(int goalID, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAuto(int goalID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTeam(int goalID, Team tm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPlayerID(int goalID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMatchID(int goalID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAssistID(int goalID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPenalty(int goalID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInExtra(int goalID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoGoal(int goalID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHalfTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTeamID(int goalID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
