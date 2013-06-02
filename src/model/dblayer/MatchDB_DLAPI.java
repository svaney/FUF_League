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
		
		st.close();
	
		return null;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return null;
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
		
		st.close();
		return null;
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
		
		st.close();
		return null;
	}

	/**
	 * აბრუნებს ჰქონდა თუ არა მატჩს პენლების სერია
	 * @param  matchID მატჩის იდენტიფიკატორი
	 * @return char ტიპის ობიექტი - 'Y'(YES) ან  'N'(NO)
	 * @throws SQLException 
	 */
	@Override
	public char hasPenalties(int matchID) throws SQLException {
		startUpStatement();
		
		st.close();
		return 0;
	}

	/**
	 * აბრუნებს იყო თუ არა პენლების სერია
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @return true თუ იყო, false თუ არ იყო
	 * @throws SQLException 
	 */
	@Override
	public boolean wasPenaltiesSerie(int matchID) throws SQLException {
		startUpStatement();
		
		st.close();
		return false;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return null;
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
		
		st.close();
		return 0;
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
		
		st.close();
		return 0;
	}
	
	
}
