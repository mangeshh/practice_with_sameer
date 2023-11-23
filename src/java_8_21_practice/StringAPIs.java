package java_8_21_practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import static java_8_21_practice.Util.*;

public class StringAPIs {

    // M1
    public static void indentExample() {
        String text = "Line 1\nLine 2\nLine 3";
        String indentedText = text.indent(2); // Indent each line with 2 spaces
        System.out.println(indentedText);
        /*
        Output:
          Line 1
          Line 2
          Line 3
        */
    }

    // M2
    public static void transformExample() {
        System.out.println("method - " + getCurrentMethodName());

        String original = "Hello, World!";
        String transformedToUppercase = original.transform(str -> str.toUpperCase());
        System.out.println(transformedToUppercase); // "HELLO, WORLD!"
        String transformedToReverseString = original.transform(str -> new StringBuilder(str).reverse().toString());
        System.out.println(transformedToReverseString);
        String transformedToNoWhitespaceString = original.transform(str -> str.replaceAll("\\s+", ""));
        System.out.println(transformedToNoWhitespaceString);
    }

    // M3
    public static void transformExampleWithLittleComplexity() {
        System.out.println("method - " + getCurrentMethodName());

        String originalString = "Custom 121 transformation 212 example";

        String transformedString = originalString.transform(str -> {
            StringBuilder builder = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    // assume, we want to ignore characters and numbers.
                    // builder.append(c);
                }
            }
            return builder.toString();
        });

        System.out.println("Original String: " + originalString);
        System.out.println("Transformed String: " + transformedString);
    }

    // M4
    public static void multiLineString() {
        System.out.println("method - " + getCurrentMethodName());

        String lines = "abc\n" +
                "pqr\n" +
                "xyz";

        // old style starts
        String[] aLines = lines.split("\\R"); // JDK 8
        System.out.println("old style " + Arrays.toString(aLines));
        // old style ends

        Stream<String> stream = lines.lines();
        stream.forEach(System.out::println); // example -1
        //we can use stream only once, else we will get error - stream has already been operated upon or closed

        /*
            `Note` - so commenting below lines
            System.out.println(stream.filter(str -> str.matches("abc.*")).findFirst()); // example - 2
            System.out.println(lines.lines().toList()); // example-3
         */
    }

    /**
     * trim() removed only the ASCII spaces from the beginning and end of the string.
     * strip() removed both the ASCII spaces and the non-ASCII spaces (like the non-breaking space U+00A0) from the beginning and end of the string.
     */
    // M5
    public static void trimStrip() {
        System.out.println("method - " + getCurrentMethodName());

        String original = "   Hello,   World!   ";

        String trimmed = original.trim();
        String stripped = original.strip();

        System.out.println("Original: [" + original + "]");
        System.out.println("Trimmed:  [" + trimmed + "]");
        System.out.println("Stripped: [" + stripped + "]");
    }

    // M6
    public static void repeatMethod() {
        String hash = "#";
        System.out.println(hash.repeat(4));
        System.out.println("empty string " + hash.repeat(0));
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        boolean allowed = false;

        if (args.length == 0) {
            allowed = true;
        }

        // you can run by giving method name too.
        if (!allowed) {
            StringAPIs instance = new StringAPIs();
            Optional<Method> method = Arrays.stream(instance.getClass().getMethods())
                    // .peek(m -> System.out.println(m.getName()))
                    .filter(m -> m.getName().equalsIgnoreCase(args[0]))
                    .findFirst();
            if (method.isPresent()) {
                method.get().invoke(instance);
            } else {
                System.out.println("No Method found..");
            }

        } else {
            
            indentExample(); // M1

            transformExample(); // M2

            transformExampleWithLittleComplexity(); // M3

            multiLineString(); // M4

            trimStrip(); // M5
            
            repeatMethod(); // M6
        }
    }


}
