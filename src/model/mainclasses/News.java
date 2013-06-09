package model.mainclasses;

public interface News {
	public void addChamp(int champID);
	public void addText(String text);
	public void addPicture(String picURL);
	public void addVideo(String vidURL);
	public void addAuthor(String author);
	public int getChampID();
	public String getText();
	public String getPicture();
	public String getVideo();
	public String getAuthor();
	
}
