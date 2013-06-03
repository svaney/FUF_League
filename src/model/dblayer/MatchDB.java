/**
 * File: MatchDB.java
 * type: interface
 * @author Data
 * -------------------------
 * ცხრილები: Matches, Penalties, Yellows, Reds, Goals, captains, 
 * 			Match_captains
 * ეს interface იქნება იმ კლასისათვის, რომელიც ამოიღებს ბაზიდან ინფორმაციას მატჩის შესახებ.
 * ინფორმაცია იქნება ყველაფერი რაც ზემოთ ცხრილშია ჩამოთვლილი. ასევე ინფორმაციებს რომელიც
 * დამჭირდება სხვა ცხრილებიდან, სხვა მსგავსი დბ კლასიდან გამოვიძახებ, მაალითად ფლეიერდბ-დან
 * კაპიტნის სახელს.
 */

package model.dblayer;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.mainclasses.Goal;
import model.mainclasses.PenaltyShoot;

public interface MatchDB {

	/**
	 * გვეუბნება რომელი ტურია ჩემპიონატის
	 * @param matchID გუნდის იდენტიფიკატორი
	 * @return String ტიპის პარამეტრი - რაუნდი, ეტაპი
	 * @throws SQLException 
	 */
	String getStageOfMatch(int matchID) throws SQLException;

	/**
	 * გვეუბნება მატჩს რამდენი ჰქონდა დამატებით დრო (თუ არ ჰქონდა მაშინ 0)
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return წთ-ებში გამოსახული დრო
	 * @throws SQLException 
	 */
	int getExtraTime(int matchID) throws SQLException;

	/**
	 * აბრუნებს მატჩის ჩატარების თარიღს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return java.sql.Date ტიპის თარიღი
	 * @throws SQLException 
	 */
	Date getMatchDate(int matchID) throws SQLException;

	/**
	 * აბრუნებს კონკრეტულ მატჩზე, კონკრეტული გუნდის განაცხადს, List-ის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც ყრია Integer ტიპის მაიდენტიფიცირებელი კოდები თითოეული მოთამაშისთვის
	 * @throws SQLException 
	 */
	List<Integer> getMatchPlayersForTeam(int matchID, int teamID) throws SQLException;

	/**
	 * აბრუნებს მატჩის მონაწილე ორი გუნდის ID-ებს მასივის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის ორელემენტიანი მასივი, რომელშიც მოცემულია მატჩის მონაწილე გუნდების ID-ები
	 * @throws SQLException 
	 */
	int[] getMatchTeams(int matchID) throws SQLException;

