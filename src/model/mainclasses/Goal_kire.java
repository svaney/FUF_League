package model.mainclasses;

import java.sql.SQLException;

import model.dblayer.GoalDB;
import model.dblayer.GoalDB_kire;
import model.dblayer.MatchDB;

public class Goal_kire implements Goal {
	private GoalDB gt;
	private int goalID;
	private Player scorer;
	private Player assist;
	private Match match;
	private int whichHalf=0;
	private boolean inExtra;
	private boolean isAuto;
	private boolean isPenalty;
	private int queNumber;
	private Team team;
	
	/*კონსტრუქტორი*/
	public Goal_kire(int goalID){
		this.goalID=goalID;
		gt = new GoalDB_kire();
	}
	
	public Goal_kire(Player scorer, Team team, Match match, boolean isAuto){
		this.scorer=scorer;
		this.team=team;
		this.match=match;
		this.isAuto=isAuto;
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
		int playerID = gt.getPlayerID(goalID);
		return new Player_DEO(playerID);
	}
	
	@Override
	public Match getMatch() {
		int matchID = gt.getMatchID(goalID);
		return new Match_DLAPI(matchID);
	}
	
	@Override
	public Player getAssist() {
		int playerID = gt.getAssistID(goalID);
		return assist;
	}
	
	@Override
	public boolean isPenalty() {
		return gt.isPenalty(goalID);
	}
	
	@Override
	public boolean inExtra() {
		return gt.isInExtra(goalID);
	}
	
	@Override
	public boolean isAuto() {
		return gt.isAutoGoal(goalID);
	}
	
	@Override
	public int whichHalf() {
		return gt.getHalfTime();
	}
	
	@Override
	public int queNumber() {
		return gt.getInRow();
	}
	
	@Override
	public Team getTeam() {
		int teamID = gt.getTeamID(goalID);
		return new Team_Ruska(teamID);
	}
	
	@Override
	public void setPlayer(Player scorer) {
		this.scorer=scorer;
		gt.setScorer(goalID,scorer.getPlayerID());
	}
	
	@Override
	public void setMatch(Match mt) {
		match=mt;
		gt.setMatchID(goalID,mt.getMatchID());
	}
	
	@Override
	public void setAssist(Player assist) {
		this.assist=assist;
		gt.setAssist(goalID,assist.getPlayerID());
	}
	
	@Override
	public void setPenalty(boolean isPenalty) {
		this.isPenalty=isPenalty;
		char c;
		if(inExtra){
			c = 'Y';
		} else {
			c = 'N';
		}
		gt.setPenalty(goalID,c);
	}
	
	@Override
	public void setExtra(boolean inExtra) {
		this.inExtra=inExtra;
		char c;
		if(inExtra){
			c = 'Y';
		} else {
			c = 'N';
		}
		gt.setExtra(goalID,c);
	}
	@Override
	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
		gt.setAuto(goalID);
	}
	@Override
	public void setTeam(Team tm) {
		team=tm;
		gt.setTeam(goalID,tm);
	}
	
}
