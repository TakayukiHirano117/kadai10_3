package kadai10;

public class SuperMonster extends Monster {
	// フィールド
	private String name;
	private int poisonAttackCount;
	
	// getter ・ setterメソッド
	public int getPAC() {
		return this.poisonAttackCount;
	}
	
	public void setPAC(int poisonAttackCount) {
		if(poisonAttackCount < 0) {
			 this.poisonAttackCount = 0;
		 } else {
			 this.poisonAttackCount = poisonAttackCount;
		 }
	}
	
	public String poisonAttack() {
		
		if((this.getPAC() - 1) < 0) {
			 String s = "毒攻撃が出来ない!";
			 return s;
		 } else {
			 this.poisonAttackCount = this.getPAC() - 1;
			 this.setPAC(this.poisonAttackCount);
			 String s = "毒攻撃をした";
			 return s;
		 }
	}
	
}
