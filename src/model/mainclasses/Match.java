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
	 * გვიბრუნებს თუ რომელი რაუნდის მატჩია
	 * @return String ტიპის მნიშვნელობა, მაგალითად Final, semi-final და ა.შ.
	 */
	public String getMatchRound();
	
	/**
	 * გვეუბნება ჰქონდა თუ არა მატჩს დამატებითი დრო
	 * @return true თუკი ჰქონდა, false თუკი არ ჰქონია
	 */
	public boolean hasExtraTime();
	
	/**
	 * გვიბრუნებს მატჩის ანგარიშს
	 * @return Score ტიპის ობიექტი
	 */
	public Score getScore();
	
	/**
	 * გვეუბნება როდის ჩატარდა მატჩი
	 * @return sql.date ტიპის მნიშვნელობით გადმოგვცემს თარიღს
	 */
	public Date getDate();
	
	/**
	 * გვიბრუნებს კონკრეტული გუნდის განაცხადს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return გვიბრუნებს List ტიპის ობიექტს, რომელშიც წარმოდგენელია ფეხბურთელების განაცხადი Player ობიექტების სახით
	 */
	public List<Player> getLineUp(int teamID);
	
	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდების მაიდენტიფიცირებელ ID-ებს
	 * @return int-ების მასივი (რომელშიც უნდა იყოს 2 ელემენტი) სადაც წერია ორი გუნდის ID
	 */
	public int[] getTeamIDs();
	
	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდის კაპიტანს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return Player ტიპის მნიშვნელობა
	 */
	public Player getCaptainForTeam(int teamID);
	
	/**
	 * აბრუნებს გუნდის მიერ მიღებული ყვითლების List-ს, სადაც ხალხი წერია, ვინც ყვითლები მიიღო
	 * @param taemID გუნდის ID ვისი ყვითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	public List<Player> getTeamYellows(int teamID);
	
	/**
	 * აბრუნებს გუნდის მიერ მიღებული წითლების List-ს, სადაც ხალხი წერია, ვინც წითლები მიიღო
	 * @param taemID გუნდის ID ვისი წითლიანებიც გვაინტერესებს
	 * @return List სადაც წერია Player-ები.
	 */
	public List<Player> getTeamReds(int teamID);
	
	/**
	 * აბრუნებს მატჩის რევიუს
	 * @return String ტიპის ცვლადი
	 */
	//TODO გასარკვევია ქართულ ასოებს სტრინგი როგორ შვრება
	public String getMatchReview();
	
	/**
	 * აბრუნებს ჩემპიონატის ID-ს
	 * @return int ტიპის ID
	 */
	public int getChampionship();
	
}
