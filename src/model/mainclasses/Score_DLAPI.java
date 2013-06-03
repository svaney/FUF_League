/**	
 * File:ScoreData.java
 * @author Data
 * -----------------
 * ეს კლასი აფიქსირებს ერთი კონკრეტული მატჩის ანგარიშს.
 * */

package model.mainclasses;

import java.sql.SQLException;

import model.dblayer.MatchDB;
import model.dblayer.MatchDB_DLAPI;

public class Score_DLAPI implements Score{
	
	// DataBase instance 
	private MatchDB mtBase;
		
	// სხვა private ცვლადები
	private int matchID;

	/**
	 * კონსტრუქტორი, სრულიად ახლის შექმნისას
	 * @param matchID გადაეცემა მატჩის საიდენტიფიკაციო ნომერი
	 */
	public Score_DLAPI(int matchID){
		mtBase = new MatchDB_DLAPI();
		this.matchID = matchID;
	}
	
	/**
	 * კონსტრუქტორი, რომელსაც ასევე გადაეცემა ბაზასთან კონტაქტორის ობიექტი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param mtBase ბაზასთან კონტაქტორის ობიექტი
	 */
	public Score_DLAPI(int matchID, MatchDB mtBase){
		this.mtBase = mtBase;
		this.matchID = matchID;
	}
	
	/**
	 * აბრუნებს ამ თამაშის Score-ში არის თუ არა პენლების სერია გათვალისწინებული
	 * @return true - თუკი იყო პენლების სერია, false წინააღმდეგ შემთხვევაში
	 */
	@Override
	public boolean hasPenaltySeries() {
		try {
			return mtBase.hasPenalties(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * აბრუნებს პენლების სერიას
	 * @return  Penalties კლასის ობიექტს თუკი იყო პენლები, თუ არადა null
	 */
	@Override
	public Penalties getPenaltiesForTeam() {
		try {
			if(mtBase.hasPenalties(matchID))
				return new Penalties_DLAPI(matchID,mtBase);
			else 
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ითვლის რამდენი გოლი გაიტანა გუნდმა (მხოლოდ ძირითად დროში)
	 * @param teamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა ძირითად დროში
	 */
	@Override
	public int getScoreForTeam(int teamID) {
		try {
			return mtBase.getScoreForTeamForFullTime(matchID,teamID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * გვეუბნება მე-n გოლი რომელი იყო ამ თამაშში, არ აქვს მნიშვნელობა, რომელმა გუნდმა გაიტანა
	 * @param Nth - n მერამდენე გოლი გვინდა
	 * @return Goal ტიპის ცვლადი.
	 */
	@Override
	public Goal getNthGoal(int Nth) {
		try {
			return new Goal_kire(mtBase.getGoalNthInRow(matchID,Nth));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * გვეუბნება გუნდმა რამდენი გოლი გაიტანა დამატებით დროში. თუკი ასეთი დრო არსებობდა.
	 * @param TeamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა დამატებით დროში.
	 */
	@Override
	public int getExtraTimeGoalForTeam(int teamID) {
		try {
			return mtBase.getExtraTimeGoalForTeam(teamID,matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * პირველი ტაიმში გუნდის მიერ გატანილი გოლების რაოდენობა
	 * @param teamID გუნდის მაიდენტიფიცირებელი ID
	 * @return int ტიპის მნიშვნელობა - გატანილი გოლების რაოდენობა
	 */
	@Override
	public int getScoreForTeamFirstHalf(int teamID) {
		try {
			return mtBase.getScoreForTeamFirstHalf(teamID,matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
