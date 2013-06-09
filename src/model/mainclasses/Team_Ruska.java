/*
 * File: Team_Ruska.java
 * Author: ruska
 * -------------------------
 * ინფორმაცია ერთ გუნდზე.
 */

package model.mainclasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.Product;
import web.ProductCatalog;

import model.dblayer.TeamDB;

public class Team_Ruska implements Team{
	
	private int teamID;
	private TeamDB teamDataBase;
	private Team team;
	private String name;
	private URL imageURL;
	private URL logoURL;
	private String email;
	private String tel;
	private int rating;
	private List<Player> players;
	private List<Award> awards;
	private Award award;
	private Player captain;
	
	static String account = "root"; 
	static String password = "123456"; 
	static String server = "localhost";
	static String database = "test";

	private static ResultSet rs = null;
	private static Connection con;
	private static Statement stmt;
	
	public Team_Ruska(int teamID){
		this.teamID = teamID;
		this.team = teamDataBase.getTeam(teamID);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public URL getImageURL() {
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
	public URL getLogoURL() {
		return logoURL;
	}

	@Override
	public List<Player> getPlayers(int champID) {
		return players;
	}

	@Override
	public List<Award> getAwards() {
		return awards;
	}

	@Override
	public Award getAwardInChamp(int champID) {
		return award;
	}

	@Override
	public Player getCaptain(int champID) {
		return captain;
	}

	@Override
	public void setImageURL(String strURL) {
		URL temp;
		try {
			temp = new URL(strURL);
			if(teamDataBase.setImage(strURL))
				imageURL = temp;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeImage() {
		if(teamDataBase.removeImage(teamID))
			imageURL = null;
	}

	@Override
	public void setLogo(String strURL) {
		
	}

	@Override
	public void removeLogo() {
		
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
		// TODO Auto-generated method stub
		
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


}
