package java_8_21_practice;

public class StringAPIs {

    public static void main(String[] args) {

        // case-1
        String text = "Line 1\nLine 2\nLine 3";
        String indentedText = text.indent(2); // Indent each line with 2 spaces
        System.out.println(indentedText);
        /*
        Output:
          Line 1
          Line 2
          Line 3
        */

        // case-2
        String original = "Hello, World!";
        String transformedToUppercase = original.transform(str -> str.toUpperCase());
        System.out.println(transformedToUppercase); // "HELLO, WORLD!"
        String transformedToReverseString = original.transform(str -> new StringBuilder(str).reverse().toString());
        System.out.println(transformedToReverseString);
        String transformedToNoWhitespaceString = original.transform(str -> str.replaceAll("\\s+", ""));
        System.out.println(transformedToNoWhitespaceString);


        // case - 3 - custom function to transform.
        String originalString = "Custom 121 transformation 212 example";

        // Define a custom transformation function
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
}
