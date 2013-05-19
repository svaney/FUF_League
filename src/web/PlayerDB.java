package web;

import java.net.URL;
import java.sql.Date;

public class PlayerDB implements PlayerDBInterface{
	
	//cxrilebi: players, persons, player_award, 
	
	public PlayerDB(){
		initConncection();
	}

	@Override
	public void initConncection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getRating(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpeed(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDribbling(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeading(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getClubLoyalty(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDiving(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDurability(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getShooting(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorkRate(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCreativity(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFearFactor(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getKillerInstinct(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFoot(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getFBPage(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPosition(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPersonID(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFirstName(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastName(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNickname(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBirthDate(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUniStartYear(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUniCurrentCourse(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getGraduated(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSchool(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeight(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URL getImageURL(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}


}
