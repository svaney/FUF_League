package model.mainclasses;

import java.sql.SQLException;

import model.dblayer.GoalDB;
import model.dblayer.GoalDB_kire;
import model.dblayer.MatchDB;

public class Goal_kire implements Goal {
	private GoalDB gt;
	private int goalID;
	
	
	/*კონსტრუქტორი*/
	public Goal_kire(int goalID){
		this.goalID=goalID;
		gt = new GoalDB_kire();
	}
	
	public Goal_kire(Player scorer, Team team, Match match, boolean isAuto){
		gt = new GoalDB_kire();
		try {
			goalID = gt.createGoal(scorer.getPlayerID(), team.getID(), match.getMatchID(), isAuto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getGoalId() {
		return goalID;
	}
	
	@Override
	public Player getPlayer() {
		int playerID;
		try {
			playerID = gt.getPlayerID(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return new Player_DEO(playerID);
	}
	
	@Override
	public Match getMatch() {
		int matchID;
		try {
			matchID = gt.getMatchID(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return new Match_DLAPI(matchID);
	}
	
	@Override
	public Player getAssist() {
		int playerID;
		try {
			playerID = gt.getAssistID(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return new Player_DEO(playerID);
	}
	
	@Override
	public boolean isPenalty() {
		try {
			return gt.isPenalty(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean inExtra() {
		try {
			return gt.isInExtra(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean isAuto() {
		try {
			return gt.isAutoGoal(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @return თუ უცნობია რომელ პერიოდში გავიდა მაშინ 0-ს აბრუნებს
	 */
	@Override
	public int whichHalf() {
		try {
			return gt.getHalfTime();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int queNumber() {
		try {
			return gt.getInRow();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public Team getTeam() {
		int teamID;
		try {
			teamID = gt.getTeamID(goalID);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return new Team_Ruska(teamID);
	}
	
	@Override
	public void setPlayer(Player scorer) {
		try {
			gt.setScorer(goalID,scorer.getPlayerID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setMatch(Match mt) {
		try {
			gt.setMatchID(goalID,mt.getMatchID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setAssist(Player assist) {
		try {
			gt.setAssist(goalID,assist.getPlayerID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPenalty(boolean isPenalty) {
		char c;
		if(isPenalty){
			c = 'Y';
		} else {
			c = 'N';
		}
		try {
			gt.setPenalty(goalID,c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setExtra(boolean inExtra) {
		char c;
		if(inExtra){
			c = 'Y';
		} else {
			c = 'N';
		}
		try {
			gt.setExtra(goalID,c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setAuto(boolean isAuto) {
		try {
			char c;
			if(isAuto){
				c = 'Y';
			} else {
				c = 'N';
			}
			gt.setAuto(goalID,c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setTeam(Team tm) {
		try {
			gt.setTeam(goalID,tm.getID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
