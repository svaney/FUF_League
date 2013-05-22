package model.mainclasses;

import java.sql.Date;

import model.dblayer.PlayerDB_DEO;

public class Player_DEO implements PlayerInterface_DEO {
	private static String firstname = null;
	private static String lastname = null;
	private static String nickname = null;
	private static Date birthDate = null;
	private static Date uniStart = null;
	private static String uniCourse = null;
	private static String graduated = null;
	private static String school = null;
	private static String weight = null;
	private static String height = null;
	private static String homePage = null;
	private static Double rating = null;
	private static String foot = null;
	private static String image = "design/defaultAvatar.png";
	private static String position = null;
	
	public Player_DEO(int playerID){
		PlayerDB_DEO player = new PlayerDB_DEO();
		firstname = player.getFirstName(playerID);
		lastname = player.getLastName(playerID);
		nickname = player.getNickname(playerID);
		birthDate = player.getBirthDate(playerID);
		uniStart = player.getUniStartYear(playerID);
		uniCourse = player.getUniCurrentCourse(playerID);
		graduated = player.getGraduated(playerID);
		school = player.getSchool(playerID);
		weight = player.getWeight(playerID);
		height = player.getHeight(playerID);
		homePage = player.getFBPage(playerID);
		rating = player.getRating(playerID);
		foot = player.getFoot(playerID);
		if(player.getImageURL(playerID) != null)image = "players/"+player.getImageURL(playerID);
		position = player.getPosition(playerID);
		player.reset();
	}
	
	
	@Override
	public int getPersonID(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFirstName(int playerID) {
		return firstname;
	}

	@Override
	public String getLastName(int playerID) {
		return lastname;
	}

	@Override
	public String getNickname(int playerID) {
		return nickname;
	}

	@Override
	public Date getBirthDate(int playerID) {
		return birthDate;
	}

	@Override
	public Date getUniStartYear(int playerID) {
		return uniStart;
	}

	@Override
	public String getUniCurrentCourse(int playerID) {
		return uniCourse;
	}

	@Override
	public String getGraduated(int playerID) {
		return graduated;
	}

	@Override
	public String getSchool(int playerID) {
		return school;
	}

	@Override
	public String getWeight(int playerID) {
		return weight;
	}

	@Override
	public String getHeight(int playerID) {
		return height;
	}

	@Override
	public String getAvatar(int playerID) {
		return image;
	}
	
	@Override
	public double getRating(int playerID) {
		return rating;
	}

	@Override
	public String getFoot(int playerID) {
		return foot;
	}

	@Override
	public String getFBPage(int playerID) {
		return homePage;
	}

	@Override
	public String getPosition(int playerID) {
		return position;
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
	public int getVision(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPassing(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPenalty(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPenaltySaving(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLidership(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReflexes(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getShotStoping(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMistakeFactor(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumber(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

}
