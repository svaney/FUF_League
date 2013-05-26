/* avtori: Ruska
 * ეს კლასი ევორდებზე ინახავს ინფორმაციას.
 * */
/*
 * ეს არის ერთ-ერთი ვარიანი იმპლემეტაციის და შეიძლება მერე სხვანაირად გადავწყვიტო.
 * ეს კლასი მხოლოდ იმაზე იქნება პასუხისმგებელი, რომ ჯილდოზე ინფო ჰქონდეს.
 * ამას ცალკე დბ არ გავუკეთე, TeamDB ამოიღებს
 * **/
package model.mainclasses;

public class Award_Ruska {
	
	private String award;
	private String champName;
	
	public Award_Ruska(String award, String champName){
		this.award = award;
		this.champName = champName;
	}

	public String getAward() {
		return award;
	}

	public String getChampName() {
		return champName;
	}
}
