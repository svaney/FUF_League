/**	
 * File:ScoreData.java
 * @author Data
 * -----------------
 * ეს კლასი აფიქსირებს ერთი კონკრეტული მატჩის ანგარიშს.
 * */

package model.mainclasses;

import java.util.ArrayList;

public class Score_DLAPI implements Score{

	/**
	 * კონსტრუქტორი
	 *  
	 */
	public Score_DLAPI(){
		
	}
	
	/**
	 * აბრუნებს ამ თამაშის Score-ში არის თუ არა პენლების სერია გათვალისწინებული
	 * @return true - თუკი იყო პენლების სერია, false წინააღმდეგ შემთხვევაში
	 */
	@Override
	public boolean hasPenaltySeries() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * აბრუნებს ამ მონაწილე გუნდებიდან ერთ-ერთის შედეგს პენლების სერიაში
	 * @return  Penalties კლასის ობიექტს თუკი იყო პენლები, თუ არადა null
	 * @param taemID გუნდის ID, რათა გაარკვიოს რომელი გუნდისთვის სურს დაბრუნება 
	 */
	@Override
	public Penalties getPenaltiesForTeam(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ითვლის რამდენი გოლი გაიტანა გუნდმა
	 * @param teamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა ძირითად დროში
	 */
	@Override
	public int getScoreForTeam(int teamID) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * გვეუბნება მე-n გოლი რომელი იყო ამ თამაშში, არ აქვს მნიშვნელობა, რომელმა გუნდმა გაიტანა
	 * @param Nth - n მერამდენე გოლი გვინდა
	 * @return Goal ტიპის ცვლადი.
	 */
	@Override
	public Goal getNthGoal(int Nth) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
