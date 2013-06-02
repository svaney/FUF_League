package model.dblayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import model.mainclasses.Player_DEO;

/**
 * PlayerDB-ის ჩემი სამუშაო ვერსია.
 * @author DEO.Gochava
 *
 */
public class PlayerDB_DEO implements PlayerDB{
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
	private static String[] playerAtributes = {"person_id", "rating", "speed", "dribbling", "heading", "club_loyalty", "diving", "durability", "shooting", "work_rate", "creativity", "fear_factor", "killer_instinct", "vision", "passing", "penalty", "tackling", "penalty_saving", "lidership", "reflexes", "shot_stopping", "mistake_factor", "positioning", "strength", "foot", "def_position", "team_id"};

	
	/**
	 * playerParametres არის პერსონის პარამეტრები Person ცხრილიდან.
	 * ამ პარამეტრების  შესაბამისი მნიშვნელობები ბაზაში არის STRING ან DATE ტიპის;
	 * სია ემთხვევა Persons ცხრილის სვეტების სახელებს;
	 */
	private static String[] playerParametres = {"firstname", "lastname", "nickname", "birth_date", "uni_start", "school", "degree", "uni_cur_course", "graduated", "weight", "height", "image_URL", "biography", "special_atr", "fb_page", "firstname", "lastname", "nickname", "birth_date", "uni_start", "school", "degree", "uni_cur_course", "graduated", "weight", "height", "image_URL", "biography", "special_atr", "fb_page"};
	/**
	 * მოთამაშის საფეხბურთო ატრიბუტების სია. (გასაღები:მოთამაშის ID; მნიშვნელობა:(გასაღები:ატრიბუტის სახელი; მნიშვნელობა ბაზაში));
	 */
	private static HashMap<Integer,HashMap<String,Object>> playersAtributesList = new HashMap<Integer,HashMap<String,Object>>();
	/**
	 * პერსონის პირადი პარამეტრების სია. (გასაღები:პერსონის ID; მნიშვნელობა:(გასაღები:პარამეტრის სახელი; მნიშვნელობა ბაზაში));
	 */
	private static HashMap<Integer,HashMap<String,Object>> playersParametresList = new HashMap<Integer,HashMap<String,Object>>();

	private static Connection con;
	private static Statement stmt;
	
	public PlayerDB_DEO(){
		initConncection();
	}

