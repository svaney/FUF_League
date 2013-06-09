package model.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	/**
	 * 
	 * @author DEO.Gochava
	 *
	 */

public class ListsDB_DEO implements ListsDB{
	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	
	// ცხრილების პარამეტრები
	private static final String TEAMS = "teams";
	private static final String TEAM_ID = "team_id";
	private static final String TEAM_NAME = "name";
	
	private static final String PLAYERS = "players";
	private static final String PERSONS = "persons";
	private static final String PLAYER_ID = "player_id";
	private static final String PERSON_ID = "person_id";
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	
	private static final String POSITIONS = "positions";
	private static final String POSITION = "position";
	
	private static final String CHAMP_TYPES = "champ_types";
	private static final String TYPES = "champ_type";

	private static Connection con;
	private static Statement stmt;
	
	public ListsDB_DEO(){
		initConncection();
	}

	private void initConncection() {
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

	@Override
	public String[][] listAllPlayers() {
		return normalizedPlayers(getPlayerPersons(), getPlayerNames());
	}
	
	/**
	 * აბრუნებს სტრინგების 2 ადგილიან მასივს. მასივი[გუნდის ID][გუნდის სახელი];
	 */
	@Override
	public String[][] listAllTeams() {
		return getTeams();
	}

	@Override
	public String[] listAllPositions() {
		return getPositions();
	}

	@Override
	public String[] listAllTypes() {
		return getTypes();
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს გუნდების ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოიძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[][] getTeams() {
		String col = TEAM_ID+", "+TEAM_NAME;
		String[][] teams = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getTeams()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+TEAMS+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getTeams(); error: "+sql);
			return null;
		}
		teams = (normalizedTeams(result));
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}
	
	/**
	 * ResultSet-ს ამუშავებს გუნდების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[][] normalizedTeams(ResultSet result){
		ArrayList<String> teamID = new ArrayList<String>();
		ArrayList<String> teamName = new ArrayList<String>();
		try {
			while(result.next()){
				teamID.add(result.getString(TEAM_ID));
				teamName.add(result.getString(TEAM_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[][] teams = new String[teamID.size()][2];
		for(int i = 0; i < teams.length; i++){
			teams[i][0] = teamID.get(i);
			teams[i][1] = teamName.get(i);
		}
		teamID.clear();
		teamName.clear();
		return teams;
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს პოზიციების ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოიძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[] getPositions() {
		String col = POSITION;
		String[] positions = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getPositions()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+POSITIONS+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getPositions(); error: "+sql);
			return null;
		}
		positions = (normalizedPositions(result));
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}
	
	/**
	 * ResultSet-ს ამუშავებს პოზიციების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[] normalizedPositions(ResultSet result){
		ArrayList<String> positions = new ArrayList<String>();
		try {
			while(result.next()){
				positions.add(result.getString(POSITION));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] pos = new String[positions.size()];
		for(int i = 0; i < pos.length; i++){
			pos[i] = positions.get(i);
		}
		return pos;
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს ჩემპიონატის ტიპების ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოიძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[] getTypes() {
		String col = TYPES;
		String[] positions = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getTypes()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+CHAMP_TYPES+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getTypes(); error: "+sql);
			return null;
		}
		positions = (normalizedTypes(result));
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}
	
	/**
	 * ResultSet-ს ამუშავებს ჩემპიონატის ტიპების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[] normalizedTypes(ResultSet result){
		ArrayList<String> types = new ArrayList<String>();
		try {
			while(result.next()){
				types.add(result.getString(TYPES));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] type = new String[types.size()];
		for(int i = 0; i < type.length; i++){
			type[i] = types.get(i);
		}
		return type;
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს მოთამაშეების ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოიძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[][] getPlayerPersons() {
		String col = PLAYER_ID+", "+PERSON_ID;
		String[][] persons = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getPlayerPersons()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PLAYERS+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getPlayerPersons(); error: "+sql);
			return null;
		}
		persons = (normalizedPersons(result));
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}
	
	/**
	 * ეს მეთოდი ბაზიდან იღებს მოთამაშეების ცხრილის ყველა რიგს;
	 * თუ მითითებული რიგი არსებობს, მაშინ ის გამოიძახებს მეთოდს normalized(ResultSet result),
	 * რომელიც დააბრუნებს გამზადებულ მასივს;
	 */
	private String[][] getPlayerNames() {
		String col = PERSON_ID+", "+FIRST_NAME+", "+LAST_NAME;
		String[][] names = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.out.println("createStatement problem at ListDB_DEO.getPlayerNames()");
			return null;
		}
		ResultSet result = null;
		String sql = "select "+col+" from "+PERSONS+";";
		try {
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery problem at ListDB_DEO.getPlayerNames(); error: "+sql);
			return null;
		}
		names = (normalizedNames(result));
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}
	
	/**
	 * ResultSet-ს ამუშავებს გუნდების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[][] normalizedPlayers(String[][]ids, String[][]names){
		ArrayList<String> playerID = new ArrayList<String>();
		ArrayList<String> playerName = new ArrayList<String>();
		for(int i = 0; i < ids.length; i ++){
			for(int j = 0; j < names.length; j++){
				if(ids[i][0].equals(names[j][0])){
					playerID.add(ids[i][1]);
					playerName.add(names[j][1]);
				}
			}
		}
		String[][] players = new String[playerID.size()][2];
		for(int i = 0; i < players.length; i++){
			players[i][0] = playerID.get(i);
			players[i][1] = playerName.get(i);
		}
		playerID.clear();
		playerName.clear();
		return players;
	}
	
	/**
	 * ResultSet-ს ამუშავებს გუნდების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[][] normalizedNames(ResultSet result){
		ArrayList<String> personID = new ArrayList<String>();
		ArrayList<String> playerName = new ArrayList<String>();
		try {
			while(result.next()){
				personID.add(result.getString(PERSON_ID));
				playerName.add(result.getString(FIRST_NAME)+" "+result.getString(LAST_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[][] players = new String[personID.size()][2];
		for(int i = 0; i < players.length; i++){
			players[i][0] = personID.get(i);
			players[i][1] = playerName.get(i);
		}
		personID.clear();
		playerName.clear();
		return players;
	}
	
	/**
	 * ResultSet-ს ამუშავებს გუნდების სიის შესაბამის ფორმამდე.
	 * @param result
	 * @return
	 */
	private String[][] normalizedPersons(ResultSet result){
		ArrayList<String> playerID = new ArrayList<String>();
		ArrayList<String> personID = new ArrayList<String>();
		try {
			while(result.next()){
				playerID.add(result.getString(PLAYER_ID));
				personID.add(result.getString(PERSON_ID));			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[][] persons = new String[playerID.size()][2];
		for(int i = 0; i < persons.length; i++){
			persons[i][0] = personID.get(i);
			persons[i][1] = playerID.get(i);
		}
		playerID.clear();
		personID.clear();
		return persons;
	}

	/**
	 * აბრუნებს მატჩების ID_ებს.
	 * @return Integer ობიექტების List
	 * @author Data
	 * @throws SQLException 
	 */
	@Override
	public List<Integer> getMatchIDs() throws SQLException {
		stmt = con.createStatement();
		stmt.executeQuery("USE " + MYSQL_DATABASE_NAME);
		ResultSet rs = stmt.executeQuery("select match_ID from matches");
		ArrayList<Integer> answer = new ArrayList<Integer>();
		while(rs.next()){
			answer.add(rs.getInt("match_ID"));
		}
		stmt.close();
		return answer;
	}

}
