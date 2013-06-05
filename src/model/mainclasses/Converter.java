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
	 * @return აბრუნებს ArrayList<Player> ობიექტს
	 */
	public static List<Player> setPlayersFromIDs(ArrayList<Integer> players){
		ArrayList<Player> result = new ArrayList<Player>();
		for(int i=0;i<players.size();i++){
			result.add(new Player_DEO(players.get(i)));
		}
		return result;
	}
}
