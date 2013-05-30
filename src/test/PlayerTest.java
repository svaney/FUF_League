package test;

import org.junit.Test;
import model.mainclasses.Player_DEO;

public class PlayerTest {

	@Test
	public void test() {
	//	PlayerDB_DEO playerDB = new PlayerDB_DEO();
	//	System.out.println(playerDB.toString(4)); // უნდა დაწეროს ყველა ატრიბუტი
		Player_DEO player = new Player_DEO(4);
		System.out.println("სახელი: "+player.getFirstName()+" "+player.getLastName());
		System.out.println("დაბადების თარიღი: "+player.getBirthDate());
		System.out.println("ჩაბარების წელი: "+player.getUniStartYear());
		if(player.isStudent()){
			System.out.println("სკოლა: "+player.getSchool());
			System.out.println("კურსი: "+player.getUniCurrentCourse());
		}
	}
}