package java_8_21_practice;

public class PatternMatching {

    public static void exampleWithSwitchYield(){

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

    public static void basicSwitchExampleWithoutBreak(){
        int dayOfWeek = 3;
        /**
         * if you don't write the break statement after a case block, the control will "fall through" to the next case,
         * and the code in subsequent cases will be executed sequentially
         * until a break statement is encountered or the switch statement ends. This behavior is known as "fall-through."
         *
         * SO here output would be:
         * Tuesday
         * Wednesday
         * Thursday
         * Friday
         * Saturday
         * Invalid day
         *
         * That's why `break` is super important.
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
    public static void main(String[] args) {
        exampleWithSwitchYield();

        basicSwitchExampleWithoutBreak();
    }
}