	/**
	 * აბრუნებს მოცემულ მატჩზე მოცემული გუნდის კაპიტანს, თუ ასეთი არ არსებობს აბრუნებს -1_ს (ანუ default კაპიტანი ჰყავდათ)
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return აბრუნებს int ტიპის ცვლადს, თუ გუნდის კაპიტანი არ იყო default ანუ null არ იყო მაშინ აბრუნებს ID-ს 
	 * წინააღმდეგ შემთხვევაში აბრუნებს -1_ს
	 * @throws SQLException 
	 */
	int getCapForMatchTeam(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს მოცემული მატჩის შესახებ ინფორმაციას - რომელ ჩემპიონატზე ჩატარდა
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის იდენტიფიკატორი
	 * @throws SQLException 
	 */
	int getChampionshipID(int matchID) throws SQLException;

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს ყვითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 * @throws SQLException 
	 */
	List<Integer> getYellowsForTeamInMatch(int matchID, int teamID) throws SQLException;

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს წითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 * @throws SQLException 
	 */
	List<Integer> getRedsForTeamInMatch(int matchID, int teamID) throws SQLException;

	/**
	 * აბრუნებს მატჩზე დაწერილ რევიუს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return სტრინგ ტიპის ობიექტი სადაც წერია ტექსტი.
	 * @throws SQLException 
	 */
	String getReview(int matchID) throws SQLException;

	/**
	 * აბრუნებს იყო თუ არა პენლების სერია
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return true თუ იყო, false თუ არ იყო
	 * @throws SQLException 
	 */
	boolean hasPenalties(int matchID) throws SQLException;

	/**
	 * აბრუნებს კონკრეტულ მატჩზე გუნდის გატანილ გოლებს ძირითად დროში
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @return რაოდენობა ძირითად დროში გატანილი გოლების
	 * @throws SQLException 
	 */
	int getScoreForTeamForFullTime(int matchID, int teamID) throws SQLException;

	/**
	 * აბრუნებს იმ გოლის იდენტიფიკატორს, რომელიც გავიგე მე-N მატჩის განმავლობაში
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param nth მერამდენე
	 * @return გოლის იდენტიფიკატორი
	 * @throws SQLException 
	 */
	int getGoalNthInRow(int matchID, int Nth) throws SQLException;

	/**
	 * აბრუნებს ამ გუნდის მიერ გატანილი გოლების რაოდენობას დამატებით დროში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return გოლების რაოდენობა
	 * @throws SQLException 
	 */
	int getExtraTimeGoalForTeam(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს გუნდის მიერ მატჩში - პირველ ტაიმში გატანილ გოლების რაოდენობას
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return გოლების რაოდენობა
	 * @throws SQLException 
	 */
	int getScoreForTeamFirstHalf(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს გუნდის მიერ პენლების სერიის შედეგს
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return List სადაც წერია PenaltyShoot ტიპის ობიექტები.
	 * @throws SQLException 
	 */
	List<PenaltyShoot> getTeamPenalties(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს რამდენი გაიტანა გუნდმა პენლების სერიაში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return რაოდენობა
	 * @throws SQLException 
	 */
	int getTeamsScoresInPenalties(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს რამდენი ვერ გაიტანა გუნდმა პენლების სერიაში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return რაოდენობა
	 * @throws SQLException 
	 */
	int getTeamsMissedInPenalties(int teamID, int matchID) throws SQLException;

	/**
	 * აბრუნებს ჩემპიონატის რაუნდების სიას
	 * @return List რომელშიც შევსებულია Integer ობიექტებით.
	 */
	List<Integer> getStageIDList();

	/**
	 * ქმნის მატჩს მოცემული პარამეტრებით
	 * @param team1_ID პირველი გუნდის იდენტიფიკატორი
	 * @param team2_ID მეორე გუნდის იდენტიფიკატორი
	 * @param championship_ID ჩემპიონატის ID
	 * @param stage_ID რაუნდის ID
	 * @return matchID მატჩის იდენტიფიკატორი
	 */
	int setMatch(int team1_ID, int team2_ID, int championship_ID, int stage_ID);

	/**
	 * ამატებს, ან ცვლის მატჩის რაუნდს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param stageID რაუნდის იდენტიფიკატორი
	 */
	void setMatchStage(int matchID, int stageID);

	/**
	 * წერს ჰქონდა თუ არა დამატებითი დრო
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param extra true თუ ჰქონდა, false წინააღმდეგ შემთხვევაში
	 */
	void setExtraTimeForMatch(int matchID, boolean extra);

	/**
	 * წერს თარიღს როდესაც ჩატარდა მატჩი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param date თარიღი sql.date ტიპის
	 */
	void setDateForMatch(int matchID, Date date);

	/**
	 * ამატებს მატჩის განაცხადში მოთამაშეს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	void setLineUpPlayer(int matchID, int teamID, int playerID);

	/**
	 * ამატებს ან ცვლის მატჩის მოთამაშე გუნდებს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param team1id გუნდის იდენტიფიკატორი
	 * @param team2id გუნდის იდენტიფიკატორი
	 */
	void setTeamsInMatch(int matchID, int team1id, int team2id);

	/**
	 * წერს გუნდის კაპიტანს მოცემული მატჩისთვის
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	void setCaptainForMatch(int matchID, int teamID, int playerID);

	/**
	 * წერს ფეხბურთელს რომელმაც მატჩზე მიიღო ყვითელი ბარათი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	void setYellowForPlayerInMatch(int matchID, int teamID, int playerID);

	/**
	 * წერს ფეხბურთელს რომელმაც მატჩზე მიიღო ყვითელი ბარათი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	void setRedForPlayerInMatch(int matchID, int teamID, int playerID);

	/**
	 * წერს მატჩის შესახებ სტატიას
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param review მიმოხილვა ტექსტის სახით
	 */
	void setMatchReview(int matchID, String review);

	/**
	 * წერს ჩემპიონატის ID-ს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param championship_ID ჩემპიონატის იდენტიფიკატორი
	 */
	void setChampionship(int matchID, int championship_ID);
	
}
