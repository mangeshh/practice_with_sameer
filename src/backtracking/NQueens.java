public class NQueens {

    /*
        Comic-style intuition:

        We place queens row by row.

        For each row:
            - Try placing a queen in each column
            - Check if it's safe:
                • no queen in same column
                • no queen in left diagonal
                • no queen in right diagonal
            - If safe → place queen → move to next row
            - If not safe → try next column

        If we reach row == N:
            → We found a valid arrangement!
    */

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board with dots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQueen(board, 0, n);
    }

    private static void placeQueen(char[][] board, int currentRow, int n) {

        // Base case: all queens placed
        if (currentRow == n) {
            printBoard(board);
            System.out.println();
            return;
        }

        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, currentRow, col, n)) {
                board[currentRow][col] = 'Q';  // place queen
                placeQueen(board, currentRow + 1, n);  // move to next row
                board[currentRow][col] = '.';  // backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;  // safe spot
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
            Sample Input:
                n = 4

            Expected Output (one of the valid solutions):

                . Q . .
                . . . Q
                Q . . .
                . . Q .

            Another valid solution:

                . . Q .
                Q . . .
                . . . Q
                . Q . .
        */

        int n = 4;
        solveNQueens(n);
    }
}

