package model.dblayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
	/**
	 * უნდა გადმომცეს გამოძახებული სიები.
	 * @author DEO.Gochava
	 */
public interface ListsDB {
		/* ცხრილები: Players, Persons, Teams, Positions, Champ_Types (შეიძლება სხვების დამატებაც)
		 * კლასი, რომელიც ამას გაუკეთებს იმპლიმენტაციას, შეძლებს ამოიღოს ცხრილის ყველა წევრის სია.
		 * გამოყენება: მაგ: გვინდა ეკრანზე გამოვიტანოთ ყველა გუნდის სახელი. ამ ინტერფეისის გამომყენებელი
		 * კლასი გადმოგვცემს შესაბამისი მნიშვნელობებით სავსე სიას (List-ს ან Array-ს).
		 */
	
	public String[][] listAllPlayers();
	public String[][] listAllTeams();
	public String[] listAllPositions();
	public String[] listAllTypes();
	
	/**
	 * აბრუნებს მატჩების ID_ებს.
	 * @return Integer ობიექტების List
	 * @author Data
	 * @throws SQLException 
	 */
	public List<Integer> getMatchIDs() throws SQLException;
}
