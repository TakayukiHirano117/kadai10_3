package kadai10;

public class Monster {
	// フィールド
	private String name;
	private int hp;
	private int at;
	private int df;
	
	// コンストラクタ
	 Monster(String name) {
		 this.hp = 100;
		 this.name = name;
	 }
	 
	 Monster() {
		 
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
	 
	 public  int getHp() {
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
	
	// メソッド
	public void attack() {
		 System.out.println(this.name + "の攻撃!");
//		 System.out.println(this.at + "のダメージ");
	 }
	 
	 public void defense() {
		 System.out.println(this.name + "は守りを固めた!");
		 this.df = this.df + 10;
		 System.out.println("防御力が10上がった");
	 }
}
