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

	void setScorer(int goalID, int playerID);

	void setMatchID(int goalID, int matchID);

	void setAssist(int goalID, int playerID);

	void setPenalty(int goalID, char c);

	void setExtra(int goalID, char c);

	void setAuto(int goalID);

	void setTeam(int goalID, Team tm);

	int getPlayerID(int goalID);

	int getMatchID(int goalID);

	int getAssistID(int goalID);

	boolean isPenalty(int goalID);

	boolean isInExtra(int goalID);

	boolean isAutoGoal(int goalID);

	int getHalfTime();

	int getInRow();

	int getTeamID(int goalID);
}
