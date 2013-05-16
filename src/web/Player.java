package web;

public class Player {
	
	/**
	 * რეალურად, ამ კლასმა ბაზისგან უნდა აიღოს ეს მონაცემები, მაგრამ რადგან ბაზა ჯერ არ შექმნილა
	 * კლასს ვაწვდი პირობით ინფორმაციას.
	 * შემდგომში მეთოდები უნდა გადაკეთდეს ისე რომ აბრუნდებდეს არა ამ კონსტანტებს,
	 * არამედ ბაზიდან ამოღებულ ინფორმაციას.
	 */
	private static final String ID = "992";
	private static final String NAME = "დავით";
	private static final String FAMILY = "გოჩავა";
	private static final String NICK = "DEO";
	private static final String AVATAR = "avatar_"+ID+".jpg";
	private static final String TEAM = "FLYING DUTCHMAN";
	private static final String BIRTH = "3 მაისი, 1992";
	private static final String SCHOOL = "ESM";
	private static final String LEVEL = "III";
	private static final String HEIGHT = "172";
	private static final String WEIGHT = "58";
	private static final String POSITION = "თავდამსხმელი/შემ.ნახევარმცველი";
	private static final String NUMBER = "10";
	private static final String PAGE = "https://www.facebook.com/deo.gochava";
	//ატრიბუტების სია გაცილებით გრძელია, უბრალოდ საცდელად ეს 3-იც მეყოფა
	private static final double SPEED = 9.8;
	private static final double CONTROL = 9.5;
	private static final double HEADING = 4.0;
	public static String getName(String id){
		if(ID.equals(id)){
			return NAME;
		}
		return null;
	}
	
	public static String getFamily(String id){
		if(ID.equals(id)){
			return FAMILY;
		}
		return null;
	}
	
	public static String getNick(String id){
		if(ID.equals(id)){
			return NICK;
		}
		return null;
	}
	
	public static String getAvatar(String id){
		if(ID.equals(id)){
			if(AVATAR==null){
				return "defaultAvatar.png";
			}
			return AVATAR;
		}
		return null;
	}
	
	public static String getTeam(String id){
		if(ID.equals(id)){
			return TEAM;
		}
		return null;
	}
	
	public static String getBirth(String id){
		if(ID.equals(id)){
			if(BIRTH==null){
				return "-";
			}
			return BIRTH;
		}
		return null;
	}
	
	public static String getSchool(String id){
		if(ID.equals(id)){
			if(SCHOOL==null){
				return "-";
			}
			return SCHOOL;
		}
		return null;
	}
	
	public static String getLevel(String id){
		if(ID.equals(id)){
			if(LEVEL==null){
				return "-";
			}
			return LEVEL;
		}
		return null;
	}
	
	public static String getHeigth(String id){
		if(ID.equals(id)){
			if(HEIGHT==null){
				return "-";
			}
			return HEIGHT;
		}
		return null;
	}
	
	public static String getWeight(String id){
		if(ID.equals(id)){
			if(WEIGHT==null){
				return "-";
			}
			return WEIGHT;
		}
		return null;
	}

	public static String getPosition(String id){
		if(ID.equals(id)){
			if(POSITION==null){
				return "-";
			}
			return POSITION;
		}
		return null;
	}
	
	public static String getNumber(String id){
		if(ID.equals(id)){
			if(NUMBER==null){
				return "-";
			}
			return NUMBER;
		}
		return null;
	}
	
	public static String getPage(String id){
		if(ID.equals(id)){
			return PAGE;
		}
		return null;
	}
	
	public static double getSpeed(String id){
		if(ID.equals(id)){
			return SPEED;
		}
		return 1;
	}
	
	public static double getControl(String id){
		if(ID.equals(id)){
			return CONTROL;
		}
		return 1;
	}
	
	public static double getHeading(String id){
		if(ID.equals(id)){
			return HEADING;
		}
		return 1;
	}

}
