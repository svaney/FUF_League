package test;

import java.sql.SQLException;

import model.dblayer.TeamDB;
import model.dblayer.TeamDB_Ruska;
import model.mainclasses.Team;
import model.mainclasses.Team_Ruska;

public class RuskasTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Team r = new Team_Ruska(2);
		TeamDB_Ruska d = new TeamDB_Ruska();
		try {
			d.createTeamFromID(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
