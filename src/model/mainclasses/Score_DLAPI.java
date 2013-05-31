/**	
 * File:ScoreData.java
 * @author Data
 * -----------------
 * ეს კლასი აფიქსირებს ერთი კონკრეტული მატჩის ანგარიშს.
 * */

package model.mainclasses;

import model.dblayer.MatchDB;
import model.dblayer.MatchDB_DLAPI;

public class Score_DLAPI implements Score{
	
	// DataBase instance 
	private MatchDB mtBase;
		
	// სხვა private ცვლადები
	private int matchID;

	/**
	 * კონსტრუქტორი
	 * @param matchID გადაეცემა მატჩის საიდენტიფიკაციო ნომერი
	 */
	public Score_DLAPI(int matchID){
		mtBase = new MatchDB_DLAPI();
		this.matchID = matchID;
	}
	
	/**
	 * კონსტრუქტორი, რომელსაც ასევე გადაეცემა ბაზასთან კონტაქტორის ობიექტი
	 * @param matchID მატცის იდენტიფიკატორი
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
		char ans = mtBase.hasPenalties(matchID);
		if(ans == 'Y')
			return true;
		else
			return false;
	}

	/**
	 * აბრუნებს პენლების სერიას
	 * @return  Penalties კლასის ობიექტს თუკი იყო პენლები, თუ არადა null
	 */
	@Override
	public Penalties getPenaltiesForTeam() {
		if(mtBase.wasPenaltiesSerie(matchID))
			return new Penalties_DLAPI(matchID,mtBase);
		else 
			return null;
	}

	/**
	 * ითვლის რამდენი გოლი გაიტანა გუნდმა (მხოლოდ ძირითად დროში)
	 * @param teamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა ძირითად დროში
	 */
	@Override
	public int getScoreForTeam(int teamID) {
		return mtBase.getScoreForTeamForFullTime(matchID,teamID);
	}

	/**
	 * გვეუბნება მე-n გოლი რომელი იყო ამ თამაშში, არ აქვს მნიშვნელობა, რომელმა გუნდმა გაიტანა
	 * @param Nth - n მერამდენე გოლი გვინდა
	 * @return Goal ტიპის ცვლადი.
	 */
	@Override
	public Goal getNthGoal(int Nth) {
		return new Goal_kire(mtBase.getGoalNthInRow(matchID,Nth));
	}

	/**
	 * გვეუბნება გუნდმა რამდენი გოლი გაიტანა დამატებით დროში. თუკი ასეთი დრო არსებობდა.
	 * @param TeamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა დამატებით დროში.
	 */
	@Override
	public int getExtraTimeGoalForTeam(int teamID) {
		return mtBase.getExtraTimeGoalForTeam(teamID,matchID);
	}

	/**
	 * პირველი ტაიმში გუნდის მიერ გატანილი გოლების რაოდენობა
	 * @param teamID გუნდის მაიდენტიფიცირებელი ID
	 * @return int ტიპის მნიშვნელობა - გატანილი გოლების რაოდენობა
	 */
	@Override
	public int getScoreForTeamFirstHalf(int teamID) {
		return mtBase.getScoreForTeamFirstHalf(teamID,matchID);
	}
	
}
