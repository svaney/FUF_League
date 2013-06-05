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
		return db.getTopScorers(champID);
	}

	/**
	 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
	 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
	 */
	@Override
	public List<Player> getAssists() {
		return db.getAssistants(champID);
	}

	/**
	 * აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
	 * @param player ობიექტი რომელიც გადაეცემა არის Player ტიპის და ასახავს რომელ მოტამაშეზე გვინდა.
	 * @return Goal ტიპის ობიექტების List
	 */
	@Override
	public List<Goal> getGoalsForPlayer(Player player) {
		ArrayList<Integer> goalIDs = (ArrayList<Integer>) db.getGoalsForPlayer(champID);
		ArrayList<Goal> answer = new ArrayList<Goal>();
		for(int i=0;i<goalIDs.size();i++){
			answer.add(new Goal_kire(goalIDs.get(i)));
		}
		return answer;
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
	 */
	@Override
	public List<Player> getMostYellows() {
		return setPlayersFromIDs((ArrayList<Integer>) db.getMostYellows(champID));
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
	 */
	@Override
	public List<Player> getMostReds() {
		return setPlayersFromIDs((ArrayList<Integer>) db.getMostReds(champID));
	}

	/**
	 * გადაცემული ID-ებიდან, ქმნის Player ობიექტების ArrayList-ს 
	 * @param players ArrayList<Integer> ID-ების ჩამონათვალი
	 * @return აბრუნებს ArrayList<Player> ობიექტს
	 */
	private ArrayList<Player> setPlayersFromIDs(ArrayList<Integer> players){
		ArrayList<Player> result = new ArrayList<Player>();
		for(int i=0;i<players.size();i++){
			result.add(new Player_DEO(players.get(i)));
		}
		return result;
	}
}
