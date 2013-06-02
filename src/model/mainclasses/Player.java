package model.mainclasses;

public interface Player{

	// ამოღება.
	public String getFirstName();
	public String getLastName();
	public String getNickname();
	public String getBirthDate();
	public int getAge();
	public String getUniStartYear();
	public String getUniCurrentCourse();
	public boolean isStudent();
	public String getSchool();
	public String getWeight();
	public String getHeight();
	public String getAvatar();
	public String getBio();
	public double getRating();
	public String getFoot();
	public String getFBPage();
	public String getPosition();
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
	public boolean hasRatingBar();
	public boolean hasNickname();
	
	// ჩაწერა.
	public void setFirstName();
	public void setLastName();
	public void setNickname();
	public void setBirthDate();
	public void setUniStartYear();
	public void setUniCurrentCourse();
	public void setSchool();
	public void setWeight();
	public void setHeight();
	public void setAvatar();
	public void setBio();
	public void setRating();
	public void setFoot();
	public void setFBPage();
	public void setPosition();
	public void setTeamName();

	public void setSpeed();
	public void setDribbling();
	public void setHeading();
	public void setClubLoyalty();
	public void setDiving();
	public void setDurability();
	public void setShooting();
	public void setWorkRate();
	public void setCreativity();
	public void setFearFactor();
	public void setKillerInstinct();
	public void setVision();
	public void setPassing();
	public void setPenalty();
	public void setPenaltySaving();
	public void setLidership();
	public void setReflexes();
	public void setTackling();
	public void setShotStoping();
	public void setMistakeFactor();
	public void setPositioning();
	public void setStrength();	
	public void setTeamID();
	
	// ადასტურებს ცვლილებებს და გადასცემს ბაზასთან მომუშავე კლასს შესანახად.
	public void commitPlayer();
}