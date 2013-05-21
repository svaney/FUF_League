package model.dblayer;
import java.net.URL;
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
	public int getVission(int playerID);
	public int getPassing(int playerID);
	public int getPenalty(int playerID);
	public int getPenaltySaving(int playerID);
	public int getLidership(int playerID);
	public int getReflexes(int playerID);
	public int getShotStoping(int playerID);
	public int getMistakeFactor(int playerID);
	public String getFoot(int playerID);
	public URL getFBPage(int playerID);
	public String getPosition(int playerID);
	
	//პერსონის ცხრილიდან ამოღება
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
	
	// შეიძლება არ დამჭირდეს
	public int getPlayerID(int persongID);
	
	//მოთამაშის ცხრილში ჩამატება
	public double setRating(int playerID);
	public int setSpeed(int playerID);
	public int setDribbling(int playerID);
	public int setHeading(int playerID);
	public int setClubLoyalty(int playerID);
	public int setDiving(int playerID);
	public int setDurability(int playerID);
	public int setShooting(int playerID);
	public int setWorkRate(int playerID);
	public int setCreativity(int playerID);
	public int setFearFactor(int playerID);
	public int setKillerInstinct(int playerID);
	public int setVission(int playerID);
	public int setPassing(int playerID);
	public int setPenalty(int playerID);
	public int setPenaltySaving(int playerID);
	public int setLidership(int playerID);
	public int setRefxlexes(int playerID);
	public int setShotStoping(int playerID);
	public int setMistakeFactor(int playerID);
	public String setFoot(int playerID);
	public URL setFBPage(int playerID);
	public String setPosition(int playerID);
	
	//პერსონის ცხრილში ჩამატება
	public int setPersonID(int playerID);
	public String setFirstName(int playerID);
	public String setLastName(int playerID);
	public String setNickname(int playerID);
	public Date setBirthDate(int playerID);
	public Date setUniStartYear(int playerID);
	public int setUniCurrentCourse(int playerID);
	public char setGraduated(int playerID);
	public String setSchool(int playerID);
	public int setWeight(int playerID);
	public int setHeight(int playerID);
	public URL setImageURL(int playerID);
}
