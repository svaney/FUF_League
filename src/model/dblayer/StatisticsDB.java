/**
 * File: MatchDB.java
 * type: interface
 * @author Data
 * -------------------------
 * ახორციელებს ყველა იმ მოთხოვნის დამუშავებას რაც ექნება Statistic კლასს mainclasses-დან 
 */
package model.dblayer;

import java.util.List;

import model.mainclasses.Player;

public interface StatisticsDB {

	/**
	 * აბრუნებს ჩემპიონატის ბომბარდირებს.
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტების List, გოლების კლებადობითაა დალაგებული მოთამაშეები
	 */
	List<Player> getTopScorers(int champID);

	/**
	 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
	 */
	List<Player> getAssistants(int champID);

	/**
	 *  აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Goal ტიპის ობიექტების List
	 */
	List<Integer> getGoalsForPlayer(int champID);

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
	 */
	List<Integer> getMostYellows(int champID);

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
	 * @param champID ჩემპიონატის იდენტიფიკატორი
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
	 */
	List<Integer> getMostReds(int champID);

}
