package model.mainclasses;

import model.dblayer.MatchDB;

public class Goal_kire implements Goal {
	private MatchDB mt;
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
	}
	public Goal_kire(int goalID, MatchDB mt){
		this.goalID=goalID;
		this.mt=mt;
	}
	public Goal_kire(Player scorer, Team team, Match match, boolean isAuto){
		this.scorer=scorer;
		this.team=team;
		this.match=match;
		this.isAuto=isAuto;
		mt.createGoal(scorer.getPlayerID(), team.getID(), match.getMatchID(), isAuto);
	}
	
	@Override
	public int getGoalId() {
		// TODO Auto-generated method stub
		return goalID;
	}
	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return scorer;
	}
	@Override
	public Match getMatch() {
		// TODO Auto-generated method stub
		return match;
	}
	@Override
	public Player getAssist() {
		// TODO Auto-generated method stub
		return assist;
	}
	@Override
	public boolean isPenalty() {
		// TODO Auto-generated method stub
		return isPenalty;
	}
	@Override
	public boolean inExtra() {
		// TODO Auto-generated method stub
		return inExtra;
	}
	@Override
	public boolean isAuto() {
		// TODO Auto-generated method stub
		return isAuto;
	}
	@Override
	public int whichHalf() {
		// TODO Auto-generated method stub
		return whichHalf;
	}
	@Override
	public int queNumber() {
		// TODO Auto-generated method stub
		return queNumber;
	}
	@Override
	public Team getTeam() {
		// TODO Auto-generated method stub
		return team;
	}
	@Override
	public void setPlayer(Player scorer) {
		// TODO Auto-generated method stub
		this.scorer=scorer;
	}
	@Override
	public void setMatch(Match mt) {
		// TODO Auto-generated method stub
		match=mt;
	}
	@Override
	public void setAssist(Player assist) {
		// TODO Auto-generated method stub
		this.assist=assist;
	}
	@Override
	public void setPenalty(boolean isPenalty) {
		// TODO Auto-generated method stub
		this.isPenalty=isPenalty;
	}
	@Override
	public void setExtra(boolean inExtra) {
		// TODO Auto-generated method stub
		this.inExtra=inExtra;
	}
	@Override
	public void setAuto(boolean isAuto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTeam(Team tm) {
		// TODO Auto-generated method stub
		team=tm;
	}
	
}
