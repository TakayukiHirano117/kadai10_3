package kadai10;

public class Hero {
	// フィールド
	 private String name;
	 private int hp;
	 private int at;
	 private int df;
	 private static int money = 100;
	 
	 // コンストラクタ
	 Hero(String name, int hp) {
		 this.hp = hp;
		 this.name = name;
	 }
	 
	 Hero(String name, int hp, int at) {
		 this.name = name;
		 this.hp = hp;
		 this.at = at;
	 }
	 
	 Hero(String name) {
		 this.name = name;
	 }
	 
	 Hero() {
	 }
	 

	 // getter ・ setterメソッド
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 if(!(3 <= name.length() && name.length() <= 10)) {
			 throw new IllegalArgumentException("名前は3文字以上10文字以下で入力してください。");
		 }
		 this.name = name;
	 }
	 
	 public int getHp() {
		 return this.hp;
	 }
	 
	 public void setHp(int hp) {
		 if(hp < 0) {
			 this.hp = 0;
		 } else {
			 this.hp = hp;
		 }
	 }
	 
	 public int getAt() {
		 return this.at;
	 }
	 
	 public void setAt(int at) {
		 if(at < 0) {
			 this.at = 0;
		 } else {
			 this.at = at;
		 }
	 }
	 
	 public int getDf() {
		 return this.df;
	 }
	 
	 public void setDf(int df) {
		 if(df < 0) {
			 this.df = 0;
		 } else {
			 this.df = df;
		 }
	 }
	 
	 public int getMoney() {
		 return this.money;
	 }
	 
	 public void setMoney(int money) {
		 this.money = money;
	 }
	 
	// メソッド
	 public void attack() {
		 System.out.println(this.name + "の攻撃!");
	 }
	 
	 public void defense() {
		 System.out.println("勇者が防御をした");
		 if(this.df + 10 > 100) {
			 System.out.println("これ以上防御力を上げることはできない!");
			 this.df = 100;
		 } else {
			 System.out.println("防御力が10upし" + this.df + "になった");
			 this.df = this.df + 10;
		 }
		 
	 }
	 
	 public void heal() {
		 System.out.println("勇者が休憩した");
		 this.hp = this.hp + 10;
		 System.out.println("hpが10回復し" + this.hp + "になった");
	}
}
