/* Comparing static and non-static
* variables and methods */
public class Fruit { // the class name is Fruit
    /* The class variables are both static and non-static */

    // non-static instance variables
    String name;
    String colour;
    double price;
    int number;

    // static variables
    static final String STORE = "Fruit Deli"; // static constant variable
    static double salesTax = 0.20; // static common tax for all fruits

    // constructor
    Fruit(String name, String colour, double price, int number) {
        this.name = name;
        this.colour = colour;
        this.price = price;
        this.number = number;
    }
    // non-static method
   double getTotalCost() {
        double amount = this.price * this.number; // local variable
        double total = amount + (amount * salesTax); // uses static variable
        return total;
   }
   // static method
   static void displayStore() {
        System.out.println("This is " + STORE);
   }

    public static void main(String[] arg) {
        int i = 0;



        while (i < 3) {

            inner:

            for (int j = 0; j < 3; j++) {

                if (i == j)

                    break;

                if (j == 1)

                    continue inner;

                System.out.print(i + j + " ");

            }

            i++;

        }
    }
}
