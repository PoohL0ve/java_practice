public class TimesTable {
    public static void main(String[] args) {
        // Showing multiplication up to 15 using a for loop
        for (int number = 1; number <= 15; number++) {
            for (int figure = 1; figure <= 15; figure++) {
                System.out.printf("%5d", number * figure);
                // "%5d" gives a space of 5 characters
            }
            System.out.println();
        }
    }
}
