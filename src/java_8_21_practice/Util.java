package java_8_21_practice;

public class Util {

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
}
