package test;

import org.junit.Test;

import model.dblayer.*;

public class PlayerTest {

	@Test
	public void test() {
		System.out.println("აღარ მიწითლებს");
		PlayerDB_DEO deo = new PlayerDB_DEO();
		System.out.println(deo.toString(992)); // უნდა დაწეროს ყველა ატრიბუტი
	}

}
