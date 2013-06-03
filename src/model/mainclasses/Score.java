/**	
 * File: ScoreInterface.java
 * type: Interface
 * @author Data
 * -----------------
 * კონკრეტული მატჩის ანგარიშის ინტერფეისი.
 * */
package model.mainclasses;


public interface Score {

	/**
	 * აბრუნებს ამ თამაშის Score-ში არის თუ არა პენლების სერია გათვალისწინებული
	 * @return true - თუკი იყო პენლების სერია, false წინააღმდეგ შემთხვევაში
	 */
	boolean hasPenaltySeries();

	/**
	 * აბრუნებს პენლების სერიას
	 * @return  Penalties კლასის ობიექტს თუკი იყო პენლები, თუ არადა null
	 */
	Penalties getPenaltiesForTeam();

	/**
	 * ითვლის რამდენი გოლი გაიტანა გუნდმა (მხოლოდ ძირითად დროში)
	 * @param teamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა ძირითად დროში
	 */
	int getScoreForTeam(int teamID);

	/**
	 * პირველი ტაიმში გუნდის მიერ გატანილი გოლების რაოდენობა
	 * @param teamID გუნდის მაიდენტიფიცირებელი ID
	 * @return int ტიპის მნიშვნელობა - გატანილი გოლების რაოდენობა
	 */
	int getScoreForTeamFirstHalf(int teamID);

	/**
	 * გვეუბნება მე-n გოლი რომელი იყო ამ თამაშში, არ აქვს მნიშვნელობა, რომელმა გუნდმა გაიტანა
	 * @param Nth - n მერამდენე გოლი გვინდა
	 * @return Goal ტიპის ცვლადი.
	 */
	Goal getNthGoal(int Nth);

	/**
	 * გვეუბნება გუნდმა რამდენი გოლი გაიტანა დამატებით დროში. თუკი ასეთი დრო არსებობდა.
	 * @param TeamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა დამატებით დროში.
	 */
	int getExtraTimeGoalForTeam(int teamID);

	//-------------------------------------------------------------------------------------
	// სეტერები
	//-------------------------------------------------------------------------------------
	/**
	 * ანიჭებს პენლების სერიის ობიექტს
	 * @param penalties Penalties ტიპის ობიექტი
	 */
	void setPenaltiesSerie(Penalties penalties);

	/**
	 * წერს, რამდენი გოლი გაიტანა გუნდმა ძირითად დროში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param score გოლების რაოდენობა
	 */
	void setScoreForTeam(int teamID, int score);

	/**
	 * წერს, რამდენი გოლი გაიტანა გუნდმა პირველ ტაიმში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param score გოლების რაოდენობა
	 */
	void setScoreForTeamFirstHalf(int teamID, int score);

	/**
	 * წერს მე-n გოლს რომელიც გავიდა თამაშში (არ აქვს მნიშვნელობა ძირითად დროში თუ დამატებითში)
	 * @param goal Goal ტიპის ობიექტი
	 * @param Nth გოლის რიგითი ნომერი
	 */
	void setNthGoal(Goal goal, int Nth);

	/**
	 * წერს რამდენი გოლი გაიტანა გუნდმა დამატებით დროში
	 * @param teamID გუნდის იდენტიფიკატორი
	 * @param n რაოდენობა გატანილი გოლების, დამატებულ დროში.
	 */
	void setExtraTimeGoalForTeam(int teamID, int n);

}
