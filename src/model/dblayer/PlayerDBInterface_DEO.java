package model.dblayer;
import java.sql.*;
/**
 * PlayerDBInterface-ის ჩემი სამუშაო ვერსია
 * @author DEO.Gochava
 *
 */
public interface PlayerDBInterface_DEO {
	
	/* ცხრილები: player_award, Persons, Players
	 * კლასი, რომელიც ამ ინტერფეისს დაუკეთეს იმპლემენტაციას შეძლებს ბაზიდან ამოიღოს ყველა ინფრომაცია
	 * მოთამაშის შესახებ. 
	 * 
	 * ---- აქ უნდა ვიკითხო პერსონს ნაწილი ცალკე ხო არ ჯობია.
	 * */
	
	public void initConncection();
	
	//მოთამაშის ცხრილიდან ამოღება
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
	public int getVision(int playerID);
	public int getPassing(int playerID);
	public int getPenalty(int playerID);
	public int getPenaltySaving(int playerID);
	public int getLidership(int playerID);
	public int getReflexes(int playerID);
	public int getTackling(int playerID);
	public int getShotStoping(int playerID);
	public int getMistakeFactor(int playerID);
	public String getPosition(int playerID);
	public String getFoot(int playerID);
	
	//პერსონის ცხრილიდან ამოღება
	public int getPersonID(int playerID);
	public String getFirstName(int playerID);
	public String getLastName(int playerID);
	public String getNickname(int playerID);
	public Date getBirthDate(int playerID);
	public Date getUniStartYear(int playerID);
	public int getUniCurrentCourse(int playerID);
	public String getGraduated(int playerID);
	public String getSchool(int playerID);
	public int getWeight(int playerID);
	public int getHeight(int playerID);
	public String getImageURL(int playerID);
	public String getFBPage(int playerID);
	
	// შეიძლება არ დამჭირდეს
	public int getPlayerID(int personID);
	
	//მოთამაშის ცხრილში ჩამატება
	public void setSpeed(int playerID);
	public void setDribbling(int playerID);
	public void setHeading(int playerID);
	public void setClubLoyalty(int playerID);
	public void setDiving(int playerID);
	public void setDurability(int playerID);
	public void setShooting(int playerID);
	public void setWorkRate(int playerID);
	public void setCreativity(int playerID);
	public void setFearFactor(int playerID);
	public void setKillerInstinct(int playerID);
	public void setVission(int playerID);
	public void setPassing(int playerID);
	public void setPenalty(int playerID);
	public void setPenaltySaving(int playerID);
	public void setLidership(int playerID);
	public void setRefxlexes(int playerID);
	public void setTackling(int playerID);
	public void setShotStoping(int playerID);
	public void setMistakeFactor(int playerID);
	
	//პერსონის ცხრილში ჩამატება
	public void setPersonID(int playerID);
	public void setFirstName(int playerID);
	public void setLastName(int playerID);
	public void setNickname(int playerID);
	public void setBirthDate(int playerID);
	public void setUniStartYear(int playerID);
	public void setUniCurrentCourse(int playerID);
	public void setGraduated(int playerID);
	public void setSchool(int playerID);
	public void setWeight(int playerID);
	public void setHeight(int playerID);
	public void setImageURL(int playerID);
	public void setRating(int playerID);
	public void setFoot(int playerID);
	public void setFBPage(int playerID);
	public void setPosition(int playerID);
}
