import java.util.Scanner;


public class TossGame {
public static void main(String[]args){
    CoinToss test = new CoinToss();
    int choice;

    System.out.println("Welcome to CIT 360!");
    System.out.println("Lets see if your ready to learn, and be self motivated so you can get the best out of this class. Lets start by tossing the coin of truth!");

        do{
            System.out.print("Enter 1 to toss coin or enter 0 to quit: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            if (choice == 1){
            test.flip();
        }
            else if (choice > 1){
            System.out.println("Invalid entry - please enter 1 or 0: ");
            choice = input.nextInt();
            }
        }while (choice != 0);

      if(choice == 0){
    	  System.out.println(" I feel like this class is like a coin toss, When people feel motivated or feel willing to actually learn.");
    	  System.out.println(" Instead of being forced fed there education I feel like you can get a lot out of it. However a lot of people");
    	  System.out.println(" have days where they do not feel like doing anything and at that point you would need to take a break and come back to get the most out of it.");
      }


}

}