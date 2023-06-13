import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] arg) {
        // random number between 1 and 25 inclusive
        Random random = new Random();
        int ranNumber = random.nextInt(26);

        // user guessed number
        Scanner scanner = new Scanner(System.in);

        // using a loop to provide 3 chances
        int chances = 3;

        while (chances > 0) {
            System.out.println("Guess a number between 1 and 25: ");
            int userNumber = scanner.nextInt();
            if (userNumber == ranNumber) {
                System.out.printf("Computer Number: %d\n", ranNumber);
                System.out.printf("Your Number: %d\n", userNumber);
                System.out.println("You guessed right");
                break;
            } else {
                int difference = ranNumber - userNumber;
                System.out.printf("The difference between the numbers is %d. Chances Left: %d\n", difference, chances);
            }
            chances -= 1;
        }
    }
}
