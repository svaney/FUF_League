/*
 * File: TeamInterface.java
 * Author: ruska
 * -------------------------
 * ინტერფეისი Team_Ruska.java-სთვის
 */

package model.mainclasses;

import java.util.List;
import java.net.URL;


public interface Team {
	
	public int getID();
	public String getName();
	public URL getImageURL();
	public String getEmail();
	public String getTel();
	public int getRating();
	public URL getLogoURL();
	public List<Player> getPlayers(int champID);
	public List<Award> getAwards();
	public Award getAwardInChamp(int champID);
	public Player getCaptain(int champID);
	
	public void setImageURL(String strURL);
	public void removeImage();
	
	public void setLogo(String strURL);
	public void removeLogo();
	
	public boolean addPlayer(int playerID);
	public boolean removePlayer(int playerID);
	
	public void setEmail(String email);
	public void removeEmail();
	
	public void setTel(String tel);
	public void removeTel();
	
	public void addAward(Award award);
//	public void removeAward(Award award); //im shemtxvevisatis tu shecdomit daemata
	
	/**
	 * გუნდი უკაპიტნოდ არ უნდა არსებობდეს, ამიტომ ცალკე  removeCaptain setCaptain არაა საჭირო.
	 * ამ ორივე ფუნქციას შეასრულებს ეს მეთოდი და შედეგად არასდროს არ მოხდება ისე, რომ გუნდს არ
	 * ყავს კაპიტანი.
	 * */
	public void changeCaptain(Player player); 
	public void changeName(String name);
	public void setName(String name);

}
