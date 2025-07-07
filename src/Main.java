import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Random object called rnd.
        Random rnd = new Random();

        // Simulate rolling two dice [cite: 20, 21, 22]
        int die1 = rnd.nextInt(6) + 1; // Generates a random int between 1 and 6 [cite: 19]
        int die2 = rnd.nextInt(6) + 1; // Generates a random int between 1 and 6 [cite: 19]
        int crapsRoll = die1 + die2;   // Gaussian range from 2 to 12 as in rolling two dice [cite: 22]

        System.out.println("Die 1: " + die1);
        System.out.println("Die 2: " + die2);
        System.out.println("Sum: " + crapsRoll);


    }
}