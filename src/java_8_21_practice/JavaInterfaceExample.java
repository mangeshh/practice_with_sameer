package java_8_21_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

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

// 1st Example, default methods.
interface Greeting {
    void testOverrideHello();

    default void testBaseDefaultHello() {
        System.out.println("Default Hello!");
    }

    default void testOverrideDefaultHello() {
        System.out.println("Default Hello!");
    }
}


class EnglishGreeting implements Greeting {
    @Override
    public void testOverrideHello() {
        System.out.println("Hello!");
    }

    public void testOverrideDefaultHello() {
        System.out.println("Override Default Hello!");
    }
}

// 2nd Example, static methods.
interface MathOperations {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

// 3rd Example, SAM
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// 4th example, private, ,method
interface MyPrivateMethodInterface {
    // multiple default methods sharing private method.
    default void publicMethod() {
        System.out.println("This is a public method");
        privateMethod();
    }

    @SuppressWarnings("unused")
    default void anotherPublicMethod() {
        System.out.println("This is another public method");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("i am called by default method, This is a private method");
    }
}

class MyPrivateMethodInterfaceImpl implements MyPrivateMethodInterface {
    //dummy class to explain private methods inside Interface.
}



public class JavaInterfaceExample {

    /**
     * The Supplier functional interface represents a supplier of results and takes no arguments. It's typically used to generate or provide data.
     */
    public static void  supplierExample() {
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        // Use the Supplier to get a random number
        int randomNumber = randomSupplier.get();
        System.out.println("Random Number: " + randomNumber);
    }

    /**
     * The Consumer functional interface represents an operation that takes a single input and performs some action without returning a result.
     */
    public static void  consumerExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> printConsumer = (number) -> System.out.println(number);
        numbers.forEach(printConsumer);
    }

    public static void biConsumerExample(){
        // BiConsumer prints key-value pairs.
        BiConsumer<String, Integer> printKeyValue = (k, v) -> {System.out.println(k + ": " + v);};
        printKeyValue.accept("Age", 30);
        printKeyValue.accept("Score", 95);

        // With Map
        Map studentScores = Map.of("Alice", 95, "Bob", 85, "Charlie", 90);
        // In this example, each student's name and score
        BiConsumer<String, Integer> printStudentScore = (name, score) -> {
            System.out.println(name + ": " + score);
        };

        // Superb!!!!
        // Use the BiConsumer to iterate through the Map and print each entry
        studentScores.forEach(printStudentScore);
    }

    public static void functionApplyExample() {
        Function<Integer, Integer> squareFunction = x -> x * x;
        int result = squareFunction.apply(5);
        System.out.println("Square of 5 is: " + result);
    }

    public static void biFunctionApplyExample() {
        // Define a BiFunction to calculate the sum of two integers
        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
        int result = sumFunction.apply(5, 3);
        System.out.println("Sum of 5 and 3 is: " + result);
    }

    public static void unaryOperatorExample(){
        UnaryOperator<Integer> doubleNumber = n -> n * 2;
        int result = doubleNumber.apply(5); // Doubles 5 to get 10
        System.out.println("Double of 5 is: " + result);
    }

    public static void binaryOperatorExample(){
        BinaryOperator<Integer> add = (a, b) -> a + b;
        int result = add.apply(3, 4); // Adds 3 and 4 to get 7
        System.out.println("3 + 4 = " + result);
    }

    public static void predicateExample(){
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 7 even? " + isEven.test(7)); // false
    }

    public static void main(String[] args) {
        // Default methods
        Greeting englishGreeting = new EnglishGreeting();
        englishGreeting.testOverrideHello();          // Output: Hello!
        englishGreeting.testBaseDefaultHello();   // Output: Default Hello!
        englishGreeting.testOverrideDefaultHello();   // Output: Default Hello!

        // Interface with static methods
        int sum = MathOperations.add(5, 3);
        System.out.println("Sum: " + sum);           // Output: Sum: 8
        int difference = MathOperations.subtract(10, 3);
        System.out.println("Difference: " + difference); // Output: Difference: 7

        // Functional Interface
        Calculator addition = (a,b) -> a + b;
        Calculator subtraction = (a,b) -> a - b;
        int result1 = addition.calculate(5, 3);       // Result: 8
        int result2 = subtraction.calculate(10, 3);   // Result: 7
        System.out.println(result1 + " and " + result2);

        // private method inside interface.
        MyPrivateMethodInterfaceImpl myInterface = new MyPrivateMethodInterfaceImpl();
        myInterface.publicMethod();

        supplierExample();

        consumerExample();

        biConsumerExample();

        functionApplyExample();

        biFunctionApplyExample();

        unaryOperatorExample();

        binaryOperatorExample();

        predicateExample();

    }


}
