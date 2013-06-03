package model.mainclasses;

public class PenaltyShoot {
	//private variables
	private boolean hasScored;
	private Match match;
	private Team team;
	private int turn;
	private Player pl;
	
	
	/**
	 * კონსტრუქტორი
	 * @param matchID მატჩის იდენტიფიკატორი
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param turn მერამდენე დარტყმაა
	 * @param Player_ID მოთამაშე
	 * @param isMissed გაიტანა თუ ვერა, თუ ვერ გაიტანა true, თუ გაიტანა false
	 */
	public PenaltyShoot(int matchID, int teamID, int turn, int playerID, boolean hasScored) {
		match = new Match_DLAPI(matchID);
		team = new Team_Ruska(teamID);
		this.turn = turn;
		pl = new Player_DEO(playerID);
		this.hasScored = hasScored;
	}

	/**
	 * აბრუნებს რომელ მატჩში იყო ეს პენალტი შესრულებული
	 * @return მატჩის(interface) ტიპის ობიექტი
	 */
	public Match getMatch(){
		return match;
	}
	
	/**
	 * აბრუნებს რომელი გუნდის მოთამაშემ დაარტყა პენალი
	 * @return Team(interface) ტიპის ობიექტი
	 */
	public Team getTeam(){
		return team;
	}
	
	/**
	 * აბრუნებს მერამდენე დარტყმა იყო გუნდის
	 * @return int ტიპის ობიექტი, და გვეუბნება მაგ. 4 რომ გუნდიდან მეოთხე დარტყმა იყო
	 */
	public int getTurnOfTeam(){
		return turn;
	}
	
	/**
	 * აბრუნებს გაიტანა თუ ვერა
	 * @return true თუ გაიტანა, false თუ ვერ გაიტანა
	 */
	public boolean hasScored(){
		return hasScored;
	}
	
	/**
	 * აბრუნებს მოთამაშეს, რომელმაც შეასრულა ეს დარტყმა
	 * @return Player(interface) ტიპის ობიექტი
	 */
	public Player getPlayer(){
		return pl;
	}
}
