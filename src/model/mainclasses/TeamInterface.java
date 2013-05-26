/*
 * File: TeamInterface.java
 * Author: ruska
 * -------------------------
 * ინტერფეისი Team_Ruska.java-სთვის
 */

package model.mainclasses;

import java.util.List;
import java.net.URL;


public interface TeamInterface {
	
	public String getTeamName();
	public URL getTeamImageURL();
	public String getTeamEmail();
	public String getTeamTel();
	public int getTeamRating();
	public URL getTeamLogoURL();
	public List<Player> getTeamPlayers();
//	public List<Award> getTeamAwards();
	
	public void setTeamImageURL(String strURL);
	public void setTeamLogo(String strURL);
	public void addPlayer(int playerID);
	public void setTeamEmail(String email);
	public void setTeamTel(String tel);
//	public void addAward(Award award);
	
	
	

}
