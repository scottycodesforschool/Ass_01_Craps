import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    private static final Random random = new Random(); // Random object for dice rolls
    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        boolean playAgain = true;

        // Loop to allow multiple games
        while (playAgain) {
            System.out.println("\n--- Starting a new game of Craps ---");
            playGame(); // Call the method to play one round of the game

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close(); // Close the scanner when the program ends
    }

    /**
     * Simulates one full round of the Craps game.
     */
    private static void playGame() {
        int die1 = rollDie();
        int die2 = rollDie();
        int sum = die1 + die2;

        System.out.printf("Initial Roll: Die 1 = %d, Die 2 = %d, Sum = %d%n", die1, die2, sum);

        // Check initial roll outcomes
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Result: Craps! You crapped out and lost.");
        } else if (sum == 7 || sum == 11) {
            System.out.println("Result: Natural! You won!");
        } else {
            // The sum becomes the 'point'
            int point = sum;
            System.out.printf("The sum is now the 'point': %d. Trying for point...%n", point);

            boolean gameContinues = true;
            while (gameContinues) {
                die1 = rollDie();
                die2 = rollDie();
                sum = die1 + die2;
                System.out.printf("Subsequent Roll: Die 1 = %d, Die 2 = %d, Sum = %d%n", die1, die2, sum);

                if (sum == point) {
                    System.out.println("Result: Made point! You won!");
                    gameContinues = false; // End the game
                } else if (sum == 7) {
                    System.out.println("Result: Got a seven! You lost.");
                    gameContinues = false; // End the game
                } else {
                    System.out.println("Status: Trying for point...");
                }
            }
        }
    }

    /**
     * Rolls a single die and returns a random integer between 1 and 6.
     * @return The value of the die roll.
     */
    private static int rollDie() {
        return random.nextInt(6) + 1; // Generates a number from 0-5, so add 1 for 1-6
    }
}
