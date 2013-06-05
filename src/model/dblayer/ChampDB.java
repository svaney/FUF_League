package model.dblayer;

import java.sql.Date;
import java.sql.SQLException;

public interface ChampDB {
	/*ცხრილები: championships, Coachs, Groups, PlayOff, awards
	 * 
	 * */
	
	public int addChampionship(String type, Date startDate) throws SQLException;
	public void setChampionshipType(String type, int champID) throws SQLException;
	public void setStartDate(Date startDate, int champID) throws SQLException;
	public void setEndDate(Date endDate, int champID) throws SQLException;

}
