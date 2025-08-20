import java.util.Random;
import java.util.Scanner;

public class GuessGame{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Computer picks a number between 1 and 100
        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100...");

        // Step 2: Loop until correct
        while (guess != secretNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt(); // Read input
            attempts++;

            // Step 3: Compare
            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}