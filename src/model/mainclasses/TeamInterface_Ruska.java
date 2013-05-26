/*
 * File: TeamInterface_Ruska.java
 * Author: ruska
 * -------------------------
 * ინტერფეისი Team_Ruska.java-სთვის
 */

package model.mainclasses;

import java.util.List;
import java.net.URL;


public interface TeamInterface_Ruska {
	
	public String getTeamName();
	public URL getTeamImageURL();
	public String getTeamEmail();
	public String getTeamTel();
	public int getTeamRating();
	public URL getTeamLogoURL();
	public List<Player> getTeamPlayers();
	public void setTeamImageURL(String strURL);
	

}
