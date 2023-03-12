package kadai10;

public class SuperMagician extends Magician {
	// フィールド
	private String name;
	private int mp;
	
	// メソッド
	
	public String hyperMagicAttack() {
//		System.out.println(this.name + "の超魔法攻撃!");
//		 10mpで30ダメージ
		 if((this.mp - 10) < 0) {
			 String s = "しかし、MPが足りない!";
			 return s;
		 } else {
//			 System.out.println(this.name + "の超魔法攻撃!");
			 this.mp = this.mp - 10;
			 String s = "10mpを消費して敵にダメージを与えた";
			 return s;
		 }
	}
	
	
}
