/**
 * File: Penalties.java
 * type: interface
 * @author Data
 * -----------------
 * ერთი პენლების სერიის აღწერა. 
 */
package model.mainclasses;

import java.util.ArrayList;

public interface Penalties {
	
	public ArrayList<Goal> getTeamsSerie(int teamID);
	public ArrayList<Goal> getAllGoalsInSerie();
	public int getMissedQuantity();
	public int getTeamScore(int teamID);
	public int getTeamMissedQuantity();
	
}
