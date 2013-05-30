package model.mainclasses;

import java.sql.Date;

import model.dblayer.PlayerDB_DEO;

public class Player_DEO implements Player {
	private PlayerDB_DEO player;
	private int id;
	private static int personID = -1;
	// პერსონის ატრიბუტები
	private String firstname = null;
	private String lastname = null;
	private String nickname = null;
	private Date birthDate = null;
	private Date uniStart = null;
	private int uniCourse = 0;
	private String graduated = null;
	private String school = null;
	private int weight = 0;
	private int height = 0;
	private String homePage = null;
	private String image = "design/defaultAvatar.png";

	//მოთამაშის ატრიბუტები
	private Double rating = null;
	private String position = null;
	private String foot = null;
	private int speed = 0;
	private int dribbling = 0;
	private int heading = 0;
	private int diving = 0;
	private int durability = 0;
	private int loyalty = 0;
	private int shooting = 0;
	private int work = 0;
	private int creativity = 0;
	private int fear_factor = 0;
	private int killer_instinct = 0;
	private int tackling = 0;
	private int vision = 0;
	private int passing = 0;
	private int penalty = 0;
	private int penalty_saveing = 0;
	private int shot_stopping = 0;
	private int lidership = 0;
	private int reflexes = 0;
	private int mistake_factor = 0;
	private int positioning = 0;
	private int strength = 0;
	private String biography = null;
	//იყენებს თარიღიდან თვის სახელის ამოსაღებად.
	private static final String[] month = {"იანვარი","თებერვალი","მარტი","აპრილი","მაისი","ივნისი","ივლისი","აგვისტო","სექტემბერი","ოქტომბერი","ნოემბერი","დეკემბერი"};
	
	public Player_DEO(int playerID){
		player = new PlayerDB_DEO();
		id = playerID;
		personID = player.getPersonID(playerID);
		firstname = player.getFirstName(playerID);
		lastname = player.getLastName(playerID);
		nickname = player.getNickname(playerID);
		birthDate = player.getBirthDate(playerID);
		uniStart = player.getUniStartYear(playerID);
		uniCourse = player.getUniCurrentCourse(playerID);
		graduated = player.getGraduated(playerID);
		school = player.getSchool(playerID);
		weight = player.getWeight(playerID);
		height = player.getHeight(playerID);
		homePage = player.getFBPage(playerID);
		rating = player.getRating(playerID);
		foot = player.getFoot(playerID);
		if(player.getImageURL(playerID) != null)image = "players/"+player.getImageURL(playerID);
		position = player.getPosition(playerID);
		speed = player.getSpeed(playerID);
		dribbling = player.getDribbling(playerID);
		heading = player.getHeading(playerID);
		diving = player.getDiving(playerID);
		durability = player.getDurability(playerID);
		loyalty = player.getClubLoyalty(playerID);
		shooting = player.getShooting(playerID);
		work = player.getWorkRate(playerID);
		creativity = player.getCreativity(playerID);
		fear_factor = player.getFearFactor(playerID);
		killer_instinct = player.getKillerInstinct(playerID);
		tackling = player.getTackling(playerID);
		vision = player.getVision(playerID);
		passing = player.getPassing(playerID);
		penalty = player.getPenalty(playerID);
		penalty_saveing = player.getPenaltySaving(playerID);
		shot_stopping = player.getShotStoping(playerID);
		lidership = player.getLidership(playerID);
		reflexes = player.getReflexes(playerID);
		mistake_factor = player.getMistakeFactor(playerID);
		positioning = player.getMistakeFactor(playerID);
		position = player.getPosition(playerID);
		biography = player.getBio(playerID);
		strength = player.getStrength(playerID);
		player.reset();
	}

	/**
	 * აბრუნებს მოთამაშის სახელს;
	 */
	@Override
	public String getFirstName() {
		return firstname;
	}

	/**
	 * აბრუნებს მოთამაშის გვარს;
	 */
	@Override
	public String getLastName() {
		return lastname;
	}

	/**
	 * აბრუნებს მოთამაშის მეტსახელს
	 */
	@Override
	public String getNickname() {
		return nickname;
	}

