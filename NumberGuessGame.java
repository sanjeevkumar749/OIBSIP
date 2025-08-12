import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7;      // Limit attempts per round
        int totalRounds = 3;      // Total number of rounds
        int score = 0;            // Total score

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts per round.");
        System.out.println("Let's begin!\n");

        for (int round = 1; round <= totalRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                    int roundScore = (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
                    score += roundScore;
                    System.out.println("You earned " + roundScore + " points.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + score + "\n");
        }

        System.out.println("Game Over!");
        System.out.println("Your Total Score: " + score);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}