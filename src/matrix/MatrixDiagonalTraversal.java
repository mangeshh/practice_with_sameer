package matrix;

/**
 * Vivekananda - algorithm a day
 */
public class MatrixDiagonalTraversal {

    public static void printMatrixDiagonally(char[][] matrix) {

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        /*
           Comic-style explanation:

           Phase 1: Start from each row in first column
             (0,0), (1,0), (2,0), ...

           Phase 2: Start from each column in last row (excluding first column)
             (2,1), (2,2), (2,3), ...

           For each starting point:
             Walk diagonally upward-right:
               i--, j++
        */

        // Phase 1: diagonals starting from first column
        for (int startingRow = 0; startingRow < totalRows; startingRow++) {

            int currentRow = startingRow;
            int currentColumn = 0;

            while (currentRow >= 0 && currentColumn < totalColumns) {
                System.out.print(matrix[currentRow][currentColumn] + " ");
                currentRow--;
                currentColumn++;
            }

            System.out.println();
        }

        // Phase 2: diagonals starting from bottom row (excluding first column)
        for (int startingColumn = 1; startingColumn < totalColumns; startingColumn++) {

            int currentRow = totalRows - 1;
            int currentColumn = startingColumn;

            while (currentRow >= 0 && currentColumn < totalColumns) {
                System.out.print(matrix[currentRow][currentColumn] + " ");
                currentRow--;
                currentColumn++;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
           Sample Matrix:

               d e j n
               s t a b
               x y z w

           Dry Run:

           Phase 1:
             → d
             → s e
             → x t j
             → y a n
             → z b
             → w

           Output:
             d
             s e
             x t j
             y a n
             z b
             w
        */

        char[][] matrix = {
            {'d', 'e', 'j', 'n'},
            {'s', 't', 'a', 'b'},
            {'x', 'y', 'z', 'w'}
        };

        printMatrixDiagonally(matrix);
    }
}
