/**
 * File: GoalDB.java
 * type: interface
 * @author kire
 * -------------------------
 * გოლთან დაკავშირებული ყველა statement
 */
package model.dblayer;

import java.sql.SQLException;

import model.mainclasses.Team;

public interface GoalDB {
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
	int createGoal(int playerID, int teamID, int matchID, boolean isAuto) throws SQLException;

	void setScorer(int goalID, int playerID) throws SQLException;

	void setMatchID(int goalID, int matchID) throws SQLException;

	void setAssist(int goalID, int playerID) throws SQLException;

	void setPenalty(int goalID, char c) throws SQLException;

	void setExtra(int goalID, char c) throws SQLException;

	void setAuto(int goalID, char c) throws SQLException;

	void setTeam(int goalID, int tmID) throws SQLException;

	int getPlayerID(int goalID) throws SQLException;

	int getMatchID(int goalID) throws SQLException;

	int getAssistID(int goalID) throws SQLException;

	boolean isPenalty(int goalID) throws SQLException;

	boolean isInExtra(int goalID) throws SQLException;

	boolean isAutoGoal(int goalID) throws SQLException;

	int getHalfTime() throws SQLException;

	int getInRow() throws SQLException;

	int getTeamID(int goalID) throws SQLException;
}
