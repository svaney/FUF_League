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

import java.util.List;

public class Statistics_DLAPI implements Statistics{
	
	//private variables
	private int champID;
	
	/**
	 * კონსტრუქტორი რომელიც ქმნის Statistic კლასს ჩემპიონატის ID-დან, ანუ უკვე არსებულ ჩემპიონატზეა საუბარი
	 * @param champID ჩემპიონატის იდენტიფიკატორი - ID
	 */
	public Statistics_DLAPI(int champID){
		this.champID = champID;
	}
	
	/**
	 * აბრუნებს ჩემპიონატის ბომბარდირებს.
	 * @return Player ტიპის ობიექტების List, გოლების კლებადობითაა დალაგებული მოთამაშეები
	 */
	@Override
	public List<Player> getTopScorers() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს ჩემპიონატის მონაწილეთა სიას, რომლებმაც ყველაზე მეტი საგოლე გადაცემა გააკეთეს
	 * @return Player ტიპის ობიექტების List, ასისტების კლებადობითაა დალაგებული მოთამაშეები
	 */
	@Override
	public List<Player> getAssists() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს ჩემპიონატის განმავლობაში მოთამაშის მიერ გატანილ გოლებს, თანმიმდევრობით (თარიღების მიხედვით). არ ითვლება საკუთარ კარში გატანილი გოლები
	 * @param player ობიექტი რომელიც გადაეცემა არის Player ტიპის და ასახავს რომელ მოტამაშეზე გვინდა.
	 * @return Goal ტიპის ობიექტების List
	 */
	@Override
	public List<Goal> getGoalsForPlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო ყვითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი ყვითელი აქვს
	 */
	@Override
	public List<Player> getMostYellows() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * აბრუნებს სიას სადაც წერია ვინ მიიღო წითელი ბარათები ჩემპიონატის განავლობაში
	 * @return Player ტიპის ობიექტები, რომლებიც დალაგებულია იმის კლებადობით თუ ვის რამდენი წითელი აქვს
	 */
	@Override
	public List<Player> getMostReds() {
		// TODO Auto-generated method stub
		return null;
	}

}
