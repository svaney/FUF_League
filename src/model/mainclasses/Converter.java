/**
 * File: Converter.java
 * type: class
 * @author Data
 * -------------------------
 * ამ კლასის ძირითადი მოვალეობაა დამხმარე ფუნქციების შეთავსება. 
 * მაგალითად რამდენიმე კლასში დამჭირდა, რომ ფეხბურთელების ID-ებიდან შემექნმა Player ArrayList
 * სწორედ ასეთი მეთოდების იმპლემენტაციაა საჭირო აქ.
 */
package model.mainclasses;

import java.util.ArrayList;
import java.util.List;

public class Converter {

	/**
	 * გადაცემული ID-ებიდან, ქმნის Player ობიექტების ArrayList-ს 
	 * @param players ArrayList<Integer> ID-ების ჩამონათვალი
	 * @return აბრუნებს List<Player> ობიექტს
	 */
	public static List<Player> setPlayersFromIDs(ArrayList<Integer> playerIDs){
		ArrayList<Player> result = new ArrayList<Player>();
		for(int i=0;i<playerIDs.size();i++){
			result.add(new Player_DEO(playerIDs.get(i)));
		}
		return result;
	}
	
	/**
	 * გადაცემული ID-ებიდან, ქმნის Goal ობიექტების ArrayList-ს 
	 * @param Goals ArrayList<Integer> ID-ების ჩამონათვალი
	 * @return აბრუნებს List<Goal> ობიექტს
	 */
	public static List<Goal> setGoalsFromIDs(ArrayList<Integer> goalIDs){
		ArrayList<Goal> result = new ArrayList<Goal>();
		for(int i=0;i<goalIDs.size();i++){
			result.add(new Goal_kire(goalIDs.get(i)));
		}
		return result;
	}

	/**
	 * გადაცემული ID-ებიდან ქმნის Match ობიექტების ArrayList-ს
	 * @param matchIDs  ArrayList<Integer> ID-ების ჩამონათვალი
	 * @return
	 */
	public static List<Match> setMatchesFromIDs(ArrayList<Integer> matchIDs) {
		ArrayList<Match> result = new ArrayList<Match>();
		for(int i=0;i<matchIDs.size();i++){
			result.add(new Match_DLAPI(matchIDs.get(i)));
		}
		return result;
	}
}
