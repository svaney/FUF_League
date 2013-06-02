/**
 * File: MatchData.java
 * type: class
 * @author Data
 * -------------------------
 * ეს კლასი აღწერს ერთ კონკრეტულ მატჩს.
 */

package model.mainclasses;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dblayer.MatchDB;
import model.dblayer.MatchDB_DLAPI;

public class Match_DLAPI implements Match{

	// DataBase instance 
	private MatchDB mtBase;
	
	// სხვა private ცვლადები
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
		try {
			return mtBase.getStageOfMatch(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * გვეუბნება ჰქონდა თუ არა მატჩს დამატებითი დრო
	 * @return true თუკი ჰქონდა, false თუკი არ ჰქონია
	 */
	@Override
	public boolean hasExtraTime() {
		try {
			return (mtBase.getExtraTime(matchID) > 0);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * გვიბრუნებს მატჩის ანგარიშს
	 * @return Score ტიპის ობიექტი
	 */
	@Override
	public Score getScore() {
		Score matchScore = new Score_DLAPI(matchID,mtBase);
		return matchScore;
	}

	/**
	 * გვეუბნება როდის ჩატარდა მატჩი
	 * @return sql.date ტიპის მნიშვნელობით გადმოგვცემს თარიღს
	 */
	@Override
	public Date getDate() {
		Date date = null;
		try {
			date = mtBase.getMatchDate(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * გვიბრუნებს კონკრეტული გუნდის განაცხადს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return გვიბრუნებს List ტიპის ობიექტს, რომელშიც წარმოდგენელია ფეხბურთელების განაცხადი Player_DEO ობიექტების სახით
	 */
	@Override
	public List<Player> getLineUp(int teamID) {
		ArrayList<Integer> players = null;
		try {
			players = (ArrayList<Integer>) mtBase.getMatchPlayersForTeam(matchID,teamID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return setPlayersFromIDs(players);
	}

	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდების მაიდენტიფიცირებელ ID-ებს
	 * @return int-ების მასივი (რომელშიც უნდა იყოს 2 ელემენტი) სადაც წერია ორი გუნდის ID
	 */
	@Override
	public int[] getTeamIDs() {
		try {
			return mtBase.getMatchTeams(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდის კაპიტანს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return Player ტიპის მნიშვნელობა
	 */
	@Override
	public Player getCaptainForTeam(int teamID) {
		int captainID = -1;
		try {
			captainID = mtBase.getCapForMatchTeam(teamID,matchID);
		} catch (SQLException e) {
			System.out.println("ერორია sql-ში, დააბრუნებს ახალ პლეიერს. captainID=-1");
			e.printStackTrace();
		}
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
		try {
			return mtBase.getChampionshipID(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * აბრუნებს გუნდის მიერ მიღებული ყვითლების List-ს, სადაც ხალხი წერია, ვინც ყვითლები მიიღო
	 * @param taemID გუნდის ID ვისი ყვითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	@Override
	public List<Player> getTeamYellows(int teamID) {
		ArrayList<Integer> playerIDs;
		try {
			playerIDs = (ArrayList<Integer>) mtBase.getYellowsForTeamInMatch(matchID,teamID);
		} catch (SQLException e) {
			e.printStackTrace();
			playerIDs=null;
		}
		return setPlayersFromIDs(playerIDs);
	}
	
	/**
	 * გადაცემული ID-ებიდან, ქმნის Player ობიექტების ArrayList-ს 
	 * @param players ArrayList<Integer> ID-ების ჩამონათვალი
	 * @return აბრუნებს ArrayList<Player> ობიექტს
	 */
	private ArrayList<Player> setPlayersFromIDs(ArrayList<Integer> players){
		ArrayList<Player> result = new ArrayList<Player>();
		for(int i=0;i<players.size();i++){
			result.add(new Player_DEO(players.get(i)));
		}
		return result;
	}
	
	
	/**
	 * აბრუნებს გუნდის მიერ მიღებული წითლების List-ს, სადაც ხალხი წერია, ვინც წითლები მიიღო
	 * @param taemID გუნდის ID ვისი წითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	@Override
	public List<Player> getTeamReds(int teamID) {
		ArrayList<Integer> playerIDs;
		try {
			playerIDs = (ArrayList<Integer>) mtBase.getRedsForTeamInMatch(matchID,teamID);
		} catch (SQLException e) {
			e.printStackTrace();
			playerIDs=null;
		}
		return setPlayersFromIDs(playerIDs);
	}

	/**
	 * აბრუნებს მატჩის რევიუს
	 * @return String ტიპის ცვლადი
	 */
	@Override
	public String getMatchReview() {
		try {
			return mtBase.getReview(matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}
