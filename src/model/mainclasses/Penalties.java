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
	 * @return ArrayList რომელშიც არის PenaltyShoot კლასის ობიექტები 
	 */
	 List<PenaltyShoot> getTeamsSerie(int teamID);
	
	/**
	 * რამდენი გაიტანა გუნდმა ამ სერიაში
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი გაიტანა გუნდმა ამ სერიაში 
	 */
	 int getTeamScore(int teamID);
	
	/**
	 * რამდენი ააცდინა გუნდმა
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი ააცდინა გუნდმა ამ სერიაში 
	 */
	 int getTeamMissedQuantity(int teamID);
	
}
