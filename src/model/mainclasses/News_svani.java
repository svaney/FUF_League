package model.mainclasses;

import java.sql.Date;
import java.sql.SQLException;

import model.dblayer.NewsDB_svani;

public class News_svani implements News{
	private int newsID;
	private NewsDB_svani newsDB;
	
	public News_svani(Date newsDate){
		this.newsDB = new NewsDB_svani();
		try {
			this.newsID = this.newsDB.addNewNews(newsDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public News_svani(int newsID){
		this.newsDB = new NewsDB_svani();
		this.newsID = newsID; 
	}

	@Override
	public void addChamp(int champID) {
		try {
			this.newsDB.addChamp(this.newsID, champID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addText(String text) {
		try {
			this.newsDB.addText(this.newsID, text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addPicture(String picURL) {
		try {
			this.newsDB.addPicture(this.newsID, picURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addVideo(String vidURL) {
		try {
			this.newsDB.addVideo(this.newsID, vidURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addAuthor(String author) {
		try {
			this.newsDB.addAuthor(this.newsID, author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int getChampID() {
		int champID = 0;
		
		try {
			champID = this.newsDB.getChampID(this.newsID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return champID;
	}

	@Override
	public String getText() {
		String txt = "";
		
		try {
			txt = this.newsDB.getText(this.newsID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return txt;
	}

	@Override
	public String getPicture() {
		String pic = "";
		
		try {
			pic = this.newsDB.getPicture(this.newsID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Override
	public String getVideo() {
		String vid = "";
		
		try {
			vid = this.newsDB.getVideo(this.newsID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vid;
	}

	@Override
	public String getAuthor() {
		String auth = "";
		
		try {
			auth = this.newsDB.getAuthor(this.newsID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auth;
	}
	
}
