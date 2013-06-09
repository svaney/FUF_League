/**
 * File: StatisticsDB_DLAPI.java
 * type: class
 * @author Data
 * -------------------------
 * StatisticsDB ინტერფეისის იმპლემენტაცია
 */
package model.dblayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.mainclasses.Converter;
import model.mainclasses.Goal;
import model.mainclasses.Player;

public class StatisticsDB_DLAPI implements StatisticsDB{
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
		public StatisticsDB_DLAPI(){
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
		 * აბრუნებს ჩემპიონატის ბომბარდირებს.
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტების List, გოლების კლებადობითაა დალაგებული მოთამაშეები
		 * @throws SQLException 
		 */
		@Override
		public List<Player> getTopScorers(int champID) throws SQLException {
			return getFromQueryPlayers("select player_id, count(goal_id) as numberOfGoals from goals where match_id in (select match_id from matches  where championship_id = "+champID+") and auto_goal='N' group by player_idorder by numberOfGoals desc;");
		}
		
		/**
		 * გვიბრუნებს მოთამაშეების სიას, ისე რომ ამუშავებს ცხრილებს query-ს საშუალებით
		 * @param query string რომელშიც წერია sql statement
		 * @return ArrayList<Player> ობიექტი
		 * @throws SQLException
		 */
		private ArrayList<Player> getFromQueryPlayers(String query) throws SQLException{
			startUpStatement();
			rs = st.executeQuery("query");
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while(rs.next()){
				ids.add(rs.getInt("player_id"));
			}
			ArrayList<Player> answer = (ArrayList<Player>) Converter.setPlayersFromIDs(ids);
			st.close();
			return answer;
		}

		/**
		 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
		 * @throws SQLException 
		 */
		@Override
		public List<Player> getAssistants(int champID) throws SQLException {
			return getFromQueryPlayers("select assistant_id, count(goal_id) as numberOfGoals from goals where match_id in (select match_id from matches where championship_id = 4) and assistant_id<>null and auto_goal='N'group by assistant_id order by numberOfGoals desc;");
		}

		/**
		 *  აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Integer ტიპის ობიექტების List
		 * @throws SQLException 
		 */
		@Override
		public List<Integer> getGoalIDsForPlayer(int champID, Player pl) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select goal_id from goals inner join matches on goals.match_id=matches.match_id where  player_id="+pl.getPlayerID()+" and auto_goal='N' and matches.championship_id="+champID+"  order by matches.match_date asc, goals.inrow asc;");
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while(rs.next()){
				ids.add(rs.getInt("goal_id"));
			}
			st.close();
			return ids;
		}

		/**
		 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
		 * @throws SQLException 
		 */
		@Override
		public List<Integer> getMostYellows(int champID) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select player_id, count(yellow_id) as total from yellows inner join matches on yellows.match_id=matches.match_id where matches.championship_id ="+champID+" group by player_id order by total desc;");
			ArrayList<Integer> ans = new ArrayList<Integer>();
			while(rs.next()){
				ans.add(rs.getInt("player_id"));
			}
			st.close();
			return ans;
		}

		/**
		 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
		 * @throws SQLException 
		 */
		@Override
		public List<Integer> getMostReds(int champID) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select player_id, count(red_id) as total from reds inner join matches on reds.match_id=matches.match_id where matches.championship_id ="+champID+" group by player_id order by total desc;");
			ArrayList<Integer> ans = new ArrayList<Integer>();
			while(rs.next()){
				ans.add(rs.getInt("player_id"));
			}
			st.close();
			return ans;
		}

		/**
		 * აბრუნებს რამდენი ყვითელი მიიღო მოთამაშემ
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @param player მოთამაშის იდენტიფიკატორი
		 * @return რაოდენობა int
		 * @throws SQLException 
		 */
		@Override
		public int getYellowsForPlayer(int champID, Player player) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select count(yellow_id) as total from yellows inner join matches on yellows.match_id=matches.match_id where matches.championship_id ="+champID+" and player_id="+player.getPlayerID()+";");
			rs.next();
			int ans = rs.getInt("total");
			st.close();
			return ans;
		}

		/**
		 * აბრუნებს რამდენი წითელი მიიღო მოთამაშემ
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @param player მოთამაშის იდენტიფიკატორი
		 * @return რაოდენობა int
		 * @throws SQLException 
		 */
		@Override
		public int getRedsForPlayer(int champID, Player player) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select count(red_id) as total from reds inner join matches on reds.match_id=matches.match_id where matches.championship_id ="+champID+" and player_id="+player.getPlayerID()+";");
			rs.next();
			int ans = rs.getInt("total");
			st.close();
			return ans;
		}

		/**
		 * აბრუნებს რამდენი წითელი მიიღო მოთამაშემ ჩემპიონატის განმავლობაში იმის გამო რომ ყვითელი გაუორმაგდა
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @param player მოთამაშის იდენტიფიკატორი
		 * @return რაოდენობა int
		 * @throws SQLException 
		 */
		@Override
		public int getRedsFromTwoYellowsForPlayer(int champID, Player player) throws SQLException {
			startUpStatement();
			rs = st.executeQuery("select count(a.mm) as total from(select match_id as mm from yellows inner join matches on yellows.match_id=matches.match_id  where player_id="+player.getPersonID()+" and matches.championship_id="+champID+" group by match_idhaving count(match_id)>1) as a;");
			rs.next();
			int ans = rs.getInt("total");
			st.close();
			return ans;
		}

}
