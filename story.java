package kadai10;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Story {
	public static void main(String args[]) {
		// ヒーローの生成
		Scanner scan = new Scanner(System.in);
	
		SuperHero sh = new SuperHero();
		
		System.out.println("勇者の名前を設定してください");
		sh.setName(scan.nextLine());
		
		System.out.println("勇者の体力を設定してください");
		sh.setHp(scan.nextInt());
		
		System.out.println("勇者の攻撃力を設定してください");
		sh.setAt(scan.nextInt());
		
		System.out.println("勇者の防御力を設定してください");
		sh.setDf(scan.nextInt());
		
		System.out.println("勇者が誕生した");
		System.out.println("名前:" + sh.getName());
		System.out.println("体力:" + sh.getHp());
		System.out.println("攻撃力:" + sh.getAt());
		System.out.println("防御力:" + sh.getDf());
		
		// モンスターの生成
		Scanner scan2 = new Scanner(System.in);
		
		SuperMonster sm = new SuperMonster();
		System.out.println("モンスターの名前を設定してください");
		sm.setName(scan2.nextLine());
		
		System.out.println("モンスターの体力を設定してください");
		sm.setHp(scan2.nextInt());
		
		System.out.println("モンスターの攻撃力を設定してください");
		sm.setAt(scan2.nextInt());
		
		System.out.println("モンスターの防御力を設定してください");
		sm.setDf(scan2.nextInt());
		
		System.out.println("モンスターの毒攻撃の回数を設定してください");
		sm.setPAC(scan2.nextInt());
		
		System.out.println("モンスターが誕生した");
		System.out.println("名前:" + sm.getName());
		System.out.println("体力:" + sm.getHp());
		System.out.println("攻撃力:" + sm.getAt());
		System.out.println("防御力:" + sm.getDf());
		System.out.println("毒攻撃回数:" + sm.getPAC());
		
		// 魔法使いの生成
		Scanner scan3 = new Scanner(System.in);
		
		SuperMagician smg = new SuperMagician();
		System.out.println("魔法使いの名前を設定してください");
		smg.setName(scan3.nextLine());
		
		System.out.println("魔法使いの体力を設定してください");
		smg.setHp(scan3.nextInt());
		
		System.out.println("魔法使いの魔力を設定してください");
		smg.setMp(scan3.nextInt());
		
		System.out.println("魔法使いが誕生した");
		System.out.println("名前:" + smg.getName());
		System.out.println("体力:" + smg.getHp());
		System.out.println("魔力:" + smg.getMp());
		
		scan.close();
		scan2.close();
		scan3.close();
		
//		sh.doubleAttack();
		
		while((sh.getHp() > 0 && smg.getHp() > 0) || sm.getHp() > 0) {
			// 行動の数だけランダムに数字を生成
			// ヒーローがどの行動をするか
			double rand_hero = Math.random() * 3 + 1;
			int select_act_hero = (int)rand_hero;
			
			double rand_magician = Math.random() * 5 + 1;
			int select_act_magician = (int)rand_magician;
			
			double rand_monster = Math.random() * 2 + 1;
			int select_act_monster = (int)rand_monster;
			
			int damage = 0;
			
//			 ヒーローの行動
			if(!(sh.getHp() <= 0)) {
				if(select_act_hero == 1) {
					sh.doubleAttack();
					if(sh.getAt() - sm.getDf() < 0) {
						damage = 1;
					} else {
						damage = (sh.getAt() - sm.getDf());
					}
					
					System.out.println(sm.getName() + "にダメージを" + (damage * 2) + "与えた!");
					int new_hp = sm.getHp() - (damage * 2);
					sm.setHp(new_hp);
					
				} else if(select_act_hero == 2) {
					
					if(sh.getDf() == 100) {
						System.out.println("これ以上防御力は上がらない!");
					} else if(sh.getDf() + 10 > 100) {
						sh.defense();
						sh.setDf(100);
					} else  {
						sh.defense();
					}
			
				} else if(select_act_hero == 3) {
					
					if(sh.getHp() == 100) {
						System.out.println(sh.getName() + "はこれ以上休憩できない!");
					} else if(sh.getHp() + 10 > 100) {
						sh.heal();
						System.out.println(sh.getName() + "のhpが10回復し100になった");
						sh.setHp(100);
					} else {
						sh.heal();
						System.out.println(sh.getName() + "のhpが20回復し" + smg.getHp() + "になった");
					}
					
				}
			}
			
			// 魔法使いの行動
			if(!(smg.getHp() <= 0)) {
				if(select_act_magician == 1) {
					
					// 超魔法攻撃				
					if(30 - sm.getDf() < 0) {
						damage = 1;
					} else {
						damage = 30 - sm.getDf();
					}
					
					System.out.println(smg.getName() + "の超魔法攻撃!");
					
					if(smg.hyperMagicAttack() == "しかし、MPが足りない!") {
						System.out.println(smg.hyperMagicAttack());
					} else if(smg.hyperMagicAttack() == "10mpを消費して敵にダメージを与えた") {
						System.out.println("10mpを消費して敵にダメージを" + damage + "与えた！");
						int new_hp = sm.getHp() - damage;
						sm.setHp(new_hp);
					}
					
				} else if(select_act_magician == 2) {
					
					// 打撃攻撃
					if(5 - sm.getDf() < 0) {
						damage = 1;
					} else {
						damage = 5 - sm.getDf();
					}
					
					smg.strikeAttack();
					System.out.println(sm.getName() + "にダメージを" + damage + "与えた！");
					int new_hp = sm.getHp() - damage;
					sm.setHp(new_hp);
					
				} else if(select_act_magician == 3) {
					
					// 魔法攻撃
					if(15 - sm.getDf() < 0) {
						damage = 1;
					} else {
						damage = 15 - sm.getDf();
					}
					
					System.out.println(smg.getName() + "の魔法攻撃!");
					
					if(smg.magicAttack() == "しかし、MPが足りない!") {
						System.out.println(smg.magicAttack());
					} else if(smg.magicAttack() == "5mpを消費して敵にダメージを与えた") {
						System.out.println("5mpを消費して敵にダメージを" + damage + "与えた！");
						int new_hp = sm.getHp() - damage;
						sm.setHp(new_hp);
					}
					
				} else if(select_act_magician == 4) {
					
					// 回復魔法
					if(smg.getHp() == 100) {
						System.out.println("これ以上回復できない!");
					} else if(smg.getHp() + 20 > 100) {
						smg.recovery();
						System.out.println("hpが20回復し100になった");
						smg.setHp(100);
					} else {
						smg.recovery();
						System.out.println("hpが20回復し" + smg.getHp() + "になった");
					}
					
				} else if(select_act_magician == 5) {
					
					// 休憩
					if(smg.getHp() == 100) {
						System.out.println("これ以上休憩できない!");
					} else if(smg.getHp() + 10 > 100) {
						smg.heal();
						System.out.println("hpが10回復し100になった");
						smg.setHp(100);
					} else {
						smg.heal();
						System.out.println("hpが20回復し" + smg.getHp() + "になった");
					}
					
				}
			}
			
			// モンスターの行動
			// 誰を攻撃するか
			double tmp = Math.random() * 2 + 1;
			int selectEnemy = (int)tmp;
			
			if(sh.getHp() <= 0) {
				selectEnemy = 2;
			} else if(smg.getHp() <= 0){
				selectEnemy = 1;
			}
			
			if(select_act_monster == 1) {
				if(selectEnemy == 1 && sh.getHp() > 0) {
					//　勇者に攻撃
					if(sm.getAt() - sh.getDf() < 0) {
						damage = 1;
					} else {
						damage = sm.getAt() - sh.getDf();
					}
					
					sm.attack();
					System.out.println(damage + "のダメージを勇者に与えた");
					int new_hp = sh.getHp() - damage;
					sh.setHp(new_hp);
					
					if(sm.poisonAttack() == "毒攻撃が出来ない!") {
						System.out.println(sm.poisonAttack());
					} else if(sm.poisonAttack() == "毒攻撃をした") {
						System.out.println(sh.getName() + "に" + sm.poisonAttack());
						damage = 10;
						new_hp = sh.getHp() - damage;
						sh.setHp(new_hp);
					}
					
					
				} else if (selectEnemy == 2 && smg.getHp() > 0) {
					
					// 魔法使いに攻撃
					damage = sm.getAt();
					sm.attack();
					System.out.println(damage + "のダメージを魔法使いに与えた");
					int new_hp = smg.getHp() - damage;
					smg.setHp(new_hp);
					
					if(sm.poisonAttack() == "毒攻撃が出来ない!") {
						System.out.println(sm.poisonAttack());
					} else if(sm.poisonAttack() == "毒攻撃をした") {
						System.out.println(smg.getName() + "に" + sm.poisonAttack());
						damage = 10;
						new_hp = smg.getHp() - damage;
						smg.setHp(new_hp);
					}
					
				}
				
			} else if(select_act_monster == 2) {
				
				if(sm.getDf() == 100) {
					System.out.println("これ以上防御力は上がらない!");
				} else if(sm.getDf() + 10 > 100) {
					sm.defense();
					sm.setDf(100);
				} else  {
					sm.defense();
				}
				
			}
			
			
			if((sh.getHp() == 0 && smg.getHp() == 0)) {
				System.out.println("パーティが全滅した!");
				break;
			} else if(sm.getHp() == 0) {
				System.out.println("モンスターを倒した!");
				break;
			}
			
		}
		
		
	}
}
