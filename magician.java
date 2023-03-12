package kadai10;

public class Magician {
	// フィールド
	 private String name;
	 private int hp;
	 private int mp;
	 
	// コンストラクタ
	 Magician(String name) {
		 this.hp = 100;
		 this.name = name;
	 }
	 
	 Magician() {
		 
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
	 
	 public int getMp() {
		 return this.hp;
	 }
	 
	 public void setMp(int mp) {
		 if(mp < 0) {
			 this.mp = 0;
		 } else {
			 this.mp = mp;
		 }
	 }

	 // メソッド
	 public void strikeAttack() {
		 // 5ダメージ
		 System.out.println(this.name + "の打撃攻撃!");
	 }
	 
	 public String magicAttack() {
		 // 15ダメージ
		 if((this.mp - 5) < 0) {
			 String s = "しかし、MPが足りない!";
			 return s;
		 } else {
			 this.mp = this.mp - 5;
			 String s = "5mpを消費して敵にダメージを与えた";
			 return s;
		 } 
	 }

	 
	 public void recovery() {
		 if(this.mp < 0) {
			 System.out.println("MPが足りない!");
		 } else {
			 System.out.println(this.name + "が回復魔法を使用した");
			 this.hp = this.hp + 20;
		 }
		 
	 }
	 
	 public void heal() {
		 System.out.println("魔法使いが休憩した");
		 this.hp = this.hp + 10;
	}
}