	/**
	 * აბრუნებს მოთამაშის დაბადების თარიღს;
	 * ფორმატი: YYYY-MM-DD
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String getBirthDate() {
		if(birthDate != null){
			return(""+birthDate.getDate()+" "+month[birthDate.getMonth()]+", "+(1900+birthDate.getYear()));
		}
		return null;
	}

	/**
	 * აბრუნებს მოთამაშის უნივერსიტეტში ჩაბარების წელს
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String getUniStartYear() {
		if(uniStart != null){
			return(""+(1900+uniStart.getYear()));
		}
		return null;
	}

	/**
	 * აბრუნებს კურსს, რომელზეც იმყოფება მოთამაშე
	 */
	@Override
	public String getUniCurrentCourse() {	
		if(uniCourse!=0){
			if(uniCourse==1) return(uniCourse+"-ლი კურსი;");
			return("მე-"+uniCourse+" კურსი;");
		}
		return null;
	}

	/**
	 * აბრუნებს მოთამაშის სტუდენტობის სტატუსს;
	 * TRUE - სტუდენტია;
	 * FALSE - დაამთავრა (ან  შეყწვიტა სწავლა);
	 */
	@Override
	public boolean isStudent() {
		if(graduated.equals("N")) return true;
		return false;
	}
	
	/**
	 * აბრუნებს სკოლის სახელს, რომელშიც ჩარიცხულია მოთამაშე;
	 * მაგ: LIBERAL ART
	 */
	@Override
	public String getSchool() {
		return school;
	}

	/**
	 * აბრუნებს მოთამაშის წონას;
	 * ერთეული: კგ (კილოგრამი)
	 */
	@Override
	public String getWeight() {
		return weight+" კგ.";
	}

	/**
	 * აბრუნებს მოთამაშის სიმაღლეს;
	 * ერთეული: სმ (სანტიმეტრი)
	 */
	@Override
	public String getHeight() {
		return height+" სმ.";
	}

	/**
	 * აბრუნებს მოთამაშის პროფილის სურათის მისამართს
	 */
	@Override
	public String getAvatar() {
		return image;
	}
	
	/**
	 * აბრუნებს მოთამაშის ბიოგრაფიას
	 */
	@Override
	public String getBio() {
		return biography;
	}
	
	/**
	 * აბრუნებს მომხმრაბლების მიერ მინიჭებულ რეიტინგს
	 */
	@Override
	public double getRating() {
		return rating;
	}

	/**
	 * აბრუნებს მოთამაშის დომინანტ ფეხს;
	 * მაგ: მარცხენა
	 */
	@Override
	public String getFoot() {
		if(foot.equals("R")) return "მარჯვენა";
		if(foot.equals("L")) return "მარცხენა";
		return foot;
	}

	@Override
	public String getFBPage() {
		return homePage;
	}

	@Override
	public String getPosition() {
		return position;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getDribbling() {
		return dribbling;
	}

	@Override
	public int getHeading() {
		return heading;
	}

	@Override
	public int getClubLoyalty() {
		return loyalty;
	}

	@Override
	public int getDiving() {
		return diving;
	}

	@Override
	public int getDurability() {
		return durability;
	}

	@Override
	public int getShooting() {
		return shooting;
	}

	@Override
	public int getWorkRate() {
		return work;
	}

	@Override
	public int getCreativity() {
		return creativity;
	}

	@Override
	public int getFearFactor() {
		return fear_factor;
	}

	@Override
	public int getKillerInstinct() {
		return killer_instinct;
	}

	@Override
	public int getVision() {
		return vision;
	}

	@Override
	public int getPassing() {
		return passing;
	}

	@Override
	public int getPenalty() {
		return penalty;
	}

	@Override
	public int getPenaltySaving() {
		return penalty_saveing;
	}

	@Override
	public int getLidership() {
		return lidership;
	}

	@Override
	public int getReflexes() {
		return reflexes;
	}
	
	@Override
	public int getTackling() {
		return tackling;
	}

	@Override
	public int getShotStoping() {
		return shot_stopping;
	}

	@Override
	public int getMistakeFactor() {
		return mistake_factor;
	}
	
	@Override
	public int getPositioning() {
		return positioning;
	}
	
	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public int getPersonID() {
		return personID;
	}
	
	@Override
	public int getPlayerID() {
		return id;
	}

}
