package model.dblayer;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * PlayerDB-ის ჩემი სამუშაო ვერსია.
 * რადგან პირადი ვერსიაა, ამიტომ MySQL კონსტანტები არ არის default
 * @author DEO.Gochava
 *
 */
public class PlayerDB_DEO implements PlayerDBInterface_DEO{
	
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "DeoGochava1992";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	
	private static final String PLAYERS = "players";
//	private static final String PERSONS = "persons";
	private static final String PLAYER_ID = "player_id";
		
	private static Connection con;
	private static Statement stmt;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("შეცვალე MySQL კონსტანტები შენი კონსტანტებით!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("CS108 student: Add the MySQL jar file to your build path!");
		}
	}
	
	public PlayerDB_DEO(){
		initConncection();
	}

	@Override
	public Connection initConncection() {
		return con;
	}

	@Override
	public double getRating(int playerID) {
		return playerID;
	}

	@Override
	public int getSpeed(int playerID) {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createStatement problem at MyDB.getProduct();");
			return 0;
		}
		ResultSet result = null;
		String sql = "select speed from "+PLAYERS+" where "+PLAYER_ID+"=\""+playerID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeQuery problem at MyDB.getProduct(); error: "+sql);
			return 0;
		}
		int speed = 0;
		try {
			if(result.next()) speed = result.getInt("speed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return speed;
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

	@Override
	public int getVission(int playerID) {
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
	public int getRefxlexes(int playerID) {
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
	public int getPlayerID(int persongID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double setRating(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setSpeed(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDribbling(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHeading(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setClubLoyalty(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDiving(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDurability(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setShooting(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWorkRate(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setCreativity(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setFearFactor(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setKillerInstinct(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setVission(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPassing(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPenalty(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPenaltySaving(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setLidership(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setRefxlexes(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setShotStoping(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setMistakeFactor(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setFoot(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL setFBPage(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setPosition(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setPersonID(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setFirstName(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setLastName(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setNickname(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date setBirthDate(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date setUniStartYear(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setUniCurrentCourse(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char setGraduated(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String setSchool(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setWeight(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHeight(int playerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URL setImageURL(int playerID) {
		// TODO Auto-generated method stub
		return null;
	}


}
