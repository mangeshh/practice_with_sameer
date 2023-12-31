package java_8_21_practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.*;

import static java_8_21_practice.JavaUtilTricks.*;


/**
 * Default methods in Java interfaces were introduced to address the issue of evolving interfaces in a backward-compatible way. Before Java 8, once an interface was published with its methods, adding new methods to it would break existing code that implemented the interface
 * <p>
 * Default method gives following benefits -
 * <p>
 * • Backward Compatibility
 * • Interface Evolution
 * • Reducing Boilerplate Code
 * • Multiple Inheritance
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
    //dummy class, to explain private methods inside Interface.
}


public class JavaInterfaceExample {

    //M1
    public static void defaultMethod() {
        System.out.println("method - " + getCurrentMethodName());

        Greeting englishGreeting = new EnglishGreeting();
        englishGreeting.testOverrideHello();        // Output: Hello!
        englishGreeting.testBaseDefaultHello();     // Output: Default Hello!
        englishGreeting.testOverrideDefaultHello(); // Output: Override Default Hello!
    }

    //M2
    public static void staticMethods() {
        System.out.println("method - " + getCurrentMethodName());

        int sum = MathOperations.add(5, 3);
        System.out.println("Sum: " + sum);           // Output: Sum: 8
        int difference = MathOperations.subtract(10, 3);
        System.out.println("Difference: " + difference); // Output: Difference: 7
    }

    //M3
    public static void functionalInterface() {
        System.out.println("method - " + getCurrentMethodName());

        // Functional Interface
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;
        int result1 = addition.calculate(5, 3);       // Result: 8
        int result2 = subtraction.calculate(10, 3);   // Result: 7
        System.out.println(result1 + " and " + result2);
    }

    //M4
    public static void privateMethodsInInterface() {
        System.out.println("method - " + getCurrentMethodName());

        MyPrivateMethodInterfaceImpl myInterface = new MyPrivateMethodInterfaceImpl();
        myInterface.publicMethod();
    }

    /**
     * The Supplier functional interface represents a supplier of results and takes no arguments. It's typically used to generate or provide data.
     */
    //M5
    public static void supplierExample() {
        System.out.println("method - " + getCurrentMethodName());

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        // Use the Supplier to get a random number
        int randomNumber = randomSupplier.get();
        System.out.println("Random Number: " + randomNumber);
    }

    /**
     * The Consumer functional interface represents an operation that takes a single input and performs some action without returning a result.
     */
    //M6
    public static void consumerExample() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> printConsumer = (number) -> System.out.println(number);
        numbers.forEach(printConsumer);
    }

    //M7
    public static void biConsumerExample() {
        System.out.println("method - " + getCurrentMethodName());

        // BiConsumer prints key-value pairs.
        BiConsumer<String, Integer> printKeyValue = (k, v) -> {
            System.out.println(k + ": " + v);
        };
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

    //M8
    public static void functionApplyExample() {
        System.out.println("method - " + getCurrentMethodName());

        Function<Integer, Integer> squareFunction = x -> x * x;
        int result = squareFunction.apply(5);
        System.out.println("Square of 5 is: " + result);
    }

    //M9
    public static void biFunctionApplyExample() {
        System.out.println("method - " + getCurrentMethodName());

        // Define a BiFunction to calculate the sum of two integers
        BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
        int result = sumFunction.apply(5, 3);
        System.out.println("Sum of 5 and 3 is: " + result);
    }

    //M10
    public static void unaryOperatorExample() {
        System.out.println("method - " + getCurrentMethodName());
        // Type here (Integer), is same for input and output.
        UnaryOperator<Integer> doubleNumber = n -> n * 2;
        int result = doubleNumber.apply(5); // Doubles 5 to get 10
        System.out.println("Double of 5 is: " + result);
    }

    //M11
    public static void binaryOperatorExample() {
        System.out.println("method - " + getCurrentMethodName());
        // Type here (Integer), is same for input (2 arguments) and output.
        BinaryOperator<Integer> add = (a, b) -> a + b;
        int result = add.apply(3, 4); // Adds 3 and 4 to get 7
        System.out.println("3 + 4 = " + result);
    }

    //M12
    public static void predicateExample() {
        System.out.println("method - " + getCurrentMethodName());

        Predicate<Integer> isEven = n -> n % 2 == 0; // expected input is integer and return is always boolean
        System.out.println("Is 4 even? " + isEven.test(4)); // true
        System.out.println("Is 7 even? " + isEven.test(7)); // false
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        boolean allowed = false;

        if (args.length == 0) {
            allowed = true;
        }

        // you can run by giving method name too.
        if (!allowed) {
            JavaInterfaceExample javaInterfaceExample = new JavaInterfaceExample();
            Optional<Method> method = Arrays.stream(JavaInterfaceExample.class.getMethods())
                    // .peek(m -> System.out.println(m.getName()))
                    .filter(m -> m.getName().equalsIgnoreCase(args[0]))
                    .findFirst();
            if (method.isPresent()) {
                method.get().invoke(javaInterfaceExample);
            } else {
                System.out.println("No Method found..");
            }

        } else {

            defaultMethod(); //M1

            staticMethods(); //M2

            functionalInterface(); //M3

            privateMethodsInInterface(); //M4

            supplierExample(); //M5

            consumerExample(); //M6

            biConsumerExample(); //M7

            functionApplyExample(); //M8

            biFunctionApplyExample(); //M9

            unaryOperatorExample(); //M10

            binaryOperatorExample(); //M11

            predicateExample(); //M12
        }

    }

}
