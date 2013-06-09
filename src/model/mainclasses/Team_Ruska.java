/*
 * File: Team_Ruska.java
 * Author: ruska
 * -------------------------
 * ინფორმაცია ერთ გუნდზე.
 */

package model.mainclasses;

import java.sql.SQLException;
import java.util.List;

import controller.TeamListServlet;

import model.dblayer.TeamDB;
import model.dblayer.TeamDB_Ruska;

public class Team_Ruska implements Team{

	private int teamID;
	private TeamDB teamDataBase;
	private String name;
	private String imageURL;
	private String logoURL;
	private String email;
	private String tel;
	private int rating;
	private List<Player> players;
	private List<Award> awards;
	private Award award;
	private Player captain;

	

	public Team_Ruska(int teamID){
		this.teamID = teamID;
		teamDataBase = new TeamDB_Ruska();
		try {
			teamDataBase.createTeam(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getID() {
		return teamID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getImageURL() {
		return imageURL;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getTel() {
		return tel;
	}

	@Override
	public int getRating() {
		return rating;
	}

	@Override
	public String getLogoURL() {
		return logoURL;
	}

	@Override
	public List<Player> getPlayers(int champID) {
		players = teamDataBase.getPlayers(teamID, champID);
		return players;
	}

	@Override
	public List<Award> getAwards() {
		awards = teamDataBase.getAwards(teamID);
		return awards;
	}

	@Override
	public Award getAwardInChamp(int champID) {
		return award;
	}

	@Override
	public Player getCaptain(int champID) {
		captain = teamDataBase.getCaptain(teamID, champID);
		return captain;
	}

	@Override
	public void setImageURL(String url) {
		if(teamDataBase.setImage(teamID,url))
			imageURL = url;
	}

	@Override
	public void removeImage() {
		if(teamDataBase.removeImage(teamID))
			imageURL = null;
	}

	@Override
	public void setLogo(String url) {
		if(teamDataBase.setLogo(teamID,url))
			logoURL = url;

	}

	@Override
	public void removeLogo() {
		if(teamDataBase.reamoveLogo(teamID))
			logoURL = null;
	}

	@Override
	public boolean addPlayer(int playerID) {
		return false;
	}

	@Override
	public boolean removePlayer(int playerID) {
		return false;
	}

	@Override
	public void setEmail(String email) {
	}

	@Override
	public void removeEmail() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTel(String tel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAward(Award award) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeCaptain(Player player) {
		// TODO Auto-generated method stub

	}




	@Override
	public void changeName(String name) {

	}




	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCaptain(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRating(int rating) {
		// TODO Auto-generated method stub
		
	}
}