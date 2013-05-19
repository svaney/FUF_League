package web;
import java.net.URL;
import java.sql.*;

public interface PlayerDB {
	
	public void initConncection();
	
	public double getRating(int playerID);
	public int getSpeed(int playerID);
	public int getDribbling(int playerID);
	public int getHeading(int playerID);
	public int getClubLoyalty(int playerID);
	public int getDiving(int playerID);
	public int getDurability(int playerID);
	public int getShooting(int playerID);
	public int getWorkRate(int playerID);
	public int getCreativity(int playerID);
	public int getFearFactor(int playerID);
	public int getKillerInstinct(int playerID);
	public String getFoot(int playerID);
	public URL getFBPage(int playerID);
	
	public int getPersonID(int playerID);
	public String getFirstName(int playerID);
	public String getLastName(int playerID);
	public String getNickname(int playerID);
	public Date getBirthDate(int playerID);
	public Date getUniStartYear(int playerID);
	public int getUniCurrentCourse(int playerID);
	public char getGraduated(int playerID);
	public String getSchool(int playerID);
	public int getWeight(int playerID);
	public int getHeight(int playerID);
	public URL getImageURL(int playerID);
	
	
	
}
