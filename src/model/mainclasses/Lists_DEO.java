package model.mainclasses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dblayer.ListsDB;
import model.dblayer.ListsDB_DEO;

public class Lists_DEO{

	/**
	 * ყველა მოთამაშის მისამართი და სახელი მასივის სახით. მასივი[ID][სახილი];
	 * @return
	 */
	public static String[][] players() {
		ListsDB_DEO players = new ListsDB_DEO();
		return players.listAllPlayers();
	}

	/**
	 * ყველა გუნდის მისამართი და სახელი მასივის სახით. მასივი[ID][სახილი];
	 * @return
	 */
	public static String[][] teams() {
		ListsDB_DEO teams = new ListsDB_DEO();
		return teams.listAllTeams();
	}

	/**
	 * მოთამაშის პოზიციების სიას მასივის სახით.
	 * @return
	 */
	public static String[] positions() {
		ListsDB_DEO positions = new ListsDB_DEO();
		return positions.listAllPositions();
	}

	/**
	 * ჩემპიონატის ტიპების სია მასივის სახით.
	 * @return
	 */
	public static String[] types() {
		ListsDB_DEO types = new ListsDB_DEO();
		return types.listAllTypes();
	}
	
	/**
	 * აბრუნებს მატჩების ჩამონათვალს
	 * @return Match ობიექტების List
	 * @author Data
	 */
	public static ArrayList<Match> getAllMatches(){
		ListsDB lists = new ListsDB_DEO();
		ArrayList<Integer> matchIDs = new ArrayList<Integer>();
		try {
			matchIDs = (ArrayList<Integer>) lists.getMatchIDs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Match>)Converter.setMatchesFromIDs(matchIDs);
	}

}
