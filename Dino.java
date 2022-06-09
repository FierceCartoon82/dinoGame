package dinosaurGame;

import java.util.Random;

public class Dino {
	// declare & instantiate rand obj
	Random rand = new Random();
	
	// declare private instance data
	private String name;
	private int health, attackmin1, attackmax1, attackmin2, attackmax2,
	defensemin1, defensemax1, defensemin2, defensemax2;
	
	// blank constructor class
	public Dino() {
		
	}
	
	// init instance data
	public Dino(String name, int health, int attackmin1, int attackmin2, int attackmax1, 
			int attackmax2, int defensemin1, int defensemin2, int defensemax1, int defensemax2) {
		this.name = name;
		this.health = health;
		this.attackmin1 = attackmin1;
		this.attackmax1 = attackmax1;
		this.attackmin2 = attackmin2;
		this.attackmax2 = attackmax2;
		this.defensemin1 = defensemin1;
		this.defensemax1 = defensemax1;
		this.defensemin2 = defensemin2;
		this.defensemax2 = defensemax2;
	}
	
	// getAttack instance method
	public int getAttack(int attack) {
		// conditionals to act off of user input
		if (attack == 1) {
			// return rand value
			return rand.nextInt(attackmax1 - attackmin1 + 1) + attackmin1;
			
		} else {
			
			// return rand value
			return rand.nextInt(attackmax2 - attackmin2 + 1) + attackmin2;
			
		}
	}
	
	// getDefense instance method
	public int getDefense(int attack) {
		if (attack == 1) {
			
			// return rand value 
			return rand.nextInt(defensemax1 - defensemin1 + 1) + defensemin1;
			
		} else {
			
			// return rand value
			return rand.nextInt(defensemax2 - defensemin2 + 1) + defensemin2;
		}
	}
	
	// getHealth instance method
	public int getHealth() {
		return health;
	}
	
	// userHealth instance method
	public int uHealth(int compAttack, int userDefense) {
		if (compAttack > userDefense) {
			// calculate health (only if comp attack does damage)
			int difference = compAttack - userDefense;
			
			// ensure health is not negative
			if (health >= difference) {
				health -= difference;
			} else {
				health = 0;
			}
		}
		// return health
		return health;
	}
	
	// compHealth instance method
	public int cHealth(int userAttack, int compDefense) {
		if (userAttack > compDefense) {
			// calculate health only if user attack does damage
			int difference = userAttack - compDefense;
			
			// ensure health is not negative
			if (health >= difference) {
				health -= difference;
			} else {
				health = 0;
			}
		}
		// return health
		return health;
	}
	
	// setHealth method
	public void setHealth(int newHealth) {
		this.health = newHealth;
	}
	
	// toString instance method
	public String toString() {
		return "Dinosaur: " + name + " --- Health Remaning: " + health;
	}
}
