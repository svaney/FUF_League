/**
 * File: MatchDB.java
 * type: interface
 * @author Data
 * -------------------------
 * ახორციელებს ყველა იმ მოთხოვნის დამუშავებას რაც ექნება Statistic კლასს mainclasses-დან 
 */
package model.dblayer;

import java.sql.SQLException;
import java.util.List;

import model.mainclasses.Goal;
import model.mainclasses.Player;

public interface StatisticsDB {

	/**
	 * აბრუნებს ჩემპიონატის ბომბარდირებს.
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტების List, გოლების კლებადობითაა დალაგებული მოთამაშეები
	 * @throws SQLException 
	 */
	List<Player> getTopScorers(int champID) throws SQLException;

	/**
	 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
	 * @throws SQLException 
	 */
	List<Player> getAssistants(int champID) throws SQLException;

	/**
	 *  აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @param player 
	 * @return Integer ტიპის ობიექტების List
	 * @throws SQLException 
	 */
	List<Integer> getGoalIDsForPlayer(int champID, Player player) throws SQLException;

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
	 * @throws SQLException 
	 */
	List<Integer> getMostYellows(int champID) throws SQLException;

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
	 * @throws SQLException 
	 */
	List<Integer> getMostReds(int champID) throws SQLException;

	/**
	 * აბრუნებს რამდენი ყვითელი მიიღო მოთამაშემ
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა int
	 */
	int getYellowsForPlayer(int champID, Player player);

	/**
	 * აბრუნებს რამდენი წითელი მიიღო მოთამაშემ
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა int
	 */
	int getRedsForPlayer(int champID, Player player);

	/**
	 * აბრუნებს რამდენი წითელი მიიღო მოთამაშემ ჩემპიონატის განმავლობაში იმის გამო რომ ყვითელი გაუორმაგდა
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა int
	 */
	int getRedsFromTwoYellowsForPlayer(int champID, Player player);

}
