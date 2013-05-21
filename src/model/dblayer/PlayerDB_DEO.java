package model.dblayer;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * PlayerDB-ის ჩემი სამუშაო ვერსია.
 * რადგან პირადი ვერსიაა, ამიტომ MySQL კონსტანტები არ არის default
 * @author DEO.Gochava
 *
 */
public class PlayerDB_DEO implements PlayerDBInterface_DEO{
	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	
	// საჭირო ცხრილებისა და სვეტები სახელები
	private static final String PLAYERS = "players";
//	private static final String PERSONS = "persons";	
	private static final String PLAYER_ID = "player_id";
	
	// სამუშაო ცვლადები (მომავალში დავაზუსტებ ფუნქციებს)
	
	/**
	 * playerAtributes არის მხოლოდ და მხოლოდ საფეხბურთო ატრიბუტები (სიჩქარე, დრიბლინგი და სხვ.)
	 * ამ ატრიბუტების შესაბამისი მნიშვნელობები ბაზაში  არის INT ტიპის;
	 */
	private static ArrayList<String> playerAtributes = new ArrayList<String>();
	
	/**
	 * playerParametres არის Player ცხრილის ისეთი სვეტები, რომლის მნიშვნელობა არის სტრინგი
	 * მაგ: FB_PAGE
	 */
	private static ArrayList<String> playerParametres = new ArrayList<String>();

	private static HashMap<Integer,HashMap<String,Object>> playersAtributesList = new HashMap<Integer,HashMap<String,Object>>();
	private static Connection con;
	private static Statement stmt;
	
	public PlayerDB_DEO(){
		initConncection();
		fillAtributes();
	}

	@Override
	public void initConncection() {
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

	@Override
	public double getRating(int playerID) {
		return playerID;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getSpeed(int playerID) {
		int res = -1;
		String atribute = "speed";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}
	
	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDribbling(int playerID) {
		int res = -1;
		String atribute = "dribbling";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}
	
	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getHeading(int playerID) {
		int res = -1;
		String atribute = "heading";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getClubLoyalty(int playerID) {
		int res = -1;
		String atribute = "club_loyalty";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDiving(int playerID) {
		int res = -1;
		String atribute = "diving";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDurability(int playerID) {
		int res = -1;
		String atribute = "durability";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getShooting(int playerID) {
		int res = -1;
		String atribute = "shooting";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getWorkRate(int playerID) {
		int res = -1;
		String atribute = "work_rate";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getCreativity(int playerID) {
		int res = -1;
		String atribute = "creativity";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getFearFactor(int playerID) {
		int res = -1;
		String atribute = "fear_factor";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getKillerInstinct(int playerID) {
		int res = -1;
		String atribute = "killer_instinct";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPassing(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "passing";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPenalty(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "penalty";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getVission(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "vision";
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int) playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPenaltySaving(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "penalty_saving";
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getLidership(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "lidership";
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getReflexes(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "reflexes";
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getShotStoping(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "shot_stopping";
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა -1, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getMistakeFactor(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "mistake_factor";
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return (int)playersAtributesList.get(playerID).get(atribute);
		}
		return res;
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
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს Players ცხრილის მთლიან რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოძახებს მეთოდს store(ResultSet result),
	 * რომელიც დააბრუნებს მეპს; ამ მეპს მეთოდი ჩასვამს PlayerAtributesList-ში,
	 * რომლის გასაღებიც არის playerID;
	 */
	private void getPlayer(int playerID) {
		// TODO Auto-generated method stub
		String col = "*";
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createStatement problem at PlayerDB_DEO.getPlayer()");
			return;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PLAYERS+" where "+PLAYER_ID+"=\""+playerID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeQuery problem at PlayerDB_DEO.getPlayer(); error: "+sql);
			return;
		}
		try {
			if(result.next()) {
				playersAtributesList.put(playerID,store(result));
			}
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
		return;
	}
	
	/**
	 * ავსებს ატრიბუტების სიას; მოსახერხებელს ხდის resultSet-ში ინტერაციას
	 * ატრიბუტების სია არის მოთამაშის საფეხბურთო ატრიბუტების სია. ამ ატრიბუტების შესაბამისი მნიშვნელობები int-ებია;
	 */
	private static void fillAtributes(){
		playerAtributes.add("speed");
		playerAtributes.add("dribbling");
		playerAtributes.add("heading");
		playerAtributes.add("club_loyalty");
		playerAtributes.add("diving");
		playerAtributes.add("durability");
		playerAtributes.add("shooting");
		playerAtributes.add("work_rate");
		playerAtributes.add("creativity");
		playerAtributes.add("fear_factor");
		playerAtributes.add("killer_instinct");
		playerAtributes.add("vision");
		playerAtributes.add("passing");
		playerAtributes.add("penalty");
		playerAtributes.add("penalty_saving");
		playerAtributes.add("lidership");
		playerAtributes.add("reflexes");
		playerAtributes.add("shot_stopping");
		playerAtributes.add("mistake_factor");
		playerAtributes.add("number");
	}
	
	/**
	 * ვაბრუნებინებ მეპს (გასაღები = პარამეტრი (მაგ: სიჩქარე); მნიშვნელობა ობიექტი, რომელსაც მეთოდი დაკასტავს შესაბამისად);
	 * თუ შენახული მნიშვნელობა არის 0, ეს იმას ნიშნავს, რომ ბაზაში მისი მნიშვნელობა null არის;
	 * @param result
	 * @return
	 */
	private HashMap<String, Object> store(ResultSet result) {
		// TODO Auto-generated method stub
		HashMap<String,Object> atr = new HashMap<String,Object>();
		for(String str:playerAtributes){
			try {
				atr.put(str, result.getInt(str));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return atr;
	}
	
	/**
	 * ტესტებისთვის მჭირდება; დაბეჭდავს მოთამაშის ყველა საფეხბურთო ატრიბუტს (პოზიციისა და ფეხის გარდა);
	 * @param playerID
	 */
	public String toString(int playerID){
		String result = "PlayerID "+playerID+"::";
		if(playersAtributesList.containsKey(playerID)){
			for(String str: playerAtributes){
				result += " "+str+": "+playersAtributesList.get(playerID).get(str);
			}
			return result;
		}else{
			getPlayer(playerID);
		}
		if(playersAtributesList.containsKey(playerID)){
			for(String str: playerAtributes){
				result += " "+str+": "+playersAtributesList.get(playerID).get(str);
			}
			return result;
		}
		return("მოთამაშე მითითებული ID-ით <"+playerID+"> არ არსებობს.");
	}

}
