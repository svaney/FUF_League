/**	
 * File: ScoreInterface.java
 * type: Interface
 * @author Data
 * -----------------
 * კონკრეტული მატჩის ანგარიშის ინტერფეისი.
 * */
package model.mainclasses;


public interface Score {
	
	public boolean hasPenaltySeries();
	public Penalties getPenaltiesForTeam(int teamID);
	public int getScoreForTeam(int teamID);
	public Goal getNthGoal(int Nth);
	
}
