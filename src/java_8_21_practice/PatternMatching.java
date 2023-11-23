package java_8_21_practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import static java_8_21_practice.Util.*;

public class PatternMatching {

    public static void exampleWithSwitchYield() {
        System.out.println("method - " + getCurrentMethodName());

        int dayOfWeek = 3;

        String day = switch (dayOfWeek) {
            case 1 -> "Sunday"; // simple value means, return "Sunday"
            case 2 -> "Monday";
            case 3 -> {
                System.out.println("Tuesday");
                yield "Tuesday"; // this is a return statement, yield is used because some logic is getting executed in case, so need to use yield to dictate return.
            }
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Invalid day";
        };

        System.out.println(day);
    }

    public static void basicSwitchExampleWithoutBreak() {
        System.out.println("method - " + getCurrentMethodName());

        int dayOfWeek = 3;
        /**
         * if you don't write the break statement after a case block,
         * the control will "fall through" to the next case without checking any condition
         * and the code in subsequent cases will be executed sequentially
         * until a break statement is encountered or the switch statement ends.
         *
         *               ~~~  This behavior is known as "fall-through."  ~~~
         *
         * So, output would be:
         *   Tuesday
         *   Wednesday
         *   Thursday
         *   Friday
         *   Saturday
         *   Invalid day
         *
         * Note, That's why `break` is super important.
         */
        switch (dayOfWeek) {
            case 1:
                System.out.println("Sunday");
                // No break, so the control falls through to the next case
            case 2:
                System.out.println("Monday");
                // No break, so the control falls through to the next case
            case 3:
                System.out.println("Tuesday");
                // No break, so the control falls through to the next case
            case 4:
                System.out.println("Wednesday");
                // No break, so the control falls through to the next case
            case 5:
                System.out.println("Thursday");
                // No break, so the control falls through to the next case
            case 6:
                System.out.println("Friday");
                // No break, so the control falls through to the next case
            case 7:
                System.out.println("Saturday");
                // No break, so the control falls through to the next case
            default:
                System.out.println("Invalid day");
        }
    }

    public static void patternMatchingWithType(Object obj) {
        System.out.println("method - " + getCurrentMethodName());

        switch (obj) {
            case String str -> System.out.println("It's a String: " + str);
            case Integer num -> System.out.println("It's an Integer: " + num);
            default -> System.out.println("It's something else");
        }
    }

    public static void basicSwitchExampleWithBreak() {
        System.out.println("method - " + getCurrentMethodName());

        int dayOfWeek = 3;
        /**
         * if you don't write the break statement after a case block, the control will "fall through" to the next case,
         * and the code in subsequent cases will be executed sequentially
         * until a break statement is encountered or the switch statement ends. This behavior is known as "fall-through."
         *
         * SO here output would be:
         * Tuesday
         *
         * That's why `break` is super important.
         */
        switch (dayOfWeek) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }

    public static void basicSwitchExampleWithMultipleOptions() {
        System.out.println("method - " + getCurrentMethodName());


        enum Day {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
        }

        Day today = Day.WEDNESDAY;
        String activity;

        // Superb!! lovely way to get value assigned inside the variable from switch statement.
        switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> activity = "Working day";
            case SATURDAY, SUNDAY -> activity = "Weekend";
            default -> activity = "Invalid day";
        }

        System.out.println("Today is a " + today);
        System.out.println("Activity: " + activity);

        // case - 2
        int day = 7;
        String dayName = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Unknown";
        };

        System.out.println(dayName);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        boolean allowed = false;

        if (args.length == 0) {
            allowed = true;
        }

        // you can run by giving method name too.
        if (!allowed) {

            PatternMatching patternMatching = new PatternMatching();
            Optional<Method> method = Arrays.stream(PatternMatching.class.getMethods())
                    .filter(m -> m.getName().equalsIgnoreCase(args[0]))
                    .findFirst();
            if (method.isPresent()) {
                method.get().invoke(patternMatching);
            } else {
                System.out.println("No Method found..");
            }

        } else {
            String test = "testMe";

            //old way to check if the type is as expected.
            if (test instanceof String) {
                String str = test;
                //System.out.println(str);
            }

            exampleWithSwitchYield();

            basicSwitchExampleWithoutBreak();

            basicSwitchExampleWithBreak();

            patternMatchingWithType(test);

            basicSwitchExampleWithMultipleOptions();
        }
    }

}
