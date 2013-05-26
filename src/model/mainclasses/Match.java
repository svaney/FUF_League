/**
 * File: MatchInterface.java
 * type: Interface
 * @author Data
 * -------------------------
 * ეს კლასი აღწერს ერთი კონკრეტული მატჩის ინტერფეისს.
 */
package model.mainclasses;

public interface Match {
	
	public String getMatchRound();
	public boolean hasExtraTime();
	public Score getScore();
	public String getDate();
	
}
