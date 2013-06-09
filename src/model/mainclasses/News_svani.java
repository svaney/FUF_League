package model.mainclasses;

import java.sql.Date;
import java.sql.SQLException;

import model.dblayer.NewsDB_svani;

public class News_svani implements News{
	private int newsID;
	private NewsDB_svani newsDB;
	
	public News_svani(Date newsDate){
		try {
			this.newsID = this.newsDB.addNewNews(newsDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
}
