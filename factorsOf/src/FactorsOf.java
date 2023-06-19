import java.util.Scanner;
public class FactorsOf {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] listOfNumbers = {2, 4, 6, 8, 10};
        // adding the function "areFactors" to the main
        System.out.print(areFactorsOf(number, listOfNumbers));
    }
    public static boolean areFactorsOf(int n, int[] yourNumbers) {
        int check = 0;
        for (int value : yourNumbers) {
            if (n % value == 0) {
                check += 1;
            }
        }
        return check == yourNumbers.length;
    }
}
