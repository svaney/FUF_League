/**
 * File: Penalties_DLAPI
 * type: class
 * @author Data
 * ---------------
 * ეს არის Penalties ინტერფეისის იმპლემენტაცია 
 */
package model.mainclasses;

import java.util.ArrayList;

public class Penalties_DLAPI implements Penalties{

	/**
	 * კონსტრუტორი
	 * @param matchID გადაეცემა მატჩის საიდენტიფიკაციო პარამეტრი
	 */
	public Penalties_DLAPI(int matchID){
		
	}
	
	/**
	 * აბრუნებს პენლების სერიის შედეგს ერთი გუნდისთვის 
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return ArrayList რომელშიც არის Goal კლასის ობიექტები (იმდენი, რამდენიც დაარტყეს) თუ პენალი
	 * ვერ გაიტანეს, მაშინ იქნება სპეციალური Goal კლასის ობიექტი, რომელსაც isGoalMissedPenalty იქნება true
	 */
	@Override
	public ArrayList<Goal> getTeamsSerie(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს ყველა გოლს, ნებისმიერი გუნდის გატანილს, ამ ორი გუნდიდან
	 * @return ArrayList რომელშიც თანმიმდევრულად ყრია Goal ობიექტები, რომლებიც გაიტანეს.
	 */
	@Override
	public ArrayList<Goal> getAllGoalsInSerie() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * გვეუბნება რამდენი აცდენა იყო პენლების სერიაში
	 * @return int ტიპის რაოდენობა, რამდენჯერ ააცილეს
	 */
	@Override
	public int getMissedQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * რამდენი გაიტანა გუნდმა ამ სერიაში
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი გაიტანა გუნდმა ამ სერიაში 
	 */
	@Override
	public int getTeamScore(int teamID) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * რამდენი ააცდინა გუნდმა
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი ააცდინა გუნდმა ამ სერიაში 
	 */
	@Override
	public int getTeamMissedQuantity(int teamID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
