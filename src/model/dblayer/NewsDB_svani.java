package model.dblayer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDB_svani implements NewsDB{
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "123456";
	private static final String MYSQL_DATABASE_SERVER = "localhost";
	private static final String MYSQL_DATABASE_NAME = "fuf_league";
	private Connection con;

	public NewsDB_svani(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + MYSQL_DATABASE_SERVER, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addNewNews(Date newsDate) throws SQLException {
		Statement st;
		ResultSet rs;
		String quer;
		int newsID;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "insert into news (news_date) values ('" + newsDate + "');";
		
		st.executeUpdate(quer);
		quer = "select news_id from news where news_date='" + newsDate + "';";
		rs = st.executeQuery(quer);
		rs.next();
		newsID = rs.getInt("news_id");
		st.close();
		rs.close();

		return newsID;
		
	}

	public void addChamp(int newsID, int champID) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update news set championship_id=" + champID + " where news_id= " + newsID + ";";
		
		st.executeUpdate(quer);
		
		st.close();
		
	}

	public void addText(int newsID, String text) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update news set txt='" + text + "' where news_id= " + newsID + ";";
		
		st.executeUpdate(quer);
		
		st.close();
		
	}

	public void addPicture(int newsID, String picURL) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update news set Picture_URL='" + picURL + "' where news_id= " + newsID + ";";
		
		st.executeUpdate(quer);
		
		st.close();
		
	}

	public void addVideo(int newsID, String vidURL) throws SQLException {
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update news set video_URL='" + vidURL + "' where news_id= " + newsID + ";";
		
		st.executeUpdate(quer);
		
		st.close();
		
	}

	public void addAuthor(int newsID, String author) throws SQLException{
		Statement st;
		String quer;
		
		st = con.createStatement();
		st.executeQuery("USE " + MYSQL_DATABASE_NAME);
		quer = "update news set author='" + author + "' where news_id= " + newsID + ";";
		
		st.executeUpdate(quer);
		
		st.close();
		
	}

	

}
