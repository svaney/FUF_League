/**	
 * File:ScoreData.java
 * @author Data
 * -----------------
 * ეს კლასი აფიქსირებს ერთი კონკრეტული მატჩის ანგარიშს.
 * */

package model.mainclasses;

import java.util.ArrayList;

public class Score_DLAPI implements Score{

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
	 * აბრუნებს ამ მონაწილე გუნდებიდან ერთ-ერთის 
	 * @return  
	 */
	@Override
	public ArrayList<Goal> getPenaltiesForTeam(int teamID) {
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

	@Override
	public Goal getNthGoal(int Nth) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
