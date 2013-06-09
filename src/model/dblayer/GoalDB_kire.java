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
	 * @throws SQLException 
	 */
	@Override
	public void createGoal(int playerID, int teamID, int matchID, boolean isAuto) throws SQLException {
		startUpStatement();
		char auto;
		if(isAuto) auto = 'Y';
			auto = 'N';
		st.executeUpdate("insert into goals(player_id,team_id,auto_goal,match_id) values("+playerID+","+teamID+","+auto+","+matchID+")");
		st.close();
	}
}
