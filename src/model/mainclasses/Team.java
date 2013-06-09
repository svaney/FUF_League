/*
 * File: TeamInterface.java
 * Author: ruska
 * -------------------------
 * ინტერფეისი Team_Ruska.java-სთვის
 */

package model.mainclasses;
import java.util.List;

public interface Team {
	
	public int getID();
	public String getName();
	public String getImageURL();
	public String getEmail();
	public String getTel();
	public int getRating();
	public String getLogoURL();
	public List<Player> getPlayers(int champID);
	public List<Award> getAwards();
	public Award getAwardInChamp(int champID);
	public Player getCaptain(int champID);
	
	public void setImageURL(String url);
	public void removeImage();
	
	public void setLogo(String url);
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
	public void setCaptain(Player player);
	public void setRating(int rating);

}
