/**
 * File: MatchData.java
 * type: class
 * @author Data
 * -------------------------
 * ეს კლასი აღწერს ერთ კონკრეტულ მატჩს.
 */

package model.mainclasses;

import java.util.List;

public class Match_DLAPI implements Match{

	/**
	 * გვიბრუნებს თუ რომელი რაუნდის მატჩია
	 * @return String ტიპის მნიშვნელობა, მაგალითად Final, semi-final და ა.შ.
	 */
	@Override
	public String getMatchRound() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * გვეუბნება ჰქონდა თუ არა მატჩს დამატებითი დრო
	 * @return true თუკი ჰქონდა, false თუკი არ ჰქონია
	 */
	@Override
	public boolean hasExtraTime() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * გვიბრუნებს მატჩის ანგარიშს
	 * @return Score ტიპის ობიექტი
	 */
	@Override
	public Score getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * გვეუბნება როდის ჩატარდა მატჩი
	 * @return String ტიპის მნიშვნელობით გადმოგვცემს თარიღს
	 */
	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * გვიბრუნებს კონკრეტული გუნდის განაცხადს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return გვიბრუნებს List ტიპის ობიექტს, რომელშიც წარმოდგენელია ფეხბურთელების განაცხადი
	 */
	@Override
	public List<Player> getLineUp(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდების მაიდენტიფიცირებელ ID-ებს
	 * @return int-ების მასივი (რომელშიც უნდა იყოს 2 ელემენტი) სადაც წერია ორი გუნდის ID
	 */
	@Override
	public int[] getTeamIDs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * გვიბრუნებს მატჩში მონაწილე გუნდის კაპიტანს
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return Player ტიპის მნიშვნელობა
	 */
	@Override
	public Player getCaptainForTeam(int teamID) {
		// TODO Auto-generated method stub
		return null;
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
	
}
