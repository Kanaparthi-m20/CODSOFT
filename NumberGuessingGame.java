
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int count = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (count < attempts) {
                System.out.print("Enter your guess: ");
                int number= scanner.nextInt();
                count++;

                if (number== targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + count + " attempts.");
                    score++;
                    //guessedCorrectly = true;
                    break;
                } else if (number< targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (false) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String str= scanner.next().toLowerCase();
            if (!str.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! Your total score is: " + score);
        scanner.close();
    }
}
