import java.util.Scanner;

public class tic_tac_toe {
    static char[][] gameBoard = new char[3][3]; // assigning game board of 3 X 3
    static Scanner sc = new Scanner(System.in);

    // creating a method to initalize a game board
    public static void initalizeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }
    
    // creating a method to print the board
    public static void printBoard() {
        System.out.println("\n   0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBoard[i][j] + " ");
                if (j < 2)
                    System.out.print("|");
            }
            System.out.println();
            if (i < 2)
                System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // asking player for move
    public static void playerMove(char player) {
        int row;
        int col;

        while (true) {
            System.out.println(
                    "player : " + player + ", enter your move from row[0-2] &&  col[0-2]");
            row = sc.nextInt();
            col = sc.nextInt();

            if (row >= 0
                    && row < 3
                    && col >= 0
                    && col < 3
                    && gameBoard[row][col] == '-') { // this will make sure that player is entering a valid move
                gameBoard[row][col] = player; // if move is right it will place the relative x or o at that move
                break;
            } else {
                System.out.println("invalid move try again ");
            }
        }
    }

    // write a method for checking the checkWinner
    public static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == player
                    && gameBoard[i][1] == player
                    && gameBoard[i][2] == player) // this will check the row if row is making a winning line or
                // not
                return true;
            if (gameBoard[0][i] == player
                    && gameBoard[1][i] == player
                    && gameBoard[2][i] == player) // this will check the column if column is making a winning
                // line or not
                return true;
        }

        if (gameBoard[0][0] == player
                && gameBoard[1][1] == player
                && gameBoard[2][2] == player) { // this will check the normal diagonal
            return true;
        }
        if (gameBoard[0][2] == player
                && gameBoard[1][1] == player
                && gameBoard[2][0] == player) { // this will check the second diagonal
            return true;
        }
        return false;
    }

    // this method will check if the board is full and if it is then game will be
    // draw
    public static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initalizeBoard();
        char currentPlayer = 'X';

        while (true) {
            printBoard();
            playerMove(currentPlayer);

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("it's draw");
                break;
            }
            currentPlayer = (currentPlayer == 'X')
                    ? 'O'
                    : 'X'; // this will make sure if last player was x then second player
            // will be o and visa versa
        }
    }
}
