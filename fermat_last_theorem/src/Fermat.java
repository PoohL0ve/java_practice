import java.util.Scanner;
/**
 * Fermat last theorem stated that a^n + b^n = c^n only when n <= 2
 * This program is testing to see if that's the case
 * */
public class Fermat {
    public static void main(String[] args) {
        // Using Scanner class to collect 4 integers
        Scanner number = new Scanner(System.in);

        System.out.println("Enter four integers to be tested: ");

        int numA = number.nextInt();
        int numB = number.nextInt();
        int numC = number.nextInt();
        int checkN = number.nextInt();
        // function with the user defined integers as arguments
        findTruth(numA, numB, numC, checkN);
    }
    // Method to test the theorem
    public static void findTruth(int a, int b, int c, int n) {

        double valueA = Math.pow(a, n);
        double valueB = Math.pow(b, n);
        double valueC = Math.pow(c, n);
        System.out.println(valueC);
        double addSome = valueA + valueB;
        int testNum = 2;

        // condition to test the statement
        if (addSome == valueC && n > testNum) {
            System.out.println("Guess the theory needs to be evaluated");
        } else if (n <= testNum && addSome == valueC) {
            System.out.println("Holy shit, the theory stands");
        } else {
            System.out.println("The theory is flawed");
        }
    }
}
