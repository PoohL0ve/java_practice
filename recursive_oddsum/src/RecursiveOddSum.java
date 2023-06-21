import java.util.Scanner;
public class RecursiveOddSum {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        // Getting the odd integer from the user
        System.out.println("Enter an odd number and see the sum of the number before it, including itself: ");
        int oddNumber = scanner.nextInt();
        // Calling the method
        System.out.println(oddSum(oddNumber));
    }
    // Using a recursive function to compute the sum
    public static int oddSum(int number) {
        System.out.println(number);
        if (number == 1) {
            return 1;
        }
        if (number % 2 == 0 && number > 1) {
            return oddSum(number - 1);
        }
        return number + oddSum(number - 1);
        //return number;
    }
}
