package model.dblayer;

import java.util.List;

import model.mainclasses.Award;
import model.mainclasses.Player;
import model.mainclasses.Team;

public interface TeamDB {
	/* ცხრილები: Teams, Positions, Team_Players, captains, team_award
	 * კლასი, რომელიც დააიმპლემენტირებს ამ ინტერფეისს პასუხისმგებელი იქნება ბაზიდან ამოიღოს ინფორ-
	 * მაცია გუნდის შესახება, რომელიც ზემოთ ჩამოთვლილ ცხრილებშია. ასევე თუ რომელიც დაკავშირებულია
	 * სხვა ცრილთან ინფრომაციას შესაბამისი კლასს დავაბრუნებინებ.
	 * */
	
	public void initConnection();
	public Team getTeam(int teamID);
	public List<Player> getPlayers(int teamID, int champID);
	public List<Award> getAwards(int teamID);
	public Award getAwardInChampByTeam(int teamID, int ChampID);
	public void addPlayer(int teamID, int playerID);
	public Player getCaptain(int teamID, int champID);
	public boolean removeImage(int teamID);
	public boolean setImage(int teamID, String url);
	public void createTeam(Team team);
	
}
