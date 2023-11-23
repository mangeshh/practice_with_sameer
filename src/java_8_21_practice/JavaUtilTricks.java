package java_8_21_practice;

import java.util.Arrays;

public class JavaUtilTricks {

    public static String getCurrentMethodName() {
        // Get the stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // The first element in the stack trace is this method
        // The second element is the caller's method
        if (stackTrace.length >= 3) {
            StackTraceElement caller = stackTrace[2]; // Index 2 corresponds to the caller's method
            return caller.getMethodName();
        } else {
            return "Unknown"; // Handle the case when method name cannot be determined
        }
    }

    public static void main(String[] args) {
        arrayCopyExample();
    }

    private static void arrayCopyExample() {
        // Case - 1
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] destinationArray = new int[sourceArray.length];
        // 5 parameters, [from array, it's start, to array, it's start and number of elements to copy ]
        System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);
        System.out.println(Arrays.toString(destinationArray));


        // Case - 2
        int[] sourceArrayForSlim = {1, 2, 3, 4, 5};
        int[] destinationArraySlim = new int[3];
        System.arraycopy(sourceArrayForSlim, 1, destinationArraySlim, 0, 3);


        // Case - 3; multidimensional array.
        int[][] sourceArrayMultiDem = {{1, 2}, {3, 4}};
        int[][] destinationArrayMultiDem = new int[sourceArray.length][sourceArrayMultiDem[0].length];
        for (int i = 0; i < sourceArray.length; i++) {
            System.arraycopy(sourceArrayMultiDem[i], 0, destinationArrayMultiDem[i], 0, sourceArrayMultiDem[i].length);
        }


        // Case - 4 (This is important.)
        int[] sourceArrayCopyOf = {1, 2, 3, 4, 5};
        int[] destinationArrayCopyOf = Arrays.copyOf(sourceArrayCopyOf, sourceArrayCopyOf.length);
        System.out.println(Arrays.toString(destinationArrayCopyOf));
    }
}
