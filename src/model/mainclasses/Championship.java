package model.mainclasses;

import java.sql.Date;
import java.util.ArrayList;

public interface Championship {
	public int getChampID();
	public String getChampType();
	public void setChampType(String champType);
	public void setStartDate(Date startDate);
	public Date getStartDate(); 
	public Team getTeam(String teamName);
	public Team getTeam(int teamID);
	public int getTeamCount();
	public ArrayList<Team> getAllTeams();
	public void addGroup(Group group);
	public Group getGroup(String groupName);
	public Group getGroup(int groupID);
	public ArrayList<Group> getAllGroups();
	public ArrayList<Match> getPlayoffMatches(); 
	public Team getChampionTeam();
	public void setEndDate(Date endDate);


	// id-it kosnstruktori
	// meore konstractori, rac not null-ia gadaecemodes, cahmpdb-im dagibrunos id
	// unda kondes jgufebi da matchebi (playoff-shi)
	//champdb-is yvela geteri da seteri
}
