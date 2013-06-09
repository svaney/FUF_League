package model.mainclasses;

import java.util.Date;
import java.text.SimpleDateFormat;

import model.dblayer.PlayerDB_DEO;

public class Player_DEO implements Player {
	private PlayerDB_DEO player;
	private int playerID = -1;
	private static int personID = -1;
	// პერსონის ატრიბუტები
	private String firstname = null;
	private String lastname = null;
	private String nickname = null;
	private Date birthDate = null;
	private Date uniStart = null;
	private int uniCourse = -1;
	private String graduated = null;
	private String school = null;
	private int weight = -1;
	private int height = -1;
	private String homePage = null;
	private String image = "avatar_000.png";
	private int teamID = -1;

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
	
	/**
	 * ქმნის ახალ მოთამაშეს. ყველა ატრიბუტი არის 0 ან NULL.
	 */
	public Player_DEO(){		
	}
	
	/**
	 * პარამეტრის მიხედვით ბაზიდან იღებს მოთამაშის მონაცემებს.
	 * @param playerID
	 */
	public Player_DEO(int playerID){
		player = new PlayerDB_DEO();
		if(player.exists(playerID)){
			this.playerID = playerID;		
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
			if(player.getImageURL(playerID) != null)image = player.getImageURL(playerID);
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
			positioning = player.getPositioning(playerID);
			position = player.getPosition(playerID);
			biography = player.getBio(playerID);
			strength = player.getStrength(playerID);
			teamID = player.getTeamID(playerID);
		}
		player.reset();
	}

	/**
	 * აბრუნებს მოთამაშის სახელს.
	 */
	@Override
	public String getFirstName() {
		return firstname;
	}

	/**
	 * აბრუნებს მოთამაშის გვარს.
	 */
	@Override
	public String getLastName() {
		return lastname;
	}

	/**
	 * აბრუნებს მოთამაშის მეტსახელს.
	 */
	@Override
	public String getNickname() {
		return nickname;
	}

	/**
	 * აბრუნებს მოთამაშის დაბადების თარიღს;
	 * ფორმატი: YYYY-MM-DD.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String getBirthDate() {
		if(birthDate != null){
			return(""+birthDate.getDate()+" "+month[birthDate.getMonth()]+", "+(1900+birthDate.getYear()));
		}
		return null;
	}
	
	public Date birthDate(){
		return birthDate;
	}
	
	/**
	 * აბრუნებს მოთამაშის ასაკს;
	 * აბრუნებს -1-ს თუ მოთხოვნილი პარამეტრი არ არსებობს (null-ის ტოლია).
	 * @return
	 */
	@Override
	public int getAge(){
		if(birthDate==null) return -1;
		SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfM = new SimpleDateFormat("MM");
		SimpleDateFormat sdfD = new SimpleDateFormat("dd");
		Date now = new Date();
		int age = Integer.parseInt(sdfY.format(now))-Integer.parseInt(sdfY.format(birthDate));
		if(Integer.parseInt(sdfM.format(now))<Integer.parseInt(sdfM.format(birthDate))) return (age-1);
		if((Integer.parseInt(sdfM.format(now))==Integer.parseInt(sdfM.format(birthDate)))&(Integer.parseInt(sdfD.format(now))>Integer.parseInt(sdfD.format(birthDate)))) return 12;
		return age;
	}

	/**
	 * აბრუნებს მოთამაშის უნივერსიტეტში ჩაბარების წელს;
	 * თუ დააბრუნა -1, მაშინ გამოძახებული ატრიბუტი არ არსებობს (null-ის ტოლია).
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int getUniStartYear() {
		if(uniStart != null) return (1900+uniStart.getYear());
		return -1;
	}

	/**
	 * აბრუნებს კურსს, რომელზეც იმყოფება მოთამაშე.
	 */
	public String getUniCurrentCourseString() {	
		if(uniCourse!=0){
			if(uniCourse==1) return(uniCourse+"-ლი კურსი;");
			return("მე-"+uniCourse+" კურსი");
		}
		return null;
	}
	
	/**
	 * აბრუნებს კურსს, რომელზეც იმყოფება მოთამაშე.
	 */
	@Override
	public int getUniCurrentCourse() {	
		return uniCourse;
	}

