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
	
	public Team getTeam(int teamID);
	public List<Player> getPlayers(int teamID, int champID);
	public List<Award> getAwards(int teamID);
	public void addPlayer(int teamID, int playerID);
	public Player getCaptain(int teamID, int champID);
}
