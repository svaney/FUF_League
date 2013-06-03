/**
 * File: MatchDB_DLAPI.java
 * type: class
 * @author Data
 * -------------------------
 * MatchDB ინტერფეისის იმპლემენტაცია
 */

package model.dblayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.mainclasses.PenaltyShoot;

public class MatchDB_DLAPI implements MatchDB{
	// ბაზის პარამეტრები
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	private ResultSet rs;
	private Connection con;
	private Statement st;
	
	
	/**
	 * კონსტრუქტორი, რომელშიც ხდება ბაზასთან კონექშენის დამყარება.
	 */
	public MatchDB_DLAPI(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"
					+ MYSQL_DATABASE_SERVER, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * სტარტავს statement ცვლადს და ეუბნება რომელი ბაზა გამოიყენოს
	 * @throws SQLException 
	 */
	private void startUpStatement() throws SQLException{
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
	}
	
	/**
	 * გვეუბნება რომელი ტურია ჩემპიონატის
	 * @param matchID გუნდის იდენტიფიკატორი
	 * @return String ტიპის პარამეტრი - რაუნდი, ეტაპი
	 * @throws SQLException 
	 */
	@Override
	public String getStageOfMatch(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select stage from matches where match_id = '"+matchID+"';");
		rs.next();
		String answer = rs.getString("stage");
		st.close();
		return answer;
	}

	/**
	 * გვეუბნება მატჩს რამდენი ჰქონდა დამატებით დრო (თუ არ ჰქონდა მაშინ 0)
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return წთ-ებში გამოსახული დრო
	 * @throws SQLException 
	 */
	@Override
	public int getExtraTime(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select extra_time from matches where match_id = '"+matchID+"';");
		rs.next();
		int answer = rs.getInt("extra_time");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს მატჩის ჩატარების თარიღს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return String ტიპის თარიღი
	 * @throws SQLException 
	 */
	@Override
	public Date getMatchDate(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select match_date from matches where match_id = '"+matchID+"';");
		rs.next();
		Date answer = rs.getDate("match_date");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს კონკრეტულ მატჩზე, კონკრეტული გუნდის განაცხადს, List-ის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც ყრია Integer ტიპის მაიდენტიფიცირებელი კოდები თითოეული მოთამაშისთვის
	 * @throws SQLException 
	 */
	@Override
	public List<Integer> getMatchPlayersForTeam(int matchID, int teamID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select player_id from match_players where team_id='"+teamID+"' and match_id='"+matchID+"';");
		ArrayList<Integer> answer = new ArrayList<Integer>();
		while(rs.next()){
			answer.add(rs.getInt("player_id"));
		}
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს მატჩის მონაწილე ორი გუნდის ID-ებს მასივის სახით
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის ორელემენტიანი მასივი, რომელშიც მოცემულია მატჩის მონაწილე გუნდების ID-ები
	 * @throws SQLException 
	 */
	@Override
	public int[] getMatchTeams(int matchID) throws SQLException {
		startUpStatement();
		int[] answer = new int[2];
		rs = st.executeQuery("select team1_id, team2_id from matches where match_id='"+matchID+"';");
		rs.next();
		answer[0] = rs.getInt("team1");
		answer[1] = rs.getInt("team2");
		st.close();
		return null;
	}

	/**
	 * აბრუნებს მოცემულ მატჩზე მოცემული გუნდის კაპიტანს, თუ ასეთი არ არსებობს აბრუნებს -1_ს (ანუ default კაპიტანი ჰყავდათ)
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return აბრუნებს int ტიპის ცვლადს, თუ გუნდის კაპიტანი არ იყო default ანუ null არ იყო მაშინ აბრუნებს ID-ს 
	 * წინააღმდეგ შემთხვევაში აბრუნებს -1_ს
	 * @throws SQLException 
	 */
	@Override
	public int getCapForMatchTeam(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select player_id from match_caprains where match_id='"+matchID+"' and team_id='"+teamID+"';");
		rs.next();
		int answer = rs.getInt("player_id");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს მოცემული მატჩის შესახებ ინფორმაციას - რომელ ჩემპიონატზე ჩატარდა
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return int ტიპის იდენტიფიკატორი
	 * @throws SQLException 
	 */
	@Override
	public int getChampionshipID(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select championship_id from matches where match_id='"+matchID+"';");
		rs.next();
		int answer = rs.getInt("championship_id");
		st.close();
		return answer;
	}

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს ყვითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 * @throws SQLException 
	 */
	@Override
	public List<Integer> getYellowsForTeamInMatch(int matchID, int teamID) throws SQLException {
		startUpStatement();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		rs = st.executeQuery("select player_id from yellows where match_id='"+matchID+"' and team_id='"+teamID+"';");
		while(rs.next()){
			answer.add(rs.getInt("player_id"));
		}
		st.close();
		return answer;
	}

	/**
	 * კონკრეტულ მატჩზე გუნდის რომელმა წევრებმა მიიღეს წითელი ბარათები
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID int ტიპის მაიდენტიფიცირებელი - გუნდის
	 * @return List ტიპის ობიექტი სადაც წერია მოთამაშეების ID-ები
	 * @throws SQLException 
	 */
	@Override
	public List<Integer> getRedsForTeamInMatch(int matchID, int teamID) throws SQLException {
		startUpStatement();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		rs = st.executeQuery("select player_id from reds where match_id='"+matchID+"' and team_id='"+teamID+"';");
		while(rs.next()){
			answer.add(rs.getInt("player_id"));
		}
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს მატჩზე დაწერილ რევიუს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return სტრინგ ტიპის ობიექტი სადაც წერია ტექსტი.
	 * @throws SQLException 
	 */
	@Override
	public String getReview(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select review from matches where match_id = '"+matchID+"';");
		rs.next();
		String answer = rs.getString("review");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს იყო თუ არა პენლების სერია
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return true თუ იყო, false თუ არ იყო
	 * @throws SQLException 
	 */
	@Override
	public boolean hasPenalties(int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select penalties from matches where match_id = '"+matchID+"';");
		rs.next();
		boolean answer = rs.getString("penalties").charAt(0)=='Y';
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს კონკრეტულ მატჩზე გუნდის გატანილ გოლებს ძირითად დროში
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @return რაოდენობა ძირითად დროში გატანილი გოლების
	 * @throws SQLException 
	 */
	@Override
	public int getScoreForTeamForFullTime(int matchID, int teamID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select count(*) as total from goals where match_id='"+matchID+"' and extra_time='N' and team_id='"+teamID+"';");
		rs.next();
		int answer = rs.getInt("total");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს იმ გოლის იდენტიფიკატორს, რომელიც გავიგე მე-N მატჩის განმავლობაში
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param nth მერამდენე
	 * @return გოლის იდენტიფიკატორი
	 * @throws SQLException 
	 */
	@Override
	public int getGoalNthInRow(int matchID, int Nth) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select goal_id from goals where match_id='"+matchID+"' and inrow='"+Nth+"';");
		rs.next();
		int answer = rs.getInt("goal_id");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს ამ გუნდის მიერ გატანილი გოლების რაოდენობას დამატებით დროში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return გოლების რაოდენობა
	 * @throws SQLException 
	 */
	@Override
	public int getExtraTimeGoalForTeam(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select count(*) as total from goals where match_id='"+matchID+"' and extra_time='Y' and team_id='"+teamID+"';");
		rs.next();
		int answer = rs.getInt("total");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს გუნდის მიერ მატჩში - პირველ ტაიმში გატანილ გოლების რაოდენობას
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return გოლების რაოდენობა
	 * @throws SQLException 
	 */
	@Override
	public int getScoreForTeamFirstHalf(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select count(*) as total from goals where match_id='"+matchID+"' and half=1 and team_id='"+teamID+"';");
		rs.next();
		int answer = rs.getInt("total");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს გუნდის მიერ პენლების სერიის შედეგს
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return List სადაც წერია PenaltyShoot ტიპის ობიექტები.
	 * @throws SQLException 
	 */
	@Override
	public List<PenaltyShoot> getTeamPenalties(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select * from penalties where match_id='"+matchID+"' and team_id='"+teamID+"';");
		ArrayList<PenaltyShoot> answer = new ArrayList<PenaltyShoot>();
		while(rs.next()){
			answer.add(new PenaltyShoot(rs.getInt("match_id"), rs.getInt("team_id"), rs.getInt("turn"), rs.getInt("Player_id"), rs.getString("score").charAt(0)=='Y'));
		}
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს რამდენი გაიტანა გუნდმა პენლების სერიაში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return რაოდენობა
	 * @throws SQLException 
	 */
	@Override
	public int getTeamsScoresInPenalties(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select count(*) as total from penalties where match_id='' and team_id='' and score='Y';");
		rs.next();
		int answer = rs.getInt("total");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს რამდენი ვერ გაიტანა გუნდმა პენლების სერიაში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return რაოდენობა
	 * @throws SQLException 
	 */
	@Override
	public int getTeamsMissedInPenalties(int teamID, int matchID) throws SQLException {
		startUpStatement();
		rs = st.executeQuery("select count(*) as total from penalties where match_id='' and team_id='' and score='N';");
		rs.next();
		int answer = rs.getInt("total");
		st.close();
		return answer;
	}

	/**
	 * აბრუნებს ჩემპიონატის რაუნდების სიას
	 * @return List რომელშიც შევსებულია Integer ობიექტებით.
	 */
	@Override
	public List<Integer> getStageIDList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ქმნის მატჩს მოცემული პარამეტრებით
	 * @param team1_ID პირველი გუნდის იდენტიფიკატორი
	 * @param team2_ID მეორე გუნდის იდენტიფიკატორი
	 * @param championship_ID ჩემპიონატის ID
	 * @param stage_ID რაუნდის ID
	 * @return matchID მატჩის იდენტიფიკატორი
	 */
	@Override
	public int setMatch(int team1_ID, int team2_ID, int championship_ID,
			int stage_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * ამატებს, ან ცვლის მატჩის რაუნდს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param stageID რაუნდის იდენტიფიკატორი
	 */
	@Override
	public void setMatchStage(int matchID, int stageID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს ჰქონდა თუ არა დამატებითი დრო
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param extra true თუ ჰქონდა, false წინააღმდეგ შემთხვევაში
	 */
	@Override
	public void setExtraTimeForMatch(int matchID, boolean extra) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს თარიღს როდესაც ჩატარდა მატჩი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param date თარიღი sql.date ტიპის
	 */
	@Override
	public void setDateForMatch(int matchID, Date date) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ამატებს მატჩის განაცხადში მოთამაშეს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	@Override
	public void setLineUpPlayer(int matchID, int teamID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ამატებს ან ცვლის მატჩის მოთამაშე გუნდებს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param team1id გუნდის იდენტიფიკატორი
	 * @param team2id გუნდის იდენტიფიკატორი
	 */
	@Override
	public void setTeamsInMatch(int matchID, int team1id, int team2id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს გუნდის კაპიტანს მოცემული მატჩისთვის
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	@Override
	public void setCaptainForMatch(int matchID, int teamID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს ფეხბურთელს რომელმაც მატჩზე მიიღო ყვითელი ბარათი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	@Override
	public void setYellowForPlayerInMatch(int matchID, int teamID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს ფეხბურთელს რომელმაც მატჩზე მიიღო ყვითელი ბარათი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param playerID მოთამაშის იდენტიფიკატორი
	 */
	@Override
	public void setRedForPlayerInMatch(int matchID, int teamID, int playerID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს მატჩის შესახებ სტატიას
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param review მიმოხილვა ტექსტის სახით
	 */
	@Override
	public void setMatchReview(int matchID, String review) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * წერს ჩემპიონატის ID-ს
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param championship_ID ჩემპიონატის იდენტიფიკატორი
	 */
	@Override
	public void setChampionship(int matchID, int championship_ID) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * პენლის ერთი დარტყმის ჩაწერა
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param playerID დამრტყმელის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param turnOfTeam მერამდენე პენალი იყო
	 * @param hasScored თუ გაიტანა true თუ ვერა false
	 */
	@Override
	public void setPenaltyForTeam(int matchID, int playerID, int teamID,
			int turnOfTeam, boolean hasScored) {
		// TODO Auto-generated method stub
		
	}
	
}
