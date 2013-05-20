package model.dblayer;

import java.net.URL;
import java.sql.Date;
/**
 * PlayerDB-ის ჩემი სამუშაო ვერსია.
 * @author DEO.Gochava
 *
 */
public class PlayerDB_DEO implements PlayerDBInterface_DEO{
	
	//cxrilebi: players, persons, player_award, //
	
	public PlayerDB_DEO(){
		initConncection();
	}

	@Override
	public void initConncection() {
		
	}

	@Override
	public double getRating(int playerID) {
		return 0;
	}

	@Override
	public int getSpeed(int playerID) {
		return 0;
	}

	@Override
	public int getDribbling(int playerID) {
		return 0;
	}

	@Override
	public int getHeading(int playerID) {
		return 0;
	}

	@Override
	public int getClubLoyalty(int playerID) {
		return 0;
	}

	@Override
	public int getDiving(int playerID) {
		return 0;
	}

	@Override
	public int getDurability(int playerID) {
		return 0;
	}

	@Override
	public int getShooting(int playerID) {
		return 0;
	}

	@Override
	public int getWorkRate(int playerID) {
		return 0;
	}

	@Override
	public int getCreativity(int playerID) {
		return 0;
	}

	@Override
	public int getFearFactor(int playerID) {
		return 0;
	}

	@Override
	public int getKillerInstinct(int playerID) {
		return 0;
	}

	@Override
	public String getFoot(int playerID) {
		return null;
	}

	@Override
	public URL getFBPage(int playerID) {
		return null;
	}

	@Override
	public String getPosition(int playerID) {
		return null;
	}

	@Override
	public int getPersonID(int playerID) {
		return 0;
	}

	@Override
	public String getFirstName(int playerID) {
		return null;
	}

	@Override
	public String getLastName(int playerID) {
		return null;
	}

	@Override
	public String getNickname(int playerID) {
		return null;
	}

	@Override
	public Date getBirthDate(int playerID) {
		return null;
	}

	@Override
	public Date getUniStartYear(int playerID) {
		return null;
	}

	@Override
	public int getUniCurrentCourse(int playerID) {
		return 0;
	}

	@Override
	public char getGraduated(int playerID) {
		return 0;
	}

	@Override
	public String getSchool(int playerID) {
		return null;
	}

	@Override
	public int getWeight(int playerID) {
		return 0;
	}

	@Override
	public int getHeight(int playerID) {
		return 0;
	}

	@Override
	public URL getImageURL(int playerID) {
		return null;
	}


}
