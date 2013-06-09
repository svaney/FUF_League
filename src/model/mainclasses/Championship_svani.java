package model.mainclasses;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dblayer.ChampDB;
import model.dblayer.ChampDB_svani;

public class Championship_svani implements Championship{
	private ChampDB champDB;
	private int champID;
	
	public Championship_svani(String type, Date startDate) {
		this.champDB = new ChampDB_svani();
		try {
			this.champID = this.champDB.addChampionship(type, startDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			this.champID = this.champDB.getChampID(type, startDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Championship_svani(int champID){
		this.champID = champID;
		this.champDB = new ChampDB_svani();
		
	}
	

	@Override
	public int getChampID() {
		return this.champID;
	}

	@Override
	public String getChampType() {
		String type = null;
		try {
			type = this.champDB.getChampType(this.champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
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
		Date temp = null;
		
		try {
			temp = this.champDB.getChampStartDate(this.champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
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
				
		try {
			this.champDB.setEndDate(endDate, champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Date getEndDate() {
		Date temp = null;

		try {
			temp = this.champDB.getChampEndDate(this.champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
