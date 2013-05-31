/**
 * File: MatchData.java
 * type: class
 * @author Data
 * -------------------------
 * ეს კლასი აღწერს ერთ კონკრეტულ მატჩს.
 */

package model.mainclasses;

import java.util.ArrayList;
import java.util.List;

import model.dblayer.MatchDB;
import model.dblayer.MatchDB_DLAPI;

public class Match_DLAPI implements Match{

	// DataBase instance 
	private MatchDB mtBase;
	private int matchID;
	
	/**
	 * კონსტრუქტორი
	 * @param match_id
	 */
	public Match_DLAPI(int matchID){
		mtBase = new MatchDB_DLAPI();
		this.matchID = matchID;
	}
	
	/**
	 * გვიბრუნებს თუ რომელი რაუნდის მატჩია
	 * @return String ტიპის მნიშვნელობა, მაგალითად Final, semi-final და ა.შ.
	 */
	@Override
	public String getMatchRound() {
		return mtBase.getStageOfMatch(matchID);
	}

	/**
	 * გვეუბნება ჰქონდა თუ არა მატჩს დამატებითი დრო
	 * @return true თუკი ჰქონდა, false თუკი არ ჰქონია
	 */
	@Override
	public boolean hasExtraTime() {
		return (mtBase.getExtraTime(matchID) > 0);
	}
	
	/**
	 * გვიბრუნებს მატჩის ანგარიშს
	 * @return Score ტიპის ობიექტი
	 */
	@Override
	public Score getScore() {
		Score matchScore = new Score_DLAPI(matchID);
		return matchScore;
	}

	/**
	 * გვეუბნება როდის ჩატარდა მატჩი
	 * @return String ტიპის მნიშვნელობით გადმოგვცემს თარიღს
	 */
	@Override
	public String getDate() {
		String date = mtBase.getMatchDate(matchID);
		//TODO date - modifications
		return date;
	}

	/**
	 * გვიბრუნებს კონკრეტული გუნდის განაცხადს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return გვიბრუნებს List ტიპის ობიექტს, რომელშიც წარმოდგენელია ფეხბურთელების განაცხადი Player_DEO ობიექტების სახით
	 */
	@Override
	public List<Player> getLineUp(int teamID) {
		ArrayList<Integer> players = (ArrayList<Integer>) mtBase.getMatchPlayersForTeam(matchID,teamID);
		ArrayList<Player> result = new ArrayList<Player>();
		for(int i=0;i<players.size();i++){
			result.add(new Player_DEO(players.get(i)));
		}
		return result;
	}

	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდების მაიდენტიფიცირებელ ID-ებს
	 * @return int-ების მასივი (რომელშიც უნდა იყოს 2 ელემენტი) სადაც წერია ორი გუნდის ID
	 */
	@Override
	public int[] getTeamIDs() {
		return mtBase.getMatchTeams(matchID);
	}
	
	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდის კაპიტანს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return Player ტიპის მნიშვნელობა
	 */
	@Override
	public Player getCaptainForTeam(int teamID) {
		int captainID = mtBase.getCapForMatchTeam(teamID,matchID);
		Player result;
		if(captainID == -1){
			result = new Player_DEO(captainID);
		} else {
			Team team = new Team_Ruska(teamID);
			result = team.getCaptain(getChampionship());
		}
		return result;
	}

	/**
	 * აბრუნებს ჩემპიონატის ID-ს
	 * @return int ტიპის ID
	 */
	@Override
	public int getChampionship() {
		return mtBase.getChampionshipID(matchID);
	}

	/**
	 * აბრუნებს გუნდის მიერ მიღებული ყვითლების List-ს, სადაც ხალხი წერია, ვინც ყვითლები მიიღო
	 * @param taemID გუნდის ID ვისი ყვითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	@Override
	public List<Player> getTeamYellows(int taemID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * აბრუნებს გუნდის მიერ მიღებული წითლების List-ს, სადაც ხალხი წერია, ვინც წითლები მიიღო
	 * @param taemID გუნდის ID ვისი წითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	@Override
	public List<Player> getTeamReds(int taemID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს მატჩის რევიუს
	 * @return String ტიპის ცვლადი
	 */
	@Override
	public String getMatchReview() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
