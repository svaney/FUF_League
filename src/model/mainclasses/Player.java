package model.mainclasses;

import java.util.Date;

public interface Player{

	// ამოღება.
	public String getFirstName();
	public String getLastName();
	public String getNickname();
	public String getBirthDate();
	public int getAge();
	public int getUniStartYear();
	public int getUniCurrentCourse();
	public boolean isStudent();
	public String getSchool();
	public int getWeight();
	public int getHeight();
	public String getAvatar();
	public String getBio();
	public double getRating();
	public String getFoot();
	public String getFbPage();
	public String getPosition();
	public String getTrait();
	public String getTeamName();

	public int getSpeed();
	public int getDribbling();
	public int getHeading();
	public int getClubLoyalty();
	public int getDiving();
	public int getDurability();
	public int getShooting();
	public int getWorkRate();
	public int getCreativity();
	public int getFearFactor();
	public int getKillerInstinct();
	public int getVision();
	public int getPassing();
	public int getPenalty();
	public int getPenaltySaving();
	public int getLidership();
	public int getReflexes();
	public int getTackling();
	public int getShotStoping();
	public int getMistakeFactor();
	public int getPositioning();
	public int getStrength();	
	public int getPersonID();
	public int getPlayerID();
	public int getTeamID();
	
	// ჩაწერა.
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setNickname(String nickName);
	public void setBirthDate(Date birthDate);
	public void setUniStartYear(int startYear);
	public void setUniCurrentCourse(int course);
	public void setSchool(String school);
	public void setWeight(int weight);
	public void setHeight(int height);	
	public void setAvatar(String avatar);
	public void setBio(String bio);
	public void setRating(double rating);
	public void setFoot(String foot);
	public void setFBPage(String fbPage);
	public void setPosition(String position);

	public void setSpeed(int param);
	public void setDribbling(int param);
	public void setHeading(int param);
	public void setClubLoyalty(int param);
	public void setDiving(int param);
	public void setDurability(int param);
	public void setShooting(int param);
	public void setWorkRate(int param);
	public void setCreativity(int param);
	public void setFearFactor(int param);
	public void setKillerInstinct(int param);
	public void setVision(int param);
	public void setPassing(int param);
	public void setPenalty(int param);
	public void setPenaltySaving(int param);
	public void setLidership(int param);
	public void setReflexes(int param);
	public void setTackling(int param);
	public void setShotStoping(int param);
	public void setMistakeFactor(int param);
	public void setPositioning(int param);
	public void setStrength(int param);	
	public void setTeamID(int teamID);
	
	// ადასტურებს ცვლილებებს და გადასცემს ბაზასთან მომუშავე კლასს შესანახად.
	public void commitPlayer();
}