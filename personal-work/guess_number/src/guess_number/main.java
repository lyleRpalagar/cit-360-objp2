package guess_number;

import java.util.Random;
import java.util.Scanner;

public class main {

	// declaring our variables
	public static int number, guess, maxValue;

	// declaring our java lib. classes
	public static Scanner scan;
	public static Random rand;

	public static void main(String[] args) {
		// Initialize our variables
		scan = new Scanner(System.in);
		rand = new Random();
		// ask the player what the range of number should be
		System.out.println("Please enter a max range to guess: ");
		maxValue = scan.nextInt();
		
		number = rand.nextInt(maxValue);

		System.out.print("Please enter a guess: ");
		while (guess != number) {
			guess = scan.nextInt();

			if (guess > number) {
				System.out.println("Your guess is too high!");
			}
			if (guess < number) {
				System.out.println("Your guess is too low!");
			}

		}
        System.out.println("You won!");
	}

}
