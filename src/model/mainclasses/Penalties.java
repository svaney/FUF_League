/**
 * File: Penalties.java
 * type: interface
 * @author Data
 * -----------------
 * ერთი პენლების სერიის აღწერა. 
 */
package model.mainclasses;

import java.util.List;

public interface Penalties {
	
	/**
	 * აბრუნებს პენლების სერიის შედეგს ერთი გუნდისთვის 
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return ArrayList რომელშიც არის Goal კლასის ობიექტები (იმდენი, რამდენიც დაარტყეს) თუ პენალი
	 * ვერ გაიტანეს, მაშინ იქნება სპეციალური Goal კლასის ობიექტი, რომელსაც isGoalMissedPenalty იქნება true
	 */
	public List<Goal> getTeamsSerie(int teamID);
	
	/**
	 * აბრუნებს ყველა გოლს, ნებისმიერი გუნდის გატანილს, ამ ორი გუნდიდან
	 * @return ArrayList რომელშიც თანმიმდევრულად ყრია Goal ობიექტები, რომლებიც გაიტანეს.
	 */
	public List<Goal> getAllGoalsInSerie();
	
	/**
	 * გვეუბნება რამდენი აცდენა იყო პენლების სერიაში
	 * @return int ტიპის რაოდენობა, რამდენჯერ ააცილეს
	 */
	public int getMissedQuantity();
	
	/**
	 * რამდენი გაიტანა გუნდმა ამ სერიაში
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი გაიტანა გუნდმა ამ სერიაში 
	 */
	public int getTeamScore(int teamID);
	
	/**
	 * რამდენი ააცდინა გუნდმა
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი ააცდინა გუნდმა ამ სერიაში 
	 */
	public int getTeamMissedQuantity(int teamID);
	
}
