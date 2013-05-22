package model.mainclasses;

import java.sql.Date;

public interface PlayerInterface_DEO {

	public int getPersonID(int playerID);
	public String getFirstName(int playerID);
	public String getLastName(int playerID);
	public String getNickname(int playerID);
	public Date getBirthDate(int playerID);
	public Date getUniStartYear(int playerID);
	public String getUniCurrentCourse(int playerID);
	public String getGraduated(int playerID);
	public String getSchool(int playerID);
	public String getWeight(int playerID);
	public String getHeight(int playerID);
	public String getAvatar(int playerID);
	public double getRating(int playerID);
	public String getFoot(int playerID);
	public String getFBPage(int playerID);
	public String getPosition(int playerID);

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
	public int getVision(int playerID);
	public int getPassing(int playerID);
	public int getPenalty(int playerID);
	public int getPenaltySaving(int playerID);
	public int getLidership(int playerID);
	public int getReflexes(int playerID);
	public int getShotStoping(int playerID);
	public int getMistakeFactor(int playerID);
	public int getNumber(int playerID);
	
}
