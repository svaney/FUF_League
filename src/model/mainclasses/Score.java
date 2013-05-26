/**	
 * File: ScoreInterface.java
 * type: Interface
 * @author Data
 * -----------------
 * კონკრეტული მატჩის ანგარიშის ინტერფეისი.
 * */
package model.mainclasses;

import java.util.ArrayList;

public interface Score {
	
	public boolean hasPenaltySeries();
	public ArrayList<Goal> getPenaltiesForTeam(int teamID);
	public int getScoreForTeam(int teamID);
	public Goal getNthGoal(int Nth);
	
}
