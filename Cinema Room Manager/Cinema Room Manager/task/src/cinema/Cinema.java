package cinema;

public class Cinema {

    public static void main(String[] args) {
        // multidimensional array for the seats in the cinema
        int[][] seats = new int[7][8];

        // character S to represent the seats
        char chairs = 'S';

        //printing title
        System.out.println("Cinema:");
        // printing numbers 1-8
        System.out.print(" ");
        for (int i = 1; i <= 8; i++) {
            System.out.print(" " +i);
        }
        // space for new line
        System.out.println();

        // iterating the multidimensional array
        for (int row = 1; row <= seats.length; row++) {
            System.out.print(row + " ");
            for (int col = 1; col <= 8; col++) {
                System.out.print(chairs + " ");
            }
            System.out.println();
        }
    }
}