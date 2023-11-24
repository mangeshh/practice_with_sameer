package java_8_21_practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

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

    // M1
    private static void stringStickyMethods() {
        // Case - 1
        String str = "Hello, World!";
        // it starts at 0, so find index 7 and till 11 (12-1 : exclusive 12)
        String sub = str.substring(7, 12); // Extracts "World"

        // Case  -2
        String formatted = String.format("Hello, %s!", "John");
        System.out.printf("Formatted: %s%n", formatted);

        // Case - 3
        String strCheck = "Hello, World!";
        int index = strCheck.indexOf("World"); // Returns the index of "World"
        boolean contains = strCheck.contains("Hello"); // true

        // Case - 4
        String original = "This is a test.";
        String modified = original.replace("test", "example");
    }

    // M2
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


        // Case - 3 (This is important)
        int[] sourceArrayCopyOf = {1, 2, 3, 4, 5};
        int[] destinationArrayCopyOf = Arrays.copyOf(sourceArrayCopyOf, sourceArrayCopyOf.length);
        System.out.println(Arrays.toString(destinationArrayCopyOf));


        // Case - 4 (Array fill)
        int[] numbers = new int[5];
        // Fill the entire 'numbers' array with the value 42
        Arrays.fill(numbers, 42);
        System.out.println(Arrays.toString(numbers));
    }



    public static void main(String[] args) {
        stringStickyMethods(); // M1
        arrayCopyExample();  // M2
    }
}
