package java8_practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaLambdaStream {

    /***
     * Declaration start
     */
    final static private List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 2);
    final static private List<String> listOfStringNumbers = Arrays.asList("1", "2", "3", "4", "2");
    final static private List<String> listOfStrings = Arrays.asList("one", "two", "three", "four", "five");

    final static List<Person> people = Arrays.asList(
            new Person("John", "Doe"),
            new Person("Jane", "Doe"),
            new Person("Mary", "Smith"),
            new Person("Matt", "Smith")
    );

    final static List<Product> products = Arrays.asList(
        new Product("Laptop", 1200.0),
        new Product("Smartphone", 800.0),
        new Product("Headphones", 100.0),
        new Product("Tablet", 500.0),
        new Product("Mouse", 30.0)
    );

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

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

    /***
     * Declaration ends
     */

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
        // NOTE - see identity function.
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
        while (itr.hasNext()) {
            if (itr.next() == 2) {
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

    public static void check_If_List_Contains_Element() {
        boolean isPresent = listOfNumbers.stream().anyMatch(a -> a % 2 == 0);
        System.out.println(isPresent);
    }

    public static void collect_Elements_Using_ToMap() {
        Map<String, String> map = people.stream().collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
        /**
         *  with lambda, it would be like -
         *  Map<String, String> map = people.stream().collect(Collectors.toMap(p -> p.getFirstName(), p -> p.getLastName()));
         */
        System.out.println(map);
    }

    public static void joinString() {
        System.out.println(String.join(" • ", listOfStrings));
    }

    public static void mapToInt_Sum_Example() {
        /**
         * map to int, converts object to int, mapToInt function expects "ToIntFunction function"
         * Integer::parseInt is kind of dummy operation, because already we have integers
         * Note - mapToInt is nothing but `map the object to int`.
         */
        int total = listOfStringNumbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(total);
    }

    public static void findAll_Elements_LessThan10() {
        boolean allTrue = listOfNumbers.stream().allMatch(a -> a < 10);
        System.out.println(allTrue);
    }

    public static void count_NumberOfElement_Inside_List() {
        long count = listOfNumbers.stream().count();
        System.out.println(count);
    }

    public static void find_Max_From_List() {
        int maxVal = listOfNumbers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        System.out.println(maxVal);
    }

    public static void remove_duplicates_from_list() {
        List<Integer> distinctList = listOfNumbers.stream().distinct().collect(Collectors.toList());
        System.out.println("original list • " + listOfNumbers + " and after removing distinct elements • " + distinctList);
    }

    public static void convert_List_Into_SquareNumbers() {
        List<Integer> squares = listOfNumbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("list with squares " + squares);

    }

    public static void square_Each_Number_And_FindTotal() {
        Optional<Integer> sum = listOfNumbers.stream().map(n -> n * n).reduce(Integer::sum);
        if (sum.isPresent()) {
            System.out.println("sum of square " + sum.get());
        }
    }

    public static void merge_Two_list_to_make_object() {
        List<String> list = Arrays.asList("Bob", "John", "Matt");
        List<Integer> numbers = Arrays.asList(12, 19, 22);

        List<Student> students = IntStream.range(0, numbers.size())
                .mapToObj(i -> new Student(list.get(i), numbers.get(i))).collect(Collectors.toList());

        System.out.println(students);
    }

    public static void get_Stats_Of_IntStream() {
        IntSummaryStatistics statistics = listOfNumbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.print("max is " + statistics.getMax());
        System.out.print(", min is " + statistics.getMin());
        System.out.print(", average is " + statistics.getAverage());
        System.out.println(", count is " + statistics.getCount());
    }

    public static void create_set() {
        Set<Integer> set = listOfNumbers.stream().collect(Collectors.toSet());
        System.out.println("set is - " + set);
    }


    public static void boxedExample() {
        IntStream stream = IntStream.range(3, 8);
        // Creating a Stream of Integers Using IntStream boxed() to return
        // a Stream consisting of the elements of this stream, each boxed to an Integer.
        Stream<Integer> stream1 = stream.boxed();
        stream1.forEach(System.out::println);
    }

    public static void get_Map_From_Two_Lists() {
        List<String> list = Arrays.asList("Bob", "John", "Matt");
        List<Integer> numbers = Arrays.asList(12, 19, 22);

        Map<String, Integer> map = IntStream.range(0, numbers.size()).boxed()
                .collect(Collectors.toMap(list::get, numbers::get));

        System.out.println(map);
    }


    public static void sort() {
        listOfNumbers.sort((a, b) -> a.compareTo(b));
        System.out.println(listOfNumbers);
    }

    public static void grouping_and_counting_elements() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : listOfNumbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
    }

    public static void flat_map_example() {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        /**
         * The flatMap function in Java's Stream API takes a function that maps an element of the stream to another stream.
         * Using flatMap to flatten the list of lists into a single stream of integers
         */
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream()) // because we are getting list of list
                .collect(Collectors.toList());

        System.out.println(flattenedList);
    }


    public static void find_products_with_price_greater_than_200(){
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.getPrice() > 200.0)
                .collect(Collectors.toList());

        System.out.println(expensiveProducts);
    }

    public static void total_Price_of_Products_in_shopping_cart(){
        double total = products.stream().mapToDouble(product -> product.getPrice()).sum();
        System.out.println(total);
    }

    public static void product_with_highest_price(){
        OptionalDouble maxPrice = products.stream().mapToDouble(product -> product.getPrice()).max();
        System.out.println(maxPrice.getAsDouble());
        // 2nd way to solve the problem.
        Product maxPriceProduct = products.stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).orElse(null);
    }

    /**
     * mapToInt, mapToDouble r helpful, because they have max,min,avg Functions!
     */
    public static void calculate_avg_price_of_products(){
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }


    /**
     * flat map sabhi stream se Ek stream banata hai.
     */
    public static void flatMapToCombineAllStreams() {
        Map<String, Integer> map = Map.of("1", 1, "2", 2, "3", 3);
        List list = List.of("1", "2", "3");

        List<Integer> xy =
                (List<Integer>) list.stream()
                        .flatMap(x -> {
                            Integer y = map.get(x);

                            if (y != null) {
                                System.out.println("xy : " + Stream.of(y));
                                return Stream.of(y);
                            } else {
                                return Stream.empty();
                            }

                            /**
                             * Another better way to return,line 363 and 365
                             * return y != null? Stream.of(y) : Stream.empty();
                             *
                             */

                            /**
                             * Another better way to return,line 363 and 365
                             *
                             * return  Stream.ofNullable(y);
                             */

                        }).collect(Collectors.toList());

        /**
         *  goals [1, 2, 3]
         */

        System.out.println("goals " + xy);
    }


    /**
     * flat map collect all streams into a single stream.
     */
    public static void betterVersionOfFlatMapToCombineAllStreams() {
        Map<String, Integer> map = Map.of("1", 1, "2", 2, "3", 3);
        List list = List.of("1", "2", "3");
        /**
         * OfNullable does same as if null then return empty Stream else return Stream of value from Map
         * in this case, map returns single value for the Key but intention is to merge all single values into
         * a single stream to get Map.
         */
        List<Integer> xy = (List<Integer>) list.stream()
                        .flatMap(x -> Stream.ofNullable(map.get(x))).collect(Collectors.toList());

        /**
         *  goals [1, 2, 3]
         */

        System.out.println("goals " + xy);
    }

    public static void sortMapByValues(){
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 25);
        unsortedMap.put("Alice", 30);
        unsortedMap.put("Bob", 20);
        unsortedMap.put("Eve", 35);

        // Sort the map by values in ascending order
        Map<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function for duplicate keys (if any)
                        LinkedHashMap::new // Use LinkedHashMap to maintain insertion order
                ));
        /**
         * In the provided example, (e1, e2) -> e1 is a simple merge function that resolves conflicts by selecting
         * the first value encountered (e1) and discarding the second value (e2).
         * In short - {A=1, B=2, A=3, C=4} becomes {A=1, B=2, C=4}
         */
        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void main(String[] args) {


        use_ForEach_To_Print_List(); //1

        make_List_After_Filtering(); //2

        learn_How_To_Handle_Null_Using_Optional(); //3

        learn_How_To_Use_Map(); //4

        return_Count_After_GroupBy(); //5

        return_All_Rows_After_GroupBy(); //6

        findFirst(); //7

        sum_using_reduce(); //8

        remove_Element_From_List(); //9

        check_If_List_Contains_Element(); //10

        collect_Elements_Using_ToMap(); //11

        joinString(); //12

        mapToInt_Sum_Example(); //13

        findAll_Elements_LessThan10(); //14

        count_NumberOfElement_Inside_List(); //15

        find_Max_From_List(); //16

        remove_duplicates_from_list(); //17

        convert_List_Into_SquareNumbers(); //18

        square_Each_Number_And_FindTotal(); //19

        merge_Two_list_to_make_object(); // 20

        get_Stats_Of_IntStream(); // 21

        create_set(); //22

        boxedExample(); //23

        get_Map_From_Two_Lists(); //24

        sort(); // 25

        grouping_and_counting_elements(); //26

        flat_map_example(); //27

        find_products_with_price_greater_than_200(); //28

        total_Price_of_Products_in_shopping_cart(); //29

        product_with_highest_price(); //30

        calculate_avg_price_of_products(); //31

        flatMapToCombineAllStreams();  //32

        betterVersionOfFlatMapToCombineAllStreams(); // 33

        sortMapByValues(); //34

    }


    public static String value() {
        return "test-value";
    }
}