	/**
	 * აბრუნებს მოთამაშის სტუდენტობის სტატუსს;
	 * TRUE - სტუდენტია;
	 * FALSE - დაამთავრა (ან  შეყწვიტა სწავლა).
	 */
	@Override
	public boolean isStudent() {
		if(graduated==null) return true;
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
	public int getWeight() {
		return weight;
	}
	
	/**
	 * აბრუნებს მოთამაშის წონას;
	 * ერთეული: კგ (კილოგრამი)
	 */
	public String getWeightString() {
		return weight+" კგ.";
	}

	/**
	 * აბრუნებს მოთამაშის სიმაღლეს;
	 * ერთეული: სმ (სანტიმეტრი)
	 */
	@Override
	public int getHeight() {
		return height;
	}
	
	/**
	 * აბრუნებს მოთამაშის სიმაღლეს;
	 * ერთეული: სმ (სანტიმეტრი)
	 */
	public String getHeightString(){
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
		return playerID;
	}
	
	@Override
	public int getTeamID(){
		return teamID;
	}
	
	@Override
	public String getTeamName(){
		Team_Ruska team = new Team_Ruska(getTeamID());
		return team.getName();
	}
	
	/**
	 * გვეუბნება აქვს თუ არა მოთამაშეს რეიტინგის გრაფა.
	 */
	@Override
	public boolean hasRatingBar(){
		if(speed == 0) return false;
		return true;
	}
	
	/**
	 * გვეუბნება აქვს თუ არა მოთამაშეს მეტსახელი.
	 */
	@Override
	public boolean hasNickname(){
		if(nickname == null) return false;
		return true;
	}

	/**
	 * მოთამაშის სახელს ანიშებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstname = firstName;		
	}

	/**
	 * მოთამაშის გვარს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastname = lastName;		
	}

	/**
	 * მოთამაშის მეტსახელს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setNickname(String nickName) {
		this.nickname = nickName;		
	}

	/**
	 * მოთამაშის დაბადების დღეს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;		
	}

	/**
	 * მოთამაშის ჩაბარების/დაწყების წელს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setUniStartYear(int startYear) {
		Date startDate = new Date();
		startDate.setYear((startYear-1900));
		this.uniStart = startDate;		
	}

	/**
	 * მოთამაშის მიმდინარე კურსს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setUniCurrentCourse(int course) {
		this.uniCourse = course;
	}

	/**
	 * მოთამაშის სკოლას/ფაკულტეტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setSchool(String school) {
		this.school = school;		
	}

	/**
	 * მოთამაშის წონას ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setWeight(int weight) {
		this.weight = weight;		
	}

	/**
	 * მოთამაშის სიმაღლეს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * მოთამაშის პროფილის სურათს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setAvatar(String avatar) {
		this.image = avatar;
	}

	/**
	 * მოთამაშის ბიოგრაფიას ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setBio(String bio) {
		this.biography = bio;
	}

	/**
	 * მოთამაშის რეიტინგს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * მოთამაშის დომინანტ ფეხს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setFoot(String foot) {
		this.foot = foot;
	}

	/**
	 * მოთამაშის ფბ-ს გვერდს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setFBPage(String fbPage) {
		this.homePage = fbPage;
	}

	/**
	 * მოთამაშის პოზიციას ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setSpeed(int param) {
		this.speed = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setDribbling(int param) {
		this.dribbling = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setHeading(int param) {
		this.heading = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setClubLoyalty(int param) {
		this.loyalty = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setDiving(int param) {
		this.diving = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setDurability(int param) {
		this.durability = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setShooting(int param) {
		this.shooting = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setWorkRate(int param) {
		this.work = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setCreativity(int param) {
		this.creativity = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setFearFactor(int param) {
		this.fear_factor = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setKillerInstinct(int param) {
		this.killer_instinct = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setVision(int param) {
		this.vision = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setPassing(int param) {
		this.passing = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setPenalty(int param) {
		this.penalty = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setPenaltySaving(int param) {
		this.penalty_saveing = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setLidership(int param) {
		this.lidership = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setReflexes(int param) {
		this.reflexes = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setTackling(int param) {
		this.tackling = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setShotStoping(int param) {
		this.shot_stopping = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setMistakeFactor(int param) {
		this.mistake_factor = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setPositioning(int param) {
		this.positioning = param;
	}

	/**
	 * მოთამაშის ატრიბუტს ანიჭებს გადაცემულ მნიშვნელობას.
	 */
	@Override
	public void setStrength(int param) {
		this.strength = param;
	}

	@Override
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	/**
	 * ბაზას უგზავნის დასაკომიტებელ ინფორმაციას.
	 */
	@Override
	public void commitPlayer() {
		PlayerDB_DEO player = new PlayerDB_DEO();
		player.commitPlayer(this);		
	}
}
