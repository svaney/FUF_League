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
			startUpStatement();
			rs = st.executeQuery("select player_id, count(goal_id) as numberOfGoals from goals where match_id in (select match_id from matches  where championship_id = "+champID+") group by player_idorder by numberOfGoals desc;");
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
			startUpStatement();
			
			st.close();
			return null;
		}

		/**
		 *  აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Goal ტიპის ობიექტების List
		 * @throws SQLException 
		 */
		@Override
		public List<Integer> getGoalsForPlayer(int champID) throws SQLException {
			startUpStatement();
			
			st.close();
			return null;
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
			
			st.close();
			return null;
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
			
			st.close();
			return null;
		}

}
