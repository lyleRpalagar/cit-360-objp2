import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		// String
		//creating a new scanner object that is passing in System.in
         Scanner input = new Scanner(System.in);
         
         //prompt to ask the user to do something
         System.out.println("Enter a line of text: ");
         
         // wait for them to enter a line of text
         String line = input.nextLine();
         
         // outputting what the user has entered
         System.out.println("You entered: " + line);
         
         
         // INT
         Scanner number_input = new Scanner(System.in);
         System.out.println("Enter an Integer: ");
         int value = number_input.nextInt();
         System.out.println("You entered: " + value);
         
         // Double
         Scanner double_input = new Scanner(System.in);
         System.out.println("Enter a floating point value: ");
         double double_value = double_input.nextDouble();
         System.out.println("You entered: " + double_value);
         
         
	}

}
