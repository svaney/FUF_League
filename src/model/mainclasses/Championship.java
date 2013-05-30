package model.mainclasses;

import java.util.ArrayList;

public interface Championship {
	public void addTeam(Team team);
	public void addTeams(ArrayList<Team> teams);
	public int getTeamCount();
	public Team getTeam(String teamName);
	public ArrayList<Team> getAllTeams();
	public void createGroups();
	public Group getGroup(String groupName);
	public void endChamp();

}
