package model.mainclasses;

import java.sql.Date;
import java.util.ArrayList;

public class Championship_svani implements Championship{
	private String champType;
	private Date startDate;
	private Date endDate;
	
	public Championship_svani(String type, Date startDate, Date endDate) {
		this.champType = type;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Championship_svani(int id){
		// aq udna bazastan kavshiri da ikidan amogeba????
	}

	@Override
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTeams(ArrayList<Team> teams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTeamCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Team getTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createGroups() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group getGroup(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endChamp() {
		// TODO Auto-generated method stub
		
	}


}