	@Override
	public void initConncection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("შეცვალე MySQL კონსტანტები შენი კონსტანტებით! (ან შეამოწმე გაშვებულია თუ არა სერვერი).");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("დაამატე MySQL jar ფაილი კონსტრუქტორის მისამართში!");
		}
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getSpeed(int playerID) {
		String atribute = "speed";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}
	
	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDribbling(int playerID) {
		String atribute = "dribbling";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}
	
	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getHeading(int playerID) {
		String atribute = "heading";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getClubLoyalty(int playerID) {
		String atribute = "club_loyalty";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDiving(int playerID) {
		String atribute = "diving";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getDurability(int playerID) {
		String atribute = "durability";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getShooting(int playerID) {
		String atribute = "shooting";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getWorkRate(int playerID) {
		String atribute = "work_rate";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getCreativity(int playerID) {
		String atribute = "creativity";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getFearFactor(int playerID) {
		String atribute = "fear_factor";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getKillerInstinct(int playerID) {
		String atribute = "killer_instinct";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPassing(int playerID) {
		String atribute = "passing";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPenalty(int playerID) {
		String atribute = "penalty";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getVision(int playerID) {
		String atribute = "vision";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPenaltySaving(int playerID) {
		String atribute = "penalty_saving";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getLidership(int playerID) {
		String atribute = "lidership";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getReflexes(int playerID) {
		String atribute = "reflexes";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}
	
	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getTackling(int playerID) {
		String atribute = "tackling";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getShotStoping(int playerID) {
		String atribute = "shot_stopping";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getMistakeFactor(int playerID) {
		String atribute = "mistake_factor";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}
	
	/**

	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getPositioning(int playerID) {
		String atribute = "positioning";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**

	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 95;
	 */
	@Override
	public int getStrength(int playerID) {
		String atribute = "strength";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 001;
	 */
	@Override
	public int getPersonID(int playerID) {
		String atribute = "person_id";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return -1;
		}
		return (int) res;
	}
	
	/**
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 001;
	 */
	@Override
	public int getTeamID(int playerID) {
		String atribute = "team_id";
		Object res = getAtribute(atribute,playerID);
		if(res == null){
			return 0;
		}
		return (int) res;
	}

	/**
	 * თუ დააბრუნა 0.0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 9.7;
	 */
	@Override
	public double getRating(int playerID) {
		String atribute = "rating";
		if(getAtribute(atribute,playerID)==null){
			return 0.0;
		}
		return (double)getAtribute(atribute,playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ირაკლი;
	 */
	@Override
	public String getFirstName(int playerID) {
		String parameter = "firstname";
		return (String)getParameter(parameter,playerID);
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ზარანდია;
	 */
	@Override
	public String getLastName(int playerID) {
		String parameter = "lastname";
		return (String)getParameter(parameter,playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი უცნობია;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მუშნი;
	 */
	@Override
	public String getNickname(int playerID) {
		String parameter = "nickname";
		return (String)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი უცნობია;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 1992-01-01. YYYY-MM-DD;
	 */
	@Override
	public Date getBirthDate(int playerID) {
		String parameter = "birth_date";
		return (Date)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი უცნობია;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 2010. YYYY;
	 */
	@Override
	public Date getUniStartYear(int playerID) {
		String parameter = "uni_start";
		return (Date)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა 0, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: III;
	 */
	@Override
	public int getUniCurrentCourse(int playerID) {
		String parameter = "uni_cur_course";
		if(getParameter(parameter, playerID)==null) return 0;
		return (int)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * თუ დააბრუნა "უცნობია", მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: N;
	 */
	@Override
	public String getGraduated(int playerID) {
		String parameter = "graduated";
		return (String)getParameter(parameter, playerID);
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: ESM;
	 */
	@Override
	public String getSchool(int playerID) {
		String parameter = "school";
		return (String)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 65;
	 */
	@Override
	public int getWeight(int playerID) {
		String parameter = "weight";
		if(getParameter(parameter, playerID)==null) return -1;
		return (int)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 185;
	 */
	@Override
	public int getHeight(int playerID) {
		String parameter = "height";
		if(getParameter(parameter, playerID)==null) return -1;
		return (int)getParameter(parameter, playerID);
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: avatar_993.jpg;
	 */
	@Override
	public String getImageURL(int playerID) {
		String parameter = "image_URL";
		return (String)getParameter(parameter, playerID);
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ ან მითითებული მოთამაშე არ არსებობს (შესაბამისად, არც ეს ატრიბუტი);
	 * ან  მითითებული მოთამაშის ეს პარამეტრი არის null;
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: www.facebook.com/Joni;
	 */
	@Override
	public String getFBPage(int playerID) {
		String parameter = "fb_page";
		return (String)getParameter(parameter, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მცველი;
	 */
	@Override
	public String getPosition(int playerID) {
		String atribute = "def_position";
		return (String)getAtribute(atribute, playerID);
	}

	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მარჯვენა;
	 */
	@Override
	public String getFoot(int playerID) {
		String atribute = "foot";
		return (String)getAtribute(atribute, playerID);
	}
	
	/**
	 * თუ დააბრუნა null, მაშინ მითითებული მოთამაშის ეს პარამეტრი არის null ან მოთამაშე არ არსებობს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: მარჯვენა;
	 */
	@Override
	public String getBio(int playerID) {
		String atribute = "biography";
		return (String)getAtribute(atribute, playerID);
	}

	/**
	 * აბრუნებს მოთამაშის ID-ს;
	 * თუ მოთამაშე არ არის ბაზაში, მაშინ აბრუნებს -1-ს.
	 * სხვა შემთხვევაში აბრუნებს მოთამაშის მოთხოვნილი ატრიბუტის ზუსტ მნიშვნელობას;
	 * მაგალითად: 107;
	 */
	@Override
	public int getPlayerID(int playerID) {
		String col = PLAYER_ID;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at PlayerDB_DEO.getPlayerID()");
			return 0;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PLAYERS+" where "+PLAYER_ID+"=\""+playerID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at PlayerDB_DEO.getPlayerID(); error: "+sql);
			return 0;
		}
		try {
			if(result.next()) {
				return result.getInt(col);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return -1;
	}

	/**
	 * ეს მეთოდი ბაზიდან იღებს Players ცხრილის მთლიან რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოძახებს მეთოდს store(ResultSet result),
	 * რომელიც დააბრუნებს მეპს; ამ მეპს მეთოდი ჩასვამს PlayerAtributesList-ში,
	 * რომლის გასაღებიც არის playerID;
	 */
	private void getPlayer(int playerID) {
		String col = "*";
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at PlayerDB_DEO.getPlayer()");
			return;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PLAYERS+" where "+PLAYER_ID+"=\""+playerID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at PlayerDB_DEO.getPlayer(); error: "+sql);
			return;
		}
		try {
			if(result.next()) {
				playersAtributesList.put(playerID,storeAtributes(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
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
		String col = "*";
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at PlayerDB_DEO.getPerson()");
			return;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PERSONS+" where "+PERSON_ID+"=\""+personID+"\";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at PlayerDB_DEO.getPerson(); error: "+sql);
			return;
		}
		try {
			if(result.next()) {
				playersParametresList.put(personID,storeParameters(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
	/**
	 * ვაბრუნებინებ მეპს (გასაღები = ატრიბუტი (მაგ: სიჩქარე); მნიშვნელობა ობიექტი, რომელსაც მეთოდი დაკასტავს შესაბამისად);
	 * თუ შენახული მნიშვნელობა არის 0, ეს იმას ნიშნავს, რომ ბაზაში მისი მნიშვნელობა null არის;
	 * @param result
	 * @return
	 */
	private HashMap<String, Object> storeAtributes(ResultSet result) {
		HashMap<String,Object> atr = new HashMap<String,Object>();
		for(String str:playerAtributes){
			try {
				atr.put(str, result.getObject(str));
			} catch (SQLException e) {
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
	private HashMap<String, Object> storeParameters(ResultSet result) {
		HashMap<String,Object> atr = new HashMap<String,Object>();
		for(String str:playerParametres){
			try {
				atr.put(str, result.getObject(str));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return atr;
	}
	
	/**
	 * აბრუნებს ობიექტს ატრიბუტების სიიდან.
	 * @param atribute - მეორე გასაღები
	 * @param playerID - ატრიბუტების სიის გასაღები
	 * @return
	 */
	private Object getAtribute(String atribute,int playerID){
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
		}
		getPlayer(playerID);
		if(playersAtributesList.containsKey(playerID)){
			return playersAtributesList.get(playerID).get(atribute);
		}
		return null;
	}
	
	/**
	 * აბრუნებს ობიექტს პარამეტრების სიიდან.
	 * @param parameter - მეორე გასაღები.
	 * @param playerID - გამოყენება: getPerson(playerID).
	 * @return
	 */
	private Object getParameter(String parameter, int playerID){
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return playersParametresList.get(getPersonID(playerID)).get(parameter);
		}
		getPerson(playerID);
		if(playersParametresList.containsKey(getPersonID(playerID))){
			return playersParametresList.get(getPersonID(playerID)).get(parameter);
		}
		return null;
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
	
	public void reset(){
		playersAtributesList.clear();
		playersParametresList.clear();
	}
	
	/**
	 * ამოწმებს არსებობს თუ არა მოთამაშე მითითებული ID-ით.
	 * @param playerID
	 * @return TRUE - არსებობს, FALSE - არ არსებობს.
	 */
	@Override
	public boolean exists(int playerID){
		if(getPlayerID(playerID)==-1) return false;
		return true;
	}

	/**
	 * აკომიტებს ახალი მოთამაშის შექმნას ან არსებულის ცვლილებას
	 */
	@Override
	public void commitPlayer(Player_DEO player) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ბაზაში ახალი მოთამაშის დამატება.
	 */
	private void newPlayer(Player_DEO player) {
	}
	
	/**
	 * ბაზაში არსებული მოთამაშის შესწორების დადასტურება.
	 */
	private void editPlayer(Player_DEO player) {
	}
	
	/**
	 * ბაზაში არსებული მოთამაშის წაშლა.
	 */
	private void deletePlayer(Player_DEO player) {
	}
}