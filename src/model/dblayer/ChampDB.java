package model.dblayer;

import java.sql.Date;
import java.sql.SQLException;

import model.mainclasses.Championship;

public interface ChampDB {
	/*ცხრილები: championships, Coachs, Groups, PlayOff, awards
	 * 
	 * */
	
	public int addChampionship(String type, Date startDate) throws SQLException;
	public void setChampionshipType(String type, int champID) throws SQLException;
	public void setStartDate(Date startDate, int champID) throws SQLException;
	public void setEndDate(Date endDate, int champID) throws SQLException;
	public String getChampType(int champID) throws SQLException;
	public Date getChampStartDate(int champID) throws SQLException;
	public Date getChampEndDate(int champID) throws SQLException;
	public int getChampID(String type, Date startDate) throws SQLException;

}
