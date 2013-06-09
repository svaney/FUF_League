/**
 * File: Statistics.java
 * type: class
 * @author Data
 * -----------------
 * აქ იქნება სტატისტიკა. მას ექნება როგორც static მეთოდები (რომლებიც საერთო სტატისტიკურ მონაცემებს მოგვცემს.)
 * ასევე ჩვეულებრივი, ობიექტთან ასოცირებული მეთოდები. ამ კლასის ობიექტები უნდა გააჩნდეს Championship-კლასს.
 * ეს კლასი არაფერს ცვლის ბაზაში. ის მხოლოდ ინფორმაციას ამუშავებს.
 */
package model.mainclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dblayer.StatisticsDB;
import model.dblayer.StatisticsDB_DLAPI;

public class Statistics_DLAPI implements Statistics{
	
	//DataBase instance
	private StatisticsDB db;
	
	//private variables
	private int champID;
	
	/**
	 * კონსტრუქტორი რომელიც ქმნის Statistic კლასს ჩემპიონატის ID-დან, ანუ უკვე არსებულ ჩემპიონატზეა საუბარი
	 * @param champID ჩემპიონატის იდენტიფიკატორი - ID
	 */
	public Statistics_DLAPI(int champID){
		this.champID = champID;
		db = (StatisticsDB) new StatisticsDB_DLAPI();
	}
	
	/**
	 * აბრუნებს ჩემპიონატის ბომბარდირებს.
	 * @return Player ტიპის ობიექტების List, გოლების კლებადობითაა დალაგებული მოთამაშეები
	 */
	@Override
	public List<Player> getTopScorers() {
		try {
			return db.getTopScorers(champID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
	 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
	 */
	@Override
	public List<Player> getAssists() {
		try {
			return db.getAssistants(champID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
	 * @param player ობიექტი რომელიც გადაეცემა არის Player ტიპის და ასახავს რომელ მოტამაშეზე გვინდა.
	 * @return Goal ტიპის ობიექტების List
	 */
	@Override
	public List<Goal> getGoalsForPlayer(Player player) {
		ArrayList<Integer> goalIDs;
		try {
			goalIDs = (ArrayList<Integer>) db.getGoalIDsForPlayer(champID, player);
		} catch (SQLException e) {
			e.printStackTrace();
			goalIDs = null;
		}
		return Converter.setGoalsFromIDs(goalIDs);
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
	 */
	@Override
	public List<Player> getMostYellows() {
		try {
			return Converter.setPlayersFromIDs((ArrayList<Integer>) db.getMostYellows(champID));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
	 */
	@Override
	public List<Player> getMostReds() {
		try {
			return Converter.setPlayersFromIDs((ArrayList<Integer>) db.getMostReds(champID));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * აბრუნებს რამდენი ყვითელი მიიღო მოთამაშემ ჩემპიონატის განმავლობაში
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა
	 */
	@Override
	public int howManyYellows(Player player) {
		try {
			return db.getYellowsForPlayer(champID,player);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * აბრუნებს რამდენი წითელი მიიღო მოთამაშემ ჩემპიონატის განმავლობაში
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა
	 */
	@Override
	public int howManyReds(Player player) {
		try {
			return db.getRedsForPlayer(champID,player);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * აბრუნებს რამდენი წითელი მიიღო ორი ყვითელის გამო მოთამაშემ ჩემპიონატის განმავლობაში
	 * @param player მოთამაშის იდენტიფიკატორი
	 * @return რაოდენობა
	 */
	@Override
	public int howManyRedsFromTwoYellows(Player player) {
		try {
			return db.getRedsFromTwoYellowsForPlayer(champID,player);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
