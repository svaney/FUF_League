package model.dblayer;
import java.sql.*;

import model.mainclasses.Player_DEO;
/**
 * @author DEO.Gochava
 *
 */
public interface PlayerDB{
	
	/* ცხრილები: player_award, Persons, Players
	 * კლასი, რომელიც ამ ინტერფეისს გაუკეთებს იმპლემენტაციას შეძლებს ბაზიდან ამოიღოს ყველა ინფრომაცია
	 * მოთამაშის შესახებ. 
	 * 
	 * ---- აქ უნდა ვიკითხო პერსონს ნაწილი ცალკე ხო არ ჯობია.
	 * */
	
	//მოთამაშის ცხრილიდან ამოღება.
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
	public int getPositioning(int playerID);
	public int getStrength(int playerID);
	public String getPosition(int playerID);
	public String getFoot(int playerID);
	public String getBio(int playerID);
	public String getTrait(int playerID);
	
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
	
	// გადაცემულ ID-სთან მიბმული სხვა ID-ების ამოღება.
	public int getTeamID(int playerID);
	
	// შემოწმება.
	public boolean exists(int playerID);
	
	// მოთამაშის შენახვა/წაშლა.
	public void commitPlayer(Player_DEO player);
	public void deletePlayer(Player_DEO player);
}
