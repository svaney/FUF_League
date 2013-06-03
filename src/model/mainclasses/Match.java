/**
 * File: MatchInterface.java
 * type: Interface
 * @author Data
 * -------------------------
 * ეს კლასი აღწერს ერთი კონკრეტული მატჩის ინტერფეისს.
 */
package model.mainclasses;

import java.sql.Date;
import java.util.List;

public interface Match {

	/**
	 * აბრუნებს მატჩის იდენტიფიკატორს
	 * @return int ტიპის იდენტიფიკატორი
	 */
	int getMatchID();
	
	/**
	 * გვიბრუნებს თუ რომელი რაუნდის მატჩია
	 * @return String ტიპის მნიშვნელობა, მაგალითად Final, semi-final და ა.შ.
	 */
	String getMatchRound();

	/**
	 * გვეუბნება ჰქონდა თუ არა მატჩს დამატებითი დრო
	 * @return true თუკი ჰქონდა, false თუკი არ ჰქონია
	 */
	boolean hasExtraTime();

	/**
	 * გვიბრუნებს მატჩის ანგარიშს
	 * @return Score ტიპის ობიექტი
	 */
	Score getScore();

	/**
	 * გვეუბნება როდის ჩატარდა მატჩი
	 * @return sql.date ტიპის მნიშვნელობით გადმოგვცემს თარიღს
	 */
	Date getDate();

	/**
	 * გვიბრუნებს კონკრეტული გუნდის განაცხადს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return გვიბრუნებს List ტიპის ობიექტს, რომელშიც წარმოდგენელია ფეხბურთელების განაცხადი Player ობიექტების სახით
	 */
	List<Player> getLineUp(int teamID);

	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდების მაიდენტიფიცირებელ ID-ებს
	 * @return int-ების მასივი (რომელშიც უნდა იყოს 2 ელემენტი) სადაც წერია ორი გუნდის ID
	 */
	int[] getTeamIDs();

	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდის კაპიტანს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return Player ტიპის მნიშვნელობა
	 */
	Player getCaptainForTeam(int teamID);

	/**
	 * აბრუნებს გუნდის მიერ მიღებული ყვითლების List-ს, სადაც ხალხი წერია, ვინც ყვითლები მიიღო
	 * @param taemID გუნდის ID ვისი ყვითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	List<Player> getTeamYellows(int teamID);

	/**
	 * აბრუნებს გუნდის მიერ მიღებული წითლების List-ს, სადაც ხალხი წერია, ვინც წითლები მიიღო
	 * @param taemID გუნდის ID ვისი წითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	List<Player> getTeamReds(int teamID);

	/**
	 * აბრუნებს მატჩის რევიუს
	 * @return String ტიპის ცვლადი
	 */
	String getMatchReview();

	/**
	 * აბრუნებს ჩემპიონატის ID-ს
	 * @return int ტიპის ID
	 */
	int getChampionship();

	//-----------------------------------------------------------------------------------------------------
	// set-ერები
	//-----------------------------------------------------------------------------------------------------

	/**
	 * ცვლის მატჩის რაუნდს
	 * @param stage რაუნდის იდენტიფიკატორი
	 */
	void setMatchStageID(String stage);
	
	/**
	 * უთითებს რომ მატჩს ჰქონდა დამატებითი დრო
	 * @param extra true - თუ ჰქონდა, false თუ არ ჰქონდა
	 */
	void setExtraTime(boolean extra);

	/**
	 * აფიქსირებს მატჩის ჩატარების თარიღს
	 * @param date sql.Date ტიპის ობიექტი
	 */
	void setDate(Date date);

	/**
	 * მოთამაშეს ამატებს კონკრეტული გუნდის განაცხადში განაცხადში
	 * @param player მოთამაშე Player ტიპის ობიექტი
	 * @param teamID int გუნდის იდენტიფიკატორი
	 */
	void setInLineUp(Player player, int teamID);

	/**
	 * უთითებს მატჩის ორ მოთამაშე გუნდს
	 * @param team1ID მასპინძელი გუნდის იდენტიფიკატორი
	 * @param team2ID სტუმარი გუნდის იდენტიფიკატორი
	 */
	void setTeamIDsInMatch(int team1ID, int team2ID);

	/**
	 * კონკრეტულ მატჩზე ნიშნავს რომელიმე გუნდში კაპიტანს
	 * @param teamID გუნდის იდენტიფიკატორი, სადაც ინიშნება კაპიტანი
	 * @param player კაპიტანი
	 */
	void setCaptainForMatch(int teamID, Player player);

	/**
	 * უთითებს რომ ამ მოთამაშემ ამ გუნდში მიიღო ყვითელი ბარათი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param player მოთამაშის იდენტიფიკატორი
	 */
	void setYellowForPlayer(int teamID, Player player);

	/**
	 * უთითებს რომ ამ მოთამაშემ ამ გუნდში მიიღო წითელი ბარათი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param player მოთამაშის იდენტიფიკატორი
	 */
	void setRedForPlayer(int teamID, Player player);

	/**
	 * ანახლებს მატჩის მიმოხილვას
	 * @param review String ტიპის ობიექტი
	 */
	void setMatchReview(String review);

	/**
	 * ამატებს, ცვლის ჩემპიონატის იდენტიფიკატორს
	 * @param championship_ID int ტიპის იდენტიფიკატორი
	 */
	void setChampionship(int championship_ID);

}
