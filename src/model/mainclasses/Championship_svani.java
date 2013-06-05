package model.mainclasses;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dblayer.ChampDB;
import model.dblayer.ChampDB_svani;

public class Championship_svani implements Championship{
	private ChampDB champDB;
	private String champType;
	private Date startDate;
	private Date endDate;
	private int champID;
	
	public Championship_svani(String type, Date startDate) {
		this.champType = type;
		this.startDate = startDate;
		this.endDate = null;
		this.champDB = new ChampDB_svani();
		try {
			this.champID = champDB.addChampionship(type, startDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Championship_svani(int champID){
		// aq udna bazastan kavshiri da ikidan amogeba????
	}

	@Override
	public int getChampID() {
		return this.champID;
	}

	@Override
	public String getChampType() {
		return this.champType;
	}

	@Override
	public void setChampType(String type) {
		try {
			this.champDB.setChampionshipType(type, this.champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setStartDate(Date startDate) {
		try {
			this.champDB.setStartDate(startDate, this.champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Date getStartDate() {
		return this.startDate;
	}

	@Override
	public Team getTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeam(int teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTeamCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTeamCountInGroup(String groupName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group getGroup(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getGroup(int groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Match> getPlayoffMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getChampionTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		
		try {
			this.champDB.setEndDate(endDate, champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Date getEndDate() {
		return this.endDate;
	}

}
