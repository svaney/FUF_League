package test;

import java.sql.Date;

import org.junit.Test;

import model.dblayer.PlayerDB_DEO;
import model.mainclasses.Lists_DEO;
import model.mainclasses.Player_DEO;

public class PlayerTest {

	@Test
	public void test() {
		PlayerDB_DEO playerDB = new PlayerDB_DEO();
		System.out.println(playerDB.toString(5)); // უნდა დაწეროს ყველა ატრიბუტი
		Player_DEO player = new Player_DEO(4);
		System.out.println(player.getPersonID());
		System.out.println("სახელი: "+player.getFirstName()+" "+player.getLastName());
		System.out.println("დაბადების თარიღი: "+player.getBirthDate());
		System.out.println("ჩაბარების წელი: "+player.getUniStartYear());
		if(player.isStudent()){
			System.out.println("სკოლა: "+player.getSchool());
			System.out.println("კურსი: "+player.getUniCurrentCourse());
		}
		System.out.println("სიმაღლე: "+player.getHeight());
		System.out.println("წონა: "+player.getWeight());
		System.out.println("გუნდის ნომერი: "+player.getTeamID());
		System.out.println("პერსონის ნომერი: "+player.getPersonID());
		System.out.println("ასაკი: "+player.getAge());
		System.out.println(Lists_DEO.teams()[0][1]); // უნდა დაწეროს გუნდის სახელი
		System.out.println(Lists_DEO.players()[0][1]); // უნდა დაწეროს მოთამაშის სახელი
		Player_DEO testPlayer = new Player_DEO();
		Date birth = new Date(0);
		birth.setYear(88);
		birth.setMonth(12);
		birth.setDate(31);
		testPlayer.setFirstName("ჯონი");
		testPlayer.setLastName("ჯოლია");
		testPlayer.setBirthDate(birth);
		testPlayer.setUniStartYear(2010);
		testPlayer.setUniCurrentCourse(3);
		testPlayer.setSchool("ESM");
		testPlayer.setHeight(185);
		testPlayer.setWeight(79);
		testPlayer.setTeamID(2);
		testPlayer.setFoot("L");
		testPlayer.setPosition("მცველი");		
		playerDB.commitPlayer(testPlayer);
	}
}