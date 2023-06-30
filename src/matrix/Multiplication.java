package matrix;


/**
 * --  matrix a --
 * 1, 2, 1
 * 1, 2, 1
 * <p>
 * --  matrix b --
 * 2, 3
 * 1, 1
 * 2, 2
 */
public class Multiplication {

    public static void multiply(int[][] a, int[][] b) {

        int ans[][] = new int[a.length][b[0].length];

        System.out.print("a matrix rows " + a.length + ", ");
        System.out.println("columns " + a[0].length);
        System.out.print("b matrix rows " + b.length + ", ");
        System.out.println("columns " + b[0].length);

        System.out.println();
        int sum = 0;

        // print matrix - a
        System.out.println("matrix a");
        for (int l = 0; l < a.length; l++) {
            for (int n = 0; n < a[0].length; n++) {
                System.out.print(n < a[1].length - 1 ? a[l][n] + ", " : a[l][n]);
            }
            System.out.println();
        }

        System.out.println();
        // print matrix - b
        System.out.println("matrix b");
        for (int l = 0; l < b.length; l++) {
            for (int n = 0; n < b[0].length; n++) {
                System.out.print(n < b[1].length - 1 ? b[l][n] + ", " : b[l][n]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println("operations... ");


        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < b[0].length; k++) {
                for (int j = 0; j < a[0].length; j++) {
                    sum += a[i][j] * b[j][k];
                    if( j == 0){
                        System.out.print(" (a[" + i + "][" + j + "] * " + "b[" + j + "][" + (k) + "]) " );
                    }else{
                        System.out.print("+ (a[" + i + "][" + j + "] * " + "b[" + j + "][" + (k) + "]) " );
                    }
                }
                System.out.println("==> ans["+i+"]["+k+"] i.e. "+sum);
                ans[i][k] = sum;
                sum = 0;
                System.out.println();
            }
        }


        System.out.println();
        // print matrix - b
        System.out.println("matrix ans");
        for (int l = 0; l < ans.length; l++) {
            for (int n = 0; n < ans[0].length; n++) {
                System.out.print(n < ans[1].length - 1 ? ans[l][n] + ", " : ans[l][n]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        multiply(new int[][]{{1, 2, 1}, {1, 2, 1}}, new int[][]{{1, 2, 1}, {1, 2, 1}, {1,2,1}});
    }
}
