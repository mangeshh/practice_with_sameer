package matrix;

/**
 * copiolet, simplified.
 */
public class SpiralTraversal {

    public static void printMatrixInSpiralOrder(int[][] matrix) {

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        // Boundaries that slowly shrink inward
        int topBoundary = 0;
        int bottomBoundary = totalRows - 1;
        int leftBoundary = 0;
        int rightBoundary = totalColumns - 1;

        /*
           Think of the matrix like an onion.
           We peel one layer at a time:

           1. left → right   (top row)
           2. top → bottom   (right column)
           3. right → left   (bottom row)
           4. bottom → top   (left column)

           Then we shrink the boundaries and repeat.
        */

        while (topBoundary <= bottomBoundary && leftBoundary <= rightBoundary) {

            // 1. Traverse from left to right across the top boundary
            for (int col = leftBoundary; col <= rightBoundary; col++) {
                System.out.print(matrix[topBoundary][col] + " ");
            }
            topBoundary++;  // top row is done

            // 2. Traverse from top to bottom along the right boundary
            for (int row = topBoundary; row <= bottomBoundary; row++) {
                System.out.print(matrix[row][rightBoundary] + " ");
            }
            rightBoundary--;  // right column is done

            // 3. Traverse from right to left across the bottom boundary
            if (topBoundary <= bottomBoundary) {
                for (int col = rightBoundary; col >= leftBoundary; col--) {
                    System.out.print(matrix[bottomBoundary][col] + " ");
                }
                bottomBoundary--;  // bottom row is done
            }

            // 4. Traverse from bottom to top along the left boundary
            if (leftBoundary <= rightBoundary) {
                for (int row = bottomBoundary; row >= topBoundary; row--) {
                    System.out.print(matrix[row][leftBoundary] + " ");
                }
                leftBoundary++;  // left column is done
            }
        }
    }

    public static void main(String[] args) {

        /*
           Sample Matrix:

               1   2   3
               4   5   6
               7   8   9

           Spiral Dry Run (comic-style):

           Layer 1:
             → 1 2 3
             ↓ 6 9
             ← 8 7
             ↑ 4

           Layer 2:
             → 5

           Final Spiral:
             1 2 3 6 9 8 7 4 5
        */

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        printMatrixInSpiralOrder(matrix);
    }
}
