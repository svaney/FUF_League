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
	public boolean hasPenaltySeries();
	
	/**
	 * აბრუნებს ამ მონაწილე გუნდებიდან ერთ-ერთის შედეგს პენლების სერიაში
	 * @return  Penalties კლასის ობიექტს თუკი იყო პენლები, თუ არადა null
	 * @param taemID გუნდის ID, რათა გაარკვიოს რომელი გუნდისთვის სურს დაბრუნება 
	 */
	public Penalties getPenaltiesForTeam(int teamID);
	
	/**
	 * ითვლის რამდენი გოლი გაიტანა გუნდმა (მხოლოდ ძირითად დროში)
	 * @param teamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა ძირითად დროში
	 */
	public int getScoreForTeam(int teamID);
	
	/**
	 * გვეუბნება მე-n გოლი რომელი იყო ამ თამაშში, არ აქვს მნიშვნელობა, რომელმა გუნდმა გაიტანა
	 * @param Nth - n მერამდენე გოლი გვინდა
	 * @return Goal ტიპის ცვლადი.
	 */
	public Goal getNthGoal(int Nth);
	
	/**
	 * გვეუბნება რამდენი გოლი გავიდა ამ თამაშის ძირითად დროში (დამატებითი პენლების გარდა)
	 * @return int ტიპის რაოდენობა ძირითად დროში გატანილი გოლების
	 */
	public int goalQuantty();
	
	/**
	 * გვეუბნება გუნდმა რამდენი გოლი გაიტანა დამატებით დროში. თუკი ასეთი დრო არსებობდა.
	 * @param TeamID გუნდის ID რომ გაირკვეს რომელ გუნდზეა საუბარი
	 * @return რამდენი გოლი გაიტანა დამატებით დროში.
	 */
	public int getExtraTimeGoalForTeam(int TeamID);
	
}
