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

import java.util.ArrayList;
import java.util.List;

public interface MatchDB {

	/**
	 * გვეუბნება რომელი ტურია ჩემპიონატის
	 * @param matchID გუნდის იდენტიფიკატორი
	 * @return String ტიპის პარამეტრი - რაუნდი, ეტაპი
	 */
	public String getStageOfMatch(int matchID);

	/**
	 * გვეუბნება მატჩს რამდენი ჰქონდა დამატებით დრო (თუ არ ჰქონდა მაშინ 0)
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return წთ-ებში გამოსახული დრო
	 */
	public int getExtraTime(int matchID);

	/**
	 * აბრუნებს მატჩის ჩატარების თარიღს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return String ტიპის თარიღი
	 */
	public String getMatchDate(int matchID);

	/**
	 * აბრუნებს კონკრეტულ მატჩზე, კონკრეტული გუნდის განაცხადს, List-ის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც ყრია Integer ტიპის მაიდენტიფიცირებელი კოდები თითოეული მოთამაშისთვის
	 */
	public List<Integer> getMatchPlayersForTeam(int matchID, int teamID);

	/**
	 * აბრუნებს მატჩის მონაწილე ორი გუნდის ID-ებს მასივის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის ორელემენტიანი მასივი, რომელშიც მოცემულია მატჩის მონაწილე გუნდების ID-ები
	 */
	public int[] getMatchTeams(int matchID);

	/**
	 * აბრუნებს მოცემულ მატჩზე მოცემული გუნდის კაპიტანს, თუ ასეთი არ არსებობს აბრუნებს -1_ს (ანუ default კაპიტანი ჰყავდათ)
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return აბრუნებს int ტიპის ცვლადს, თუ გუნდის კაპიტანი არ იყო default ანუ null არ იყო მაშინ აბრუნებს ID-ს 
	 * წინააღმდეგ შემთხვევაში აბრუნებს -1_ს
	 */
	public int getCapForMatchTeam(int teamID, int matchID);

	/**
	 * აბრუნებს მოცემული მატჩის შესახებ ინფორმაციას - რომელ ჩემპიონატზე ჩატარდა
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის იდენტიფიკატორი
	 */
	public int getChampionshipID(int matchID);

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს ყვითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 */
	public List<Integer> getYellowsForTeamInMatch(int matchID, int teamID);

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს წითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 */
	public List<Integer> getRedsForTeamInMatch(int matchID, int teamID);

	/**
	 * აბრუნებს მატჩზე დაწერილ რევიუს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return სტრინგ ტიპის ობიექტი სადაც წერია ტექსტი.
	 */
	public String getReview(int matchID);


	
	
	
	
}
