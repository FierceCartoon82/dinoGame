package dinosaurGame;

import java.util.Scanner;
import java.util.Random;

public class dinoBattle {

	public static void main(String[] args) {
		// instantiate scanner
		Scanner input = new Scanner(System.in);
		
		// instantiate random obj
		Random rand = new Random();
		
		// declare variables
		int user, comp, min, max;
		int userAttack, userDefense, compAttack, compDefense, turn, uGuess, cHealth, uHealth;

		// prompt user
		System.out.println("Please select a Dino: ");
		System.out.println("1 - T-Rex\nHealth - 20hp\nDamage: Aggressive: 6 - 10hp or Defense: 4 - 8hp"
				+ "\nDefense: Aggressive: 0 - 2hp or Defense: 3 - 5hp");
		System.out.println("\n2 - Paradactyl\nHealth - 40hp\nDamage: Aggressive: 3 - 6h or Defense: 1 - 4hp"
				+ "\nDefense: Aggressive: 1 - 3hp or Defense: 4 - 8hp");
		System.out.println("\n3 - Velociraptor\nHealth - 30hp\nDamage: Aggressive: 4 - 8hp or Defense: 2 - 6hp"
				+ "\nDefense: Aggressive: 1 - 4hp or Defense: 2 - 6hp");
		
		user = input.nextInt();
		
		// determine comp selection (different than user)
		do {
			comp = rand.nextInt(3) + 1;
		} while (comp == user);
		
		// declare user and dino objects
		Dino userDino = new Dino();
		Dino compDino = new Dino();
		
		// conditionals to init Dino user object
		if (user == 1) {
			userDino = new Dino("T-Rex", 20, 6, 4, 10, 8, 0 ,3, 2, 5);
		} else if (user == 2) {
			userDino = new Dino("Paradactyl", 40, 3, 1, 6, 4, 1 ,4, 3, 8);
		} else if (user == 3) {
			userDino = new Dino("Velociraptor", 30, 4, 2, 8, 6, 1, 2, 4, 6);
		} 
		
		// conditionals to init Dino comp object
		if (comp == 1) {
			compDino = new Dino("T-Rex", 20, 6, 4, 10, 8, 0 ,3, 2, 5);
		} else if (comp == 2) {
			compDino = new Dino("Paradactyl", 40, 3, 1, 6, 4, 1 ,4, 3, 8);
		} else {
			compDino = new Dino("Velociraptor", 30, 4, 2, 8, 6, 1, 2, 4, 6);
		} 
		
		// output both dinosaurs' stats
		System.out.println("\nUser " + userDino.toString() + "\nComputer " + compDino.toString());
		
		
		// determine turn
		turn = rand.nextInt(2) + 1;
		
		// prompt user
		System.out.println("\nPick a number between 1 & 2 to determine the first turn");
		uGuess = input.nextInt();
		
		// conditionals to determine who won
		if (uGuess == turn) {
			System.out.println("\nYou guesssed correctly!");
			turn = 1;
		} else {
			System.out.println("\nYou guessed incorrectly.");
			turn = 2;
		}
		
		
		
		// run while both dinos are alive
		do {
			// get user & comp health
			uHealth = userDino.getHealth();
			cHealth = compDino.getHealth();
			
			if(turn == 1) {
				// prompt user
				System.out.println("It's your turn to attack!\nSelect how you want to act:\n   1 - Aggressive\n   2 - Defensive");
				user = input.nextInt();
				
				// randomize computer choice
				comp = rand.nextInt(3) + 1;
				
				// get rand # from method for damages
				userAttack = userDino.getAttack(user);
				userDefense = userDino.getDefense(user);
				compDefense = compDino.getDefense(comp);
				compAttack = compDino.getAttack(comp);
				
				/// find healths 
				cHealth = compDino.cHealth(userAttack, compDefense);
				uHealth = userDino.uHealth(compAttack, userDefense);
				
				// set healths
				compDino.setHealth(cHealth);
				userDino.setHealth(uHealth);
				
				// output both dinosaurs' stats 
				System.out.println("\nUser " + userDino.toString() + "\nComputer " + compDino.toString());
				
				// conditonals for winning/losing
				if (uHealth == 0) {
					System.out.println("User Health: 0");
					System.out.println("You Lose!");
					break;
				}
				
				if (cHealth == 0) {
					System.out.println("Compture Health: 0");
					System.out.println("You WIN!");
					break;
				}
				
				// change the turn
				turn = 2;
			} else if (turn == 2) {
				// randomize computer's choice
				comp = rand.nextInt(3) + 1;
				
				// prompt the user
				System.out.println("The computer is attacking. Select how you want to react:\n1 - Aggressive\n2 - Defensive\n");
				user = input.nextInt();
				
				// determine if comp is aggressive or defensive
				comp = rand.nextInt(3) + 1;
				
				// call methods for each dino & store values
				userAttack = userDino.getAttack(user);
				userDefense = userDino.getDefense(user);
				compDefense = compDino.getDefense(comp);
				compAttack = compDino.getAttack(comp);
				
				// find healths 
				cHealth = compDino.cHealth(userAttack, compDefense);
				uHealth = userDino.uHealth(compAttack, userDefense);
				
				// set healths
				compDino.setHealth(cHealth);
				userDino.setHealth(uHealth);
				
				// output both dinosaurs' stats 
				System.out.println("\nUser " + userDino.toString() + "\nComputer " + compDino.toString());
				
				// conditionals to determine winner
				if (uHealth == 0) {
					System.out.println("User Health: 0");
					System.out.println("You Lose!");
					break;
				}
				
				if (cHealth == 0) {
					System.out.println("Compture Health: 0");
					System.out.println("You WIN!");
					break;
				}
				
				// change the turn
				turn = 1;
			}
			
		} while (uHealth > 0 && cHealth > 0);
	}

}
