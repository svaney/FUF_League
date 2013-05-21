package model.dblayer;

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
	private static final String PERSONS = "persons";	
	private static final String PLAYER_ID = "player_id";
	private static final String PERSON_ID = "person_id";
	
	// სამუშაო ცვლადები (მომავალში დავაზუსტებ ფუნქციებს)
	
	/**
	 * playerAtributes არის მხოლოდ და მხოლოდ საფეხბურთო ატრიბუტები (სიჩქარე, დრიბლინგი და სხვ.)
	 * ამ ატრიბუტების შესაბამისი მნიშვნელობები ბაზაში  არის INT ტიპის;
	 * სია ემთხვევა Players ცხრილის სვეტების სახელებს;
	 */
	private static ArrayList<String> playerAtributes = new ArrayList<String>();
	
	/**
	 * playerParametres არის პერსონის პარამეტრები Person ცხრილიდან.
	 * ამ პარამეტრების  შესაბამისი მნიშვნელობები ბაზაში არის STRING ტიპის;
	 * სია ემთხვევა Persons ცხრილის სვეტების სახელებს (მაგრამ არა ყველას);
	 */
	private static ArrayList<String> playerParametres = new ArrayList<String>();

	private static HashMap<Integer,HashMap<String,Integer>> playersAtributesList = new HashMap<Integer,HashMap<String,Integer>>();
	private static HashMap<Integer,HashMap<String,Object>> playersParametresList = new HashMap<Integer,HashMap<String,Object>>();

	private static Connection con;
	private static Statement stmt;
	
	public PlayerDB_DEO(){
		initConncection();
		fillColumnsTitle();
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

	/**
	 * თუ დააბრუნა -1.0, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა 0.0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 9.7;
	 */
	@Override
	public double getRating(int playerID) {
		String atribute = "rating";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute) == null) return 0;
			return Double.parseDouble((String)playersParametresList.get(getPersonID(playerID)).get(atribute));
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute) == null) return 0;
			return Double.parseDouble((String)playersParametresList.get(getPersonID(playerID)).get(atribute));
		}
		return -1;
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
	public int getVision(int playerID) {
		// TODO Auto-generated method stub
		int res = -1;
		String atribute = "vision";
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
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
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
		}
		return res;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მარჯვენა;
	 */
	@Override
	public String getFoot(int playerID) {
		String atribute = "foot";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ ან მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * ან  მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: www.facebook.com/Joni;
	 */
	@Override
	public String getFBPage(int playerID) {
		String atribute = "fb_page";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String) playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მცველი;
	 */
	@Override
	public String getPosition(int playerID) {
		String atribute = "position";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 108;
	 */
	@Override
	public int getPersonID(int playerID) {
		int res = -1;
		String atribute = "person_id";
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
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ირაკლი;
	 */
	@Override
	public String getFirstName(int playerID) {
		String atribute = "firstname";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ზარანდია;
	 */
	@Override
	public String getLastName(int playerID) {
		String atribute = "lastname";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მუშნი;
	 */
	@Override
	public String getNickname(int playerID) {
		String atribute = "nickname";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
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

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: III;
	 */
	@Override
	public String getUniCurrentCourse(int playerID) {
		String atribute = "uni_cur_course";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: N;
	 */
	@Override
	public String getGraduated(int playerID) {
		String atribute = "graduated";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ESM;
	 */
	@Override
	public String getSchool(int playerID) {
		String atribute = "school";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 65;
	 */
	@Override
	public String getWeight(int playerID) {
		String atribute = "weight";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 185;
	 */
	@Override
	public String getHeight(int playerID) {
		String atribute = "height";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: avatar_993.jpg;
	 */
	@Override
	public String getImageURL(int playerID) {
		String atribute = "image_URL";
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			if((String)playersParametresList.get(getPersonID(playerID)).get(atribute)==null) return "უცნობია";
			return (String)playersParametresList.get(getPersonID(playerID)).get(atribute);
		}
		return null;
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 107;
	 */
	@Override
	public int getPlayerID(int personID) {
		// TODO Auto-generated method stub
		String col = PLAYER_ID;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createStatement problem at PlayerDB_DEO.getPlayerID()");
			return -1;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PLAYERS+" where "+PLAYER_ID+"=\""+personID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeQuery problem at PlayerDB_DEO.getPlayerID(); error: "+sql);
			return -1;
		}
		try {
			if(result.next()) {
				return result.getInt(col);
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
		return 0;
	}

	@Override
	public void setRating(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSpeed(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setDribbling(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setHeading(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setClubLoyalty(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setDiving(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setDurability(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setShooting(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setWorkRate(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setCreativity(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFearFactor(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setKillerInstinct(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setVission(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPassing(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPenalty(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPenaltySaving(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setLidership(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setRefxlexes(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setShotStoping(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setMistakeFactor(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFoot(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFBPage(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPosition(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPersonID(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFirstName(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setLastName(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setNickname(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setBirthDate(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setUniStartYear(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setUniCurrentCourse(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setGraduated(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSchool(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setWeight(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setHeight(int playerID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setImageURL(int playerID) {
		// TODO Auto-generated method stub
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
				playersAtributesList.put(playerID,storeAtributes(result));
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
	 * ეს მეთოდი ბაზიდან იღებს Person ცხრილის მთლიან რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოძახებს მეთოდს store(ResultSet result),
	 * რომელიც დააბრუნებს მეპს; ამ მეპს მეთოდი ჩასვამს PlayerAtributesList-ში,
	 * რომლის გასაღებიც არის personID;
	 */
	private void getPerson(int personID) {
		// TODO Auto-generated method stub
		String col = "*";
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("createStatement problem at PlayerDB_DEO.getPerson()");
			return;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PERSONS+" where "+PERSON_ID+"=\""+personID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("executeQuery problem at PlayerDB_DEO.getPerson(); error: "+sql);
			return;
		}
		try {
			if(result.next()) {
				playersParametresList.put(personID,storeParametres(result));
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
	 * ავსებს ატრიბუტებისა და პარამეტრების  სიას; მოსახერხებელს ხდის resultSet-ში ინტერაციას
	 * ატრიბუტების სია არის მოთამაშის საფეხბურთო ატრიბუტების სია. ამ ატრიბუტების შესაბამისი მნიშვნელობები int-ებია;
	 * პარამეტრების სია არის პერსონის პარამეტრების სია. ამ პარამეტრების შესამაბისი მნიშვნელობები string-ებია;
	 */
	private static void fillColumnsTitle(){
		playerAtributes.add("person_id");
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
		
		playerParametres.add("firstname");
		playerParametres.add("lastname");
		playerParametres.add("nickname");
		playerParametres.add("school");
		playerParametres.add("degree");
		playerParametres.add("uni_cur_course");
		playerParametres.add("graduated");
		playerParametres.add("weight");
		playerParametres.add("height");
		playerParametres.add("image_URL");
		playerParametres.add("biography");
		playerParametres.add("special_atr");
		playerParametres.add("rating");
		playerParametres.add("fb_page");
		playerParametres.add("position");
		playerParametres.add("foot");
	}
	
	/**
	 * ვაბრუნებინებ მეპს (გასაღები = ატრიბუტი (მაგ: სიჩქარე); მნიშვნელობა ობიექტი, რომელსაც მეთოდი დაკასტავს შესაბამისად);
	 * თუ შენახული მნიშვნელობა არის 0, ეს იმას ნიშნავს, რომ ბაზაში მისი მნიშვნელობა null არის;
	 * @param result
	 * @return
	 */
	private HashMap<String, Integer> storeAtributes(ResultSet result) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> atr = new HashMap<String,Integer>();
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
	 * ვაბრუნებინებ მეპს (გასაღები = პარამეტრი (მაგ: სახელი); მნიშვნელობა ობიექტი, რომელსაც მეთოდი დაკასტავს შესაბამისად);
	 * @param result
	 * @return
	 */
	private HashMap<String, Object> storeParametres(ResultSet result) {
		// TODO Auto-generated method stub
		HashMap<String,Object> atr = new HashMap<String,Object>();
		for(String str:playerParametres){
			try {
				atr.put(str, result.getObject(str));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return atr;
	}
	
	/**
	 * ტესტებისთვის მჭირდება; დაბეჭდავს მოთამაშის ყველა ატრიბუტს და პარამეტრს;
	 * @param playerID
	 */
	public String toString(int playerID){
		String result = "PlayerID "+playerID+"::";
		if(playersAtributesList.containsKey(playerID)){
			for(String str: playerAtributes){
				result += " "+str+": "+playersAtributesList.get(playerID).get(str);
			}
		}else{
			getPlayer(playerID);
			if(playersAtributesList.containsKey(playerID)){
				for(String str: playerAtributes){
					result += " "+str+": "+playersAtributesList.get(playerID).get(str);
				}
			}
		}
		result +="\n";
		if(playersParametresList.containsKey(playerID)){
			for(String str: playerParametres){
				result += str+": "+playersParametresList.get(playerID).get(str)+" ";
			}
			return result;
		}else{
			getPerson(getPersonID(playerID));
			if(playersParametresList.containsKey(playerID)){
				for(String str: playerParametres){
					result += str+": "+playersParametresList.get(playerID).get(str)+" ";
				}
				return result;
			}
		}
		return("მოთამაშე მითითებული ID-ით:: "+playerID+" არ არსებობს");
	}
}
