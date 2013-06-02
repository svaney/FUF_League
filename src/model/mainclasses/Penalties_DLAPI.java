/**
 * File: Penalties_DLAPI
 * type: class
 * @author Data
 * ---------------
 * ეს არის Penalties ინტერფეისის იმპლემენტაცია 
 */
package model.mainclasses;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dblayer.MatchDB;
import model.dblayer.MatchDB_DLAPI;

public class Penalties_DLAPI implements Penalties{

	// DataBase instance 
	private MatchDB mtBase;
			
	// სხვა private ცვლადები
	private int matchID;
	
	/**
	 * კონსტრუტორი
	 * @param matchID გადაეცემა მატჩის საიდენტიფიკაციო პარამეტრი
	 */
	public Penalties_DLAPI(int matchID){
		mtBase = new MatchDB_DLAPI();
		this.matchID = matchID;
	}
	
	/**
	 * კონსტრუქტორი, რომელსაც ასევე გადაეცემა ბაზასთან კონტაქტორის ობიექტი
	 * @param matchID მატცის იდენტიფიკატორი
	 * @param mtBase ბაზასთან კონტაქტორის ობიექტი
	 */
	public Penalties_DLAPI(int matchID, MatchDB mtBase){
		this.mtBase = mtBase;
		this.matchID = matchID;
	}
	
	/**
	 * აბრუნებს პენლების სერიის შედეგს ერთი გუნდისთვის 
	 * @param teamID გუნდის საიდენტიფიკაციო ID
	 * @return ArrayList რომელშიც არის PenaltyShoot კლასის ობიექტები 
	 */
	@Override
	public ArrayList<PenaltyShoot> getTeamsSerie(int teamID) {
		try {
			return (ArrayList<PenaltyShoot>) mtBase.getTeamPenalties(teamID,matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * რამდენი გაიტანა გუნდმა ამ სერიაში
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი გაიტანა გუნდმა ამ სერიაში 
	 */
	@Override
	public int getTeamScore(int teamID) {
		try {
			return mtBase.getTeamsScoresInPenalties(teamID,matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * რამდენი ააცდინა გუნდმა
	 * @param teamID გუნდის მაიდენტიფიცირებელი
	 * @return int ტიპის მნიშვნელობა, რამდენი ააცდინა გუნდმა ამ სერიაში 
	 */
	@Override
	public int getTeamMissedQuantity(int teamID) {
		try {
			return mtBase.getTeamsMissedInPenalties(teamID,matchID);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
