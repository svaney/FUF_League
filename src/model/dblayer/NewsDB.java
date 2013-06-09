package model.dblayer;

import java.sql.Date;
import java.sql.SQLException;

public interface NewsDB {
	/* ცხრილები: News
	 * კლასი, რომელიც ამ ინტერფეისს დააიმპლემენტირებს ბაზიდან ამოიღებს ნიუსების ცხრილიდან ინფოს,
	 * ანუ ყველაფერს რაც ნიუსებისთვის ჭირდება. თუ რომელიც ჩემპიონატია დაუბრუნებს ChampDB, რომელსაც
	 * გადასცემს News ცხრილში არსებულ championship_id
	 * */
	
	public int addNewNews(Date newsDate) throws SQLException;
	public void addChamp(int newsID, int champID) throws SQLException;
	public void addText(int newsID, String text) throws SQLException;
	public void addPicture(int newsID, String picURL) throws SQLException;
	public void addVideo(int newsID, String vidURL) throws SQLException;
	public void addAuthor(int newsID, String author) throws SQLException;
}
