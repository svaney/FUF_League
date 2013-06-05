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
import java.util.List;

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
		 */
		@Override
		public List<Player> getTopScorers(int champID) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
		 */
		@Override
		public List<Player> getAssistants(int champID) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 *  აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Goal ტიპის ობიექტების List
		 */
		@Override
		public List<Integer> getGoalsForPlayer(int champID) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
		 */
		@Override
		public List<Integer> getMostYellows(int champID) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
		 * @param champID ჩემპიონატის იდენტიფიკატორი
		 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
		 */
		@Override
		public List<Integer> getMostReds(int champID) {
			// TODO Auto-generated method stub
			return null;
		}

}
