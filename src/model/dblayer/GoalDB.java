/**
 * File: GoalDB.java
 * type: interface
 * @author kire
 * -------------------------
 * გოლთან დაკავშირებული ყველა statement
 */
package model.dblayer;

import java.sql.SQLException;

public interface GoalDB {
	/**
	 * ამატებს გოლს
	 * @param playerID დამრტყმელის იდენტიფიკატორი
	 * @param teamID  გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param isAuto საკუთარ კარში გავიდა თუ არა გოლი
	 * @author gkire
	 * @throws SQLException 
	 */
	void createGoal(int playerID, int teamID, int matchID, boolean isAuto) throws SQLException;
}
