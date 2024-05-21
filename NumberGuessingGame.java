import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int totalScore = 0;
        int round = 1;

        while (true) {
            System.out.println("=== Round " + round + " ===");
            int generatedNumber = r.nextInt(100) + 1;
            int attempts = 10;
            int roundScore = 0;

            for (int i = 0; i < attempts; i++) {
                System.out.print("Enter your guess (1 to 100): ");
                int guess = sc.nextInt();

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number in " + (i + 1) + " attempts.");
                    roundScore = (11 - i);  // Points awarded based on attempts used
                    totalScore += roundScore;
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println("Try again. Your guess is too low.");
                } else {
                    System.out.println("Try again. Your guess is too high.");
                }
            }

            if (roundScore == 0) {
                System.out.println("You've used all attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your score for this round is: " + roundScore);
            System.out.println("Your total score so far is: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
        }

        System.out.println("=== Game Over ===");
        System.out.println("Thanks for playing! Your final total score is: " + totalScore);
        sc.close();
    }
}
