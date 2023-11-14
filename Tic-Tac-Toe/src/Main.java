import java.util.*;
public class Main {
    public static void main(String[] args) {

        // grid container
        char[][] grid = new char[3][3];
        char space = ' ';

        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = space;
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");

        char play = 'X';
        Scanner scanner = new Scanner(System.in);
        // main loop to control the play
        for (int index = 0; index < 9; index++) {
            if (index == 0 || index % 2 == 0) {
                play = 'X';
            } else {
                play = 'O';
            }

            while (true) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();

                if (first >= 1 && first <= 3) {
                    if (second >= 1 && second <= 3) {
                        if (grid[first-1][second-1] == '_' || grid[first-1][second-1] == ' ') {
                            grid[first-1][second-1] = play;
                            break;
                        }
                    } else {
                        System.out.println("Cordinates should be from 1 to 3");
                    }
                } else {
                    System.out.println("Cordinates should be from 1 to 3");
                }

            }
            System.out.println("---------");
            for (int i = 0; i < grid.length; i++) {
                System.out.print("|" + " ");
                for (int l = 0; l < grid[i].length; l++) {
                    System.out.print(grid[i][l] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("---------");
            if (index >= 4) {
                boolean xWins = checkWin(grid, 'X');
                boolean oWins = checkWin(grid, 'O');
                boolean impossible = Math.abs(countChar(grid, 'X') - countChar(grid, 'O')) >= 2;
                boolean gameNotFinished = !xWins && !oWins && countChar(grid, '_') > 0;

                if (impossible || (xWins && oWins)) { // (xWins && oWins)
                    System.out.println("Impossible");
                } else if (xWins) {
                    System.out.println("X wins");
                    break;
                } else if (oWins) {
                    System.out.println("O wins");
                    break;
                } else if (gameNotFinished) {
                    System.out.println("Game not finished");
                } else {
                    System.out.println("Draw");
                }
            }
        }
    }
    public static boolean checkWin(char[][] gameGrid, char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (gameGrid[row][0] == player && gameGrid[row][1] == player && gameGrid[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (gameGrid[0][col] == player && gameGrid[1][col] == player && gameGrid[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (gameGrid[0][0] == player && gameGrid[1][1] == player && gameGrid[2][2] == player) {
            return true;
        }

        if (gameGrid[0][2] == player && gameGrid[1][1] == player && gameGrid[2][0] == player) {
            return true;
        }

        return false;
    }

    public static int countChar(char[][] gameGrid, char character) {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameGrid[row][col] == character) {
                    count++;
                }
            }
        }
        return count;
    }
}
