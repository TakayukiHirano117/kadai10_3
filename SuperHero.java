package kadai10;

public class SuperHero extends Hero {
	 private String name;
	 private int hp;
	 private int at;
	 private int df;
	 private static int money = 100;
	 
	public void doubleAttack() {
		super.attack();
		super.attack();
	}
	
	
	
}
