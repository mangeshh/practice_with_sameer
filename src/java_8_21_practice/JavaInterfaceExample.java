package java_8_21_practice;

/**
 * Default methods in Java interfaces were introduced to address the issue of evolving interfaces in a backward-compatible way. Before Java 8, once an interface was published with its methods, adding new methods to it would break existing code that implemented the interface
 *
 * Default method gives following benefits -
 *
 * • Backward Compatibility
 * • Interface Evolution
 * • Reducing Boilerplate Code
 * • Multiple Inheritance
 *
 */
// § 1st Example §
interface Greeting {
    void sayHello();

    default void sayBaseDefaultHello() {
        System.out.println("Default Hello!");
    }

    default void testOverrideDefaultHello() {
        System.out.println("Default Hello!");
    }
}


class EnglishGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    public void testOverrideDefaultHello() {
        System.out.println("Override Default Hello!");
    }
}

// § 2nd Example §
interface MathOperations {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

// § 3rd Example §
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class JavaInterfaceExample {

    public static void main(String[] args) {
        Greeting englishGreeting = new EnglishGreeting();
        englishGreeting.sayHello();          // Output: Hello!
        englishGreeting.sayBaseDefaultHello();   // Output: Default Hello!
        englishGreeting.testOverrideDefaultHello();   // Output: Default Hello!

        // # interface for MathOperation.
        int sum = MathOperations.add(5, 3);
        int difference = MathOperations.subtract(10, 3);

        System.out.println("Sum: " + sum);           // Output: Sum: 8
        System.out.println("Difference: " + difference); // Output: Difference: 7

        // Functional Interface
        Calculator addition = (a,b) -> a + b;
        Calculator subtraction = (a,b) -> a - b;

        int result1 = addition.calculate(5, 3);       // Result: 8
        int result2 = subtraction.calculate(10, 3);   // Result: 7
        System.out.println(result1 + " and " + result2);
    }
}
