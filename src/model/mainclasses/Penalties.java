/**
 * File: Penalties.java
 * type: interface
 * @author Data
 * -----------------
 * ერთი პენლების სერიის აღწერა. 
 */
package model.mainclasses;

import java.util.ArrayList;
import java.util.List;

public interface Penalties {
	
	public List<Goal> getTeamsSerie(int teamID);
	public List<Goal> getAllGoalsInSerie();
	public int getMissedQuantity();
	public int getTeamScore(int teamID);
	public int getTeamMissedQuantity(int teamID);
	
}
