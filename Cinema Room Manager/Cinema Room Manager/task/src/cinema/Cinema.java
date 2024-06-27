package cinema;
import java.util.*;

/**
 * The program represents a simple cinema room,
 * which allows user to purchase tickets
 * for available seats.
 * @author PoohLove (SWH)
 */
public class Cinema {
    public static int[][] cinemaSeats;
    public static int rows;
    public static int columns;
    public static List<int[]> purchasedSeats = new ArrayList<>();
    public static int currentIncome = 0;

    /**
     * Constructor that creates the arrangements of the
     * layout for the cinema room.
     * @param lanes represent the rows
     * @param aisles represents the columns
     */
    public Cinema(int lanes, int aisles) {
        this.rows = lanes;
        this.columns = aisles;
        cinemaSeats = new int[lanes][aisles];
    }
    public static void main(String[] args) {
        // create cinema object
        Cinema theatre;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of rows:");
            int horizontal = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the number of seats in each row:");
            int vertical = scanner.nextInt();
            scanner.nextLine();

            // call the constructor method
            if ((horizontal <= 9) && (vertical <= 9)) {
                theatre = new Cinema(horizontal, vertical);
            } else {
                System.out.println("The values most be least than or equal to 9");
            }
            System.out.println();
            do {
                getMenu();
                int option = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                if (option == 0) {
                    break;
                } else {
                    chooseAnItem(option);
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter integers");
        }
    }

    /**
     * Displays the options to the user.
     */
    public static void getMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    /**
     * Calls the relevant method based on the
     * input by the user.
     * @param item integer value
     */
    public static void chooseAnItem(int item) {
        switch (item) {
            case 1 : displaySeats(cinemaSeats, purchasedSeats);
                break;
            case 2 : ticketPrice();
                break;
            case 3: showStats();
                break;
        }
    }

    /**
     * Checks to see if a ticket has already been purchases.
     * If the seat is already taken it return true otherwise
     * false.
     * @param purchasedSeats list of bought seats
     * @param row represents the row
     * @param col represents the column
     * @return true or false
     */
    public static boolean isBought(List<int[]> purchasedSeats, int row, int col) {
        boolean bought = false;
        for (int[] seat : purchasedSeats) {
            if (row == seat[0] && col - 1 == seat[1]) {
                bought = true;
                break;
            }
        }
        return bought;
    }

    /**
     * Adds the seat to a list to ensure that it cannot be purchased
     * again.
     * @param row represents the row
     * @param lane represents the column
     */
    public static void secureSeat(int row, int lane) {
        int[] seat = {row, lane -2};
        purchasedSeats.add(seat);
    }

    /**
     * Display the seating arrangements of the cinema. If a
     * seat is already bought, it will display a 'B'
     * character or an 'S' otherwise.
     * @param seats the cinema object
     * @param boughtSeats the seats that are bought
     */
    public static void displaySeats(int[][] seats, List<int[]> boughtSeats) {
        char chair; // contains the values S or B to display

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j = 1; j <= seats.length; j++) {
            System.out.print(j + " ");
            for (int l = 0; l < seats[1].length; l++) {
                if ((isBought(boughtSeats, j, l))) { // calls the isBought method
                    chair = 'B';
                } else {
                    chair = 'S';
                }
                System.out.print(chair + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Displays the cost of a ticket by calling the
     * {@code getTicketPrice} method. If the row and
     * lane numbers are less than or equal to
     * the values used to create the cinema room, the
     * method works fine. If not, it keeps looping
     * until the user enters the correct values
     */
    public static void ticketPrice() {
        boolean check = false;

        // get the input from the user
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a row number: ");
            int row = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter a seat number in that row: ");
            int seat = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            // check to see if the seat is available
            if (row <= rows && seat <= columns) {
                check = isBought(purchasedSeats, row, seat - 1);
                if (check) {
                    System.out.println("That ticket has already been purchased!");
                    System.out.println();
                } else {
                    getTicketPrice(row);
                    secureSeat(row, seat);
                    break;
                }
            } else {
                System.out.println("Wrong input!");
                System.out.println();
            }
        }
    }

    /**
     * Calculates the cost of a ticket based on the seat of the
     * user.
     * @param aisle the row number
     */
    public static void getTicketPrice(int aisle) {
        int total = 0;
        int front = rows / 2;
        int back = rows - front;
        int frontSeats = front * cinemaSeats.length;

        if (rows * columns <= 60) {
            total += 10;
            System.out.println("Ticket price: $" + total);
        } else if (rows * columns > 60) {
            if (aisle * columns <= frontSeats) {
                total += 10;
                System.out.println("Ticket price: $" + total);
            } else if (aisle * columns > frontSeats) {
                total += 8;
                System.out.println("Ticket price: $" + total);
            }
        }
        currentIncome += total;
        System.out.println();
    }

    /**
     * Display the statistics of the cinema in regard
     * to the percentage of seats bought,
     * potential income, the current income,
     * and the number of seats bought.
     */
    public static void showStats() {
        int ticketsBought = purchasedSeats.size();
        double percentage = 0.0D;
        int currentTotal = currentIncome;
        int potentialIncome = 0;

        // calculating the percentage
        int total = 0;
        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 1; j <= cinemaSeats[i].length; j++) {
                total += 1;
            }
        }
        double value = (double) (ticketsBought * 100) / total;
        double roundNum = Math.round(value * 100.0) / 100.0;
        if (value - roundNum >= 0.005) {
            roundNum += 0.01;
            percentage = roundNum;
        } else {
            percentage = roundNum;
        }

        // calculates the potential income of the cinema
        if (total <= 60) {
            potentialIncome += total * 10;
        } else if (total > 60) {
            int first = (cinemaSeats.length / 2) * cinemaSeats[1].length;
            int second = total - first;
            potentialIncome = (first * 10) + (second * 8);
        }
        String percentValue = String.format("%.2f", percentage);
        System.out.println("Number of purchased tickets: " + ticketsBought);
        System.out.println("Percentage: " + percentValue + "%");
        System.out.println("Current income: $" + currentTotal);
        System.out.println("Total income: $" + potentialIncome);
        System.out.println();
    }
}