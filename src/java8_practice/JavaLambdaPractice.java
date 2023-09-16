package java8_practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaLambdaPractice {

    final static private List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 2);
    final static private List<String> listOfStringNumbers = Arrays.asList("1", "2", "3", "4", "2");
    final static private List<String> listOfStrings = Arrays.asList("one", "two", "three", "four", "five");

    final static List<Person> people = Arrays.asList(
            new Person("John", "Doe"),
            new Person("Jane", "Doe"),
            new Person("Mary", "Smith"),
            new Person("Matt", "Smith")
    );

    static class Person {

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String firstName;
        String lastName;

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void use_ForEach_To_Print_List() {
        listOfNumbers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }


    public static void learn_How_To_Use_Map() {
        List<String> listOfString = listOfNumbers.stream().map(n -> n + "*").collect(Collectors.toList());
        System.out.println(listOfString);
    }

    public static void learn_How_To_Handle_Null_Using_Optional() {
        Optional<String> value = Optional.ofNullable(value());
        value.ifPresentOrElse(name -> System.out.println("yes"),
                () -> System.out.println("not present")
        );

        if (value.isPresent()) {
            System.out.println("yes..");
        }
    }

    public static void return_Count_After_GroupBy() {
        // group by returns the map.
        Map<Integer, Long> count = listOfNumbers
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(count);
    }

    public static void return_All_Rows_After_GroupBy() {
        Map<String, List<Person>> groupedByLastName = people.stream()
                .collect(Collectors.groupingBy(Person::getLastName));

        System.out.println(groupedByLastName);

        for (Map.Entry<String, List<Person>> entry : groupedByLastName.entrySet()) {
            System.out.println("Number of people with last name " + entry.getKey() + " are " + entry.getValue().size());
        }
    }


    public static void make_List_After_Filtering() {
        List newList = listOfNumbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(newList);
    }

    public static void findFirst() {
        Optional num = listOfNumbers.stream().filter(a -> a % 2 == 0).findFirst();
        if (num.isPresent()) {
            System.out.println("found 1sy even number");
        }
    }

    public static void sum_using_reduce() {
        int sum = listOfNumbers.stream().reduce(0, Integer::sum);
        // reduce method takes, default initial value and bi-functional reference or lambda
        System.out.println(sum);
    }

    public static void remove_Element_From_List() {
        /**
         * older version
         */
         Iterator<Integer> itr = listOfNumbers.iterator();
         while(itr.hasNext()){
             if(itr.next() == 2){
                 //itr.remove();
             }
         }

        /**
         * latest java, to remove element, we can use `removeIf`, instead of iterator
         *
         *  listOfNumbers.removeIf(n -> n == 2); // Getting error! java.lang.UnsupportedOperationException
         *  System.out.println(listOfNumbers);
         *
         */

    }

    public static void check_If_List_Contains_Element(){
        boolean isPresent = listOfNumbers.stream().anyMatch(a -> a %2 ==0);
        System.out.println(isPresent);
    }

    public static void collect_Elements_Using_ToMap(){
        Map map = people.stream().collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
        /**
         *  with lambda, it would be like -
         *  Map<String, String> map = people.stream().collect(Collectors.toMap(p -> p.getFirstName(), p -> p.getLastName()));
         */
        System.out.println(map);
    }

    public static void joinString() {
        System.out.println(String.join(" • ", listOfStrings));
    }

    public static void mapToInt_Sum_Example(){
        /**
         * map to int, converts object to int, mapToInt function expects "ToIntFunction function"
         */
        int total = listOfStringNumbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(total);
    }

    public static void findAll_Elements_LessThan10(){
        boolean allTrue = listOfNumbers.stream().allMatch(a -> a < 10);
        System.out.println(allTrue);
    }

    public static void count_NumberOfElement_Inside_List(){
        long count = listOfNumbers.stream().count();
        System.out.println(count);
    }

    public static void find_Max_From_List(){
        int maxVal = listOfNumbers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        System.out.println(maxVal);
    }

    public static void remove_duplicates_from_list(){
        List<Integer> distinctList = listOfNumbers.stream().distinct().collect(Collectors.toList());
        System.out.println("original list • " + listOfNumbers + " and after removing distinct elements • " + distinctList);
    }

    public static void convert_List_Into_SquareNumbers(){
        List<Integer> squares = listOfNumbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("list with squares " + squares);

    }

    public static void square_Each_Number_And_FindTotal(){
        Optional<Integer> sum = listOfNumbers.stream().map(n -> n * n).reduce(Integer::sum);
        if(sum.isPresent()){
            System.out.println("sum of square " + sum.get());
        }
    }

    public static void main(String[] args) {
        use_ForEach_To_Print_List();

        make_List_After_Filtering();

        learn_How_To_Handle_Null_Using_Optional();

        learn_How_To_Use_Map();

        return_Count_After_GroupBy();

        return_All_Rows_After_GroupBy();

        findFirst();

        sum_using_reduce();

        remove_Element_From_List();

        check_If_List_Contains_Element();

        collect_Elements_Using_ToMap();

        joinString();

        mapToInt_Sum_Example();

        findAll_Elements_LessThan10();

        count_NumberOfElement_Inside_List();

        find_Max_From_List();

        remove_duplicates_from_list();

        convert_List_Into_SquareNumbers();

        square_Each_Number_And_FindTotal();
    }


    public static String value() {
        return "test-value";
    }
}
