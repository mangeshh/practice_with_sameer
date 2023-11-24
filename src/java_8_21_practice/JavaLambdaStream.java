package java_8_21_practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java_8_21_practice.JavaUtilTricks.*;


/**
 * ===============================================================================================================================
 * Rules, while using streaming
 * ===============================================================================================================================
 *
 * @ Minimize Intermediate Operations: Intermediate operations like filter, map, and flatMap can create
 * additional intermediate streams. These can be costly in terms of memory and processing time, especially for large datasets.
 * Try to minimize the number of intermediate operations and combine them whenever possible.
 * @ Use Primitives: When working with primitive data types like int, long, and double, consider using specialized stream types
 * like IntStream, LongStream, and DoubleStream. These specialized streams can avoid the overhead of boxing and unboxing values.
 * @ Parallel Processing: For computationally intensive operations, consider using parallel streams (parallelStream()) to take
 * advantage of multi-core processors. However, be aware that parallel processing introduces its own set of challenges,
 * such as potential thread-safety issues and the need for proper synchronization.
 * @ Avoid Unnecessary Sorting: Sorting elements in a stream can be an expensive operation, especially for large datasets.
 * If you don't need to sort the data, avoid using sorting operations like sorted().
 * @ Lazy Evaluation: Streams in Java are lazily evaluated, meaning that operations are only executed when a terminal operation
 * is invoked. Take advantage of lazy evaluation to avoid unnecessary computation. If you only need a subset of the data,
 * you can use operations like takeWhile and dropWhile to limit the processing.
 * @ Use Collectors Wisely: Be mindful of the collectors you use when terminating a stream. Some collectors may introduce
 * overhead or create unnecessary intermediate data structures. Choose the appropriate collector for your specific use case.
 * @ Stream Sources: Consider the source of your stream. If possible, use sources that are already optimized for streaming,
 * such as collections that implement the Stream interface, arrays, or I/O streams.
 * @ Profiling and Benchmarking: To identify performance bottlenecks in your streaming code, use profiling tools and perform
 * benchmarking. This will help you pinpoint areas that require optimization.
 * @ Avoid Side Effects: Ensure that your stream operations are free from side effects. Side effects can lead to unexpected
 * behavior and make it harder to reason about the correctness of your code.
 * @ Resource Management: When working with streams that involve external resources (e.g., file streams or network streams),
 * be sure to properly manage and close those resources to prevent resource leaks.
 */
public class JavaLambdaStream {

    /***
     * Declaration start
     */
    final static private List<Integer> collectionImmutableFactory = List.of(1, 2, 3, 4, 2); //any collection with `of` creates immutable result.
    final static private List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 2);
    final static private List<String> listOfStringNumbers = Arrays.asList("1", "2", "3", "4", "2");
    final static private List<String> listOfStrings = Arrays.asList("one", "two", "three", "four", "five");
    static private List<Integer> testListOfNumbers = Arrays.asList(1, 2, 3, 4, 2);

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

    static class CustomException extends RuntimeException {

        public CustomException(String exceptionMsg) {
            super(exceptionMsg);
        }

    }

    static class Product {

        public String name;
        public double price;

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

        private String firstName;
        private String lastName;

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

    static class Persona {
        private String name;
        private int age;
        private double height;

        public Persona(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
    }

    /***
     * Declaration ends
     */

    //M1
    public static void use_ForEach_To_Print_List() {
        System.out.println("method - " + getCurrentMethodName());

        listOfNumbers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }


    //M2
    public static void learn_How_To_Use_Map() {
        System.out.println("method - " + getCurrentMethodName());

        List<String> listOfString = listOfNumbers.stream().map(n -> n + "*").collect(Collectors.toList());
        System.out.println(listOfString);
    }

    //M3
    public static void learn_How_To_Handle_Null_Using_Optional() {
        System.out.println("method - " + getCurrentMethodName());

        //'ofNullable', returns the given value, if non-null, otherwise returns an empty Optional.
        Optional<String> value = Optional.ofNullable(value());
        value.ifPresentOrElse(name -> System.out.println("yes"),
                () -> System.out.println("not present")
        );

        if (value.isPresent()) {
            System.out.println("yes..");
        }
    }

    //M4
    public static void return_Count_After_GroupBy() {
        System.out.println("method - " + getCurrentMethodName());

        // NOTE - see identity function.
        // `group by` returns the map.
        Map<Integer, Long> count = listOfNumbers
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(count);
    }

    //M5
    public static void return_All_Rows_After_GroupBy() {
        System.out.println("method - " + getCurrentMethodName());

        Map<String, List<Person>> groupedByLastName = people.stream()
                .collect(Collectors.groupingBy(Person::getLastName));

        System.out.println(groupedByLastName);

        for (Map.Entry<String, List<Person>> entry : groupedByLastName.entrySet()) {
            System.out.println("Number of people with last name " + entry.getKey() + " are " + entry.getValue().size());
        }
    }

    //M6
    public static void make_List_After_Filtering() {
        System.out.println("method - " + getCurrentMethodName());

        List newList = listOfNumbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(newList);
    }

    //M7
    public static void findFirst() {
        System.out.println("method - " + getCurrentMethodName());

        Optional num = listOfNumbers.stream().filter(a -> a % 2 == 0).findFirst();
        if (num.isPresent()) {
            System.out.println("found 1sy even number");
        }
    }

    //M8
    public static void sum_using_reduce() {
        System.out.println("method - " + getCurrentMethodName());

        int sum = listOfNumbers.stream().reduce(0, Integer::sum);
        // reduce method takes, default initial value and bi-functional reference or lambda
        System.out.println(sum);
    }

    //M9
    public static void remove_Element_From_List() {
        System.out.println("method - " + getCurrentMethodName());

        /**
         * older version
         */
        Iterator<Integer> itr = listOfNumbers.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                //itr.remove();  if we uncomment then - UnsupportedOperationException: remove at java.base/java.util.Iterator.remove(Iterator.java:102)
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

    //M10
    public static void check_If_List_Contains_Element() {
        System.out.println("method - " + getCurrentMethodName());

        boolean isPresent = listOfNumbers.stream().anyMatch(a -> a % 2 == 0);
        System.out.println(isPresent);
    }

    //M11
    public static void collect_Elements_Using_ToMap() {
        System.out.println("method - " + getCurrentMethodName());

        Map<String, String> map = people.stream().collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
        /**
         *  with lambda, it would be like -
         *  Map<String, String> map = people.stream().collect(Collectors.toMap(p -> p.getFirstName(), p -> p.getLastName()));
         */
        System.out.println(map);
    }

    //M12
    public static void joinString() {
        System.out.println("method - " + getCurrentMethodName());

        System.out.println(String.join(" • ", listOfStrings));
    }

    //M13
    public static void mapToInt_Sum_Example() {
        System.out.println("method - " + getCurrentMethodName());

        /**
         * map to int, converts object to int, mapToInt function expects "ToIntFunction function"
         * Integer::parseInt is kind of dummy operation, because already we have integers
         * Note - mapToInt is nothing but `map the object to int`.
         */
        int total = listOfStringNumbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(total);
    }

    //M14
    public static void findAll_Elements_LessThan10() {
        System.out.println("method - " + getCurrentMethodName());

        boolean allTrue = listOfNumbers.stream().allMatch(a -> a < 10);
        System.out.println(allTrue);
    }

    //M15
    public static void count_NumberOfElement_Inside_List() {
        System.out.println("method - " + getCurrentMethodName());

        long count = listOfNumbers.stream().count();
        System.out.println(count);
    }

    //M16
    public static void find_Max_From_List() {
        System.out.println("method - " + getCurrentMethodName());

        int maxVal = listOfNumbers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        System.out.println(maxVal);
    }

    //M17
    public static void remove_duplicates_from_list() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> distinctList = listOfNumbers.stream().distinct().collect(Collectors.toList());
        System.out.println("original list • " + listOfNumbers + " and after removing distinct elements • " + distinctList);
    }

    //M18
    public static void convert_List_Into_SquareNumbers() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> squares = listOfNumbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("list with squares " + squares);

    }

    //M19
    public static void square_Each_Number_And_FindTotal() {
        System.out.println("method - " + getCurrentMethodName());

        Optional<Integer> sum = listOfNumbers.stream().map(n -> n * n).reduce(Integer::sum);
        if (sum.isPresent()) {
            System.out.println("sum of square " + sum.get());
        }
    }

    //M20
    public static void merge_Two_list_to_make_object() {
        System.out.println("method - " + getCurrentMethodName());

        List<String> list = Arrays.asList("Bob", "John", "Matt");
        List<Integer> numbers = Arrays.asList(12, 19, 22);

        List<Student> students = IntStream.range(0, numbers.size())
                .mapToObj(i -> new Student(list.get(i), numbers.get(i))).collect(Collectors.toList());

        System.out.println(students);
    }

    //M21
    public static void get_Stats_Of_IntStream() {
        System.out.println("method - " + getCurrentMethodName());

        IntSummaryStatistics statistics = listOfNumbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.print("max is " + statistics.getMax());
        System.out.print(", min is " + statistics.getMin());
        System.out.print(", average is " + statistics.getAverage());
        System.out.println(", count is " + statistics.getCount());
    }

    //M22
    public static void create_set() {
        System.out.println("method - " + getCurrentMethodName());

        Set<Integer> set = listOfNumbers.stream().collect(Collectors.toSet());
        System.out.println("set is - " + set);
    }


    //M23
    public static void boxedExample() {
        System.out.println("method - " + getCurrentMethodName());

        IntStream stream = IntStream.range(3, 8);
        // Creating a Stream of Integers Using IntStream boxed() to return
        // a Stream consisting of the elements of this stream, each boxed to an Integer.
        Stream<Integer> stream1 = stream.boxed();
        stream1.forEach(System.out::println);
    }

    //M24
    public static void get_Map_From_Two_Lists() {
        System.out.println("method - " + getCurrentMethodName());

        List<String> list = Arrays.asList("Bob", "John", "Matt");
        List<Integer> numbers = Arrays.asList(12, 19, 22);

        Map<String, Integer> map = IntStream.range(0, numbers.size()).boxed()
                .collect(Collectors.toMap(list::get, numbers::get));

        System.out.println(map);
    }


    //M25
    public static void sort() {
        System.out.println("method - " + getCurrentMethodName());

        listOfNumbers.sort((a, b) -> a.compareTo(b));
        System.out.println(listOfNumbers);
    }

    //M26
    public static void grouping_and_counting_elements() {
        System.out.println("method - " + getCurrentMethodName());

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : listOfNumbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
    }

    //M27
    public static void flat_map_example() {
        System.out.println("method - " + getCurrentMethodName());

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        /**
         * Using flatMap to flatten the list of lists into a single stream of integers
         */
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream()) // because we are getting list of list
                .collect(Collectors.toList());

        System.out.println(flattenedList);
    }


    //M28
    public static void find_products_with_price_greater_than_200() {
        System.out.println("method - " + getCurrentMethodName());

        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.getPrice() > 200.0)
                .collect(Collectors.toList());

        System.out.println(expensiveProducts);
    }

    //M29
    public static void total_Price_of_Products_in_shopping_cart() {
        System.out.println("method - " + getCurrentMethodName());

        double total = products.stream().mapToDouble(product -> product.getPrice()).sum();
        System.out.println(total);
    }

    //M30
    public static void product_with_highest_price() {
        System.out.println("method - " + getCurrentMethodName());

        OptionalDouble maxPrice = products.stream().mapToDouble(product -> product.getPrice()).max();
        System.out.println(maxPrice.getAsDouble());
        // 2nd way to solve the problem.
        Product maxPriceProduct = products.stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).orElse(null);
    }

    /**
     * mapToInt, mapToDouble r helpful, because they have max,min,avg Functions!
     */
    //M31
    public static void calculate_avg_price_of_products() {
        System.out.println("method - " + getCurrentMethodName());

        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }


    /**
     * flat map sabhi stream se Ek stream banata hai.
     */
    //M32
    public static void flatMapToCombineAllStreams() {
        System.out.println("method - " + getCurrentMethodName());

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
    //M33
    public static void betterVersionOfFlatMapToCombineAllStreams() {
        System.out.println("method - " + getCurrentMethodName());

        Map<String, Integer> map = Map.of("1", 1, "2", 2, "3", 3);
        List list = List.of("1", "2", "3");
        /**
         * OfNullable does same as if null then return empty Stream else return Stream of value from Map
         * in this case, Hashmap returns single value for the Key but intention is to merge all single values into a single stream.
         */
        List<Integer> xy = (List<Integer>) list.stream()
                .flatMap(x -> Stream.ofNullable(map.get(x))).collect(Collectors.toList());

        /**
         *  output - goals [1, 2, 3]
         */

        System.out.println("goals " + xy);
    }

    //M34
    public static void compareSortMapByValues() {
        System.out.println("method - " + getCurrentMethodName());

        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 25);
        unsortedMap.put("Alice", 30);
        unsortedMap.put("Bob", 20);
        unsortedMap.put("Eve", 35);

        // Sort the map by values in ascending order
        Map<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // we always have 2 versions in comparator first one is default and 2nd is provided with customization. search 'Map.Entry.comparingByValue'
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

    //M35
    public static void compareSortMapByComplexValues() {
        System.out.println("method - " + getCurrentMethodName());

        Map<String, Persona> personMap = new HashMap<>();
        personMap.put("Alice", new Persona("Alice", 25, 165.0));
        personMap.put("Bob", new Persona("Bob", 30, 175.5));
        personMap.put("Charlie", new Persona("Charlie", 22, 160.0));

        // Sort the map by values (Person objects) based on age
        Map<String, Persona> sortedMap = personMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Persona::getAge)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // Maintain insertion order
                ));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value.getName() + ", " + value.getAge()));
    }

    //M36
    public static void compareSortListOfIntegers() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 4, 2, 6, 4, 8, 6);
        // other way -  Collections.sort(numbers);
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

    //M37
    public static void compareSortDescendingOrder() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 4, 2, 6, 4, 8, 6);
        List<Integer> sortedNumbersDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    //M38
    public static void comparatorStringForCustomObjects() {
        System.out.println("method - " + getCurrentMethodName());

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", "LN1"));
        people.add(new Person("Bob", "LN2"));
        people.add(new Person("Charlie", "LN3"));

        // Sort the list of Person objects by age using Java Streams and a custom comparator
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());

        // Print the sorted list
        sortedPeople.forEach(System.out::println);
    }

    //M39
    public static void comparatorMixedForCustomObjects() {
        System.out.println("method - " + getCurrentMethodName());

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", "LN1"));
        people.add(new Person("Bob", "LN2"));
        people.add(new Person("Charlie", "LN3"));

        // Sort the list of Person objects by age using Java Streams and a custom comparator
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .collect(Collectors.toList());

        // Print the sorted list
        sortedPeople.forEach(System.out::println);
    }

    //M40
    public static void operationsOnNumbers() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // Check if all numbers are greater than 0
        boolean allGreaterThanZero = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All numbers greater than 0? " + allGreaterThanZero);

        // Check if any number is even
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any even number? " + anyEven);

        // Check if none of the numbers are negative
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("None of the numbers are negative? " + noneNegative);

        // Find the minimum number - remember this - critical strategy.
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        minNumber.ifPresent(min -> System.out.println("Minimum: " + min));

        // Find the maximum number
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
        maxNumber.ifPresent(max -> System.out.println("Maximum: " + max));
    }

    //M41
    public static void comparatorDoubleForCustomObjects() {
        System.out.println("method - " + getCurrentMethodName());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Alice", 10.11));
        products.add(new Product("Bob", 9.10));
        products.add(new Product("Charlie", 13.2));

        // Sort the list of products objects by price using Java Streams and a custom comparator
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        sortedProducts.forEach(System.out::println);
    }

    //M42
    public static void takeWhile() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> evenNumbers = numbers.stream()
                .takeWhile(n -> n < 4)
                .collect(Collectors.toList());

        System.out.println(evenNumbers); // Output: [1,2,3]
    }

    //M43
    public static void dropWhile() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> afterOddNumbers = numbers.stream()
                .dropWhile(n -> n < 4)
                .collect(Collectors.toList());

        System.out.println(afterOddNumbers); // Output: [4,5,6,7,8]
    }

    //M44
    public static void playWithOptional() {
        System.out.println("method - " + getCurrentMethodName());

        // creating optional
        Optional<String> presentOptional = Optional.of("Hello, World!");
        Optional<String> emptyOptional = Optional.empty();

        //Checking if a Value is Present:
        Optional<String> optional = Optional.of("Hello, World!");
        if (optional.isPresent()) {
            System.out.println("Value is present: " + optional.get());
        }

        // Get value from optional
        Optional<String> optionalGet = Optional.of("Hello, World!");
        String value = optionalGet.get();
        // Note - it's recommended to use 'get'' cautiously because it may throw a NoSuchElementException if the value is absent.

        // orElse
        Optional<String> optionalElse = Optional.empty();
        System.out.println(optionalElse.orElse("Default Value"));

        /**
         * You can provide a supplier function to generate a default value if the Optional is empty using orElseGet(supplier).
         * Optional<String> optionalGetWithSupplier = Optional.empty();
         * String value = optionalGetWithSupplier.orElseGet(() -> generateDefaultValue());

         ## orElseThrow()
         * Optional<String> optional = Optional.empty();
         * String value = optional.orElseThrow(() -> new NoSuchElementException("Value is absent"));

         */

        Optional<String> optionalTransform = Optional.of("Hello, World!");
        Optional<Integer> lengthOptional = optionalTransform.map(String::length);
        System.out.println(lengthOptional.get());
    }

    //M45
    public static void performanceMinimizeIntermediateOperations() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Bad: Multiple intermediate operations
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // Better: Combine intermediate operations
        List<Integer> betterResult = numbers.stream()
                .map(n -> n * 2)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    //M46
    public static void performanceUsePrimitives() {
        System.out.println("method - " + getCurrentMethodName());

        int[] intArray = {1, 2, 3, 4, 5};

        // Bad: Using a stream of boxed integers
        int sum = Arrays.stream(intArray)
                .boxed()
                .mapToInt(Integer::intValue)
                .sum();

        // Better: Using specialized IntStream
        int betterSum = Arrays.stream(intArray)
                .sum();
    }

    //M47
    public static void performanceParallelProcessing() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sequential processing
        long sequentialCount = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        // Parallel processing
        long parallelCount = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
    }

    //M48
    public static void performanceLazyEvaluation() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                })
                .limit(2) // Limit the output
                .collect(Collectors.toList());
    }

    /**
     * Collectors.toList() creates an ArrayList by default, so it's usually just as efficient as explicitly
     * specifying ArrayList with toCollection
     */
    //M49
    public static void performanceUseCollectorsWisely() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Bad: Using a toList collector unnecessarily
        List<Integer> result = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // Better: Using toCollection with a specific list type
        List<Integer> betterResult = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Collectors.toUnmodifiableList() (introduced in Java 10) to create an unmodifiable list,
     * which can have slightly better performance characteristics
     * in terms of memory usage and immutability.
     */
    //M50
    public static void performanceUnmodifiableList() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toUnmodifiableList());
    }

    //M51
    public static void debugStream() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = numbers.stream()
                .peek(n -> System.out.println("Processing: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Mapped: " + n))
                .collect(Collectors.toList());
    }

    //M52
    public static void exceptionHandlingInStream() {
        System.out.println("method - " + getCurrentMethodName());

        /* case - 1 */
        List<String> words = Arrays.asList("apple", "banana", null, "cherry");

        List<String> validWords = words.stream()
                .filter(word -> {
                    try {
                        return word.length() > 0; // Check for null and empty strings
                    } catch (NullPointerException e) {
                        return false; // Handle the exception by returning false
                    }
                })
                .collect(Collectors.toList());

        System.out.println(validWords); // Output: [apple, banana, cherry]

        /* case - 2 */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 0, 5);

        List<Integer> result = numbers.stream()
                .map(n -> {
                    try {
                        return 10 / n; // Handle division by zero
                    } catch (ArithmeticException e) {
                        return 0; // Handle the exception by returning 0
                    }
                })
                .collect(Collectors.toList());

        System.out.println(result); // Output: [10, 5, 3, 0, 2]

        /* case - 3 */
        List<String> wordsList = Arrays.asList("apple", "banana", null, "cherry");

        List<String> validWordsList = wordsList.stream()
                .map(Optional::ofNullable) // Wrap elements in Optional
                .map(optional -> optional.orElse("unknown")) // Handle null values
                .collect(Collectors.toList());

        System.out.println(validWordsList); // Output: [apple, banana, unknown, cherry]

        /* case - 4 - !! we stopped processing by throwing runtime exception !! */
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);

        try {
            int result4 = numbers4.stream()
                    .map(n -> {
                        if (n % 2 == 0) {
                            //throw new CustomException("Even numbers are not allowed.");
                            // Above line (throw runtime exception) will stop processing and send control back to caller.
                        }
                        return n;
                    })
                    .reduce(0, Integer::sum);

            System.out.println("Result: " + result4);
        } catch (CustomException e) {
            System.err.println("Custom Exception: " + e.getMessage());
        }
    }

    //M53
    public static void modifyUnmodifiableList() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> ll = Collections.unmodifiableList(testListOfNumbers);
        System.out.println(ll);
        testListOfNumbers.set(1, 100); // we can replace element and modify the unModifiable list!!
        //testListOfNumbers.add(10);  // `add(10)`, line will not allow to `add` underneath non-final mutable list, throws UnsupportedOperationException
        // So Insert is not permitted but update is permitted in above example. Please give 2 minutes to read and meditate.
        System.out.println(ll);

        // So always create unModifiableCollection using `of` method
        // List.of(1,2,3);

    }

    // M54
    public static void limitAndSkip() {
        System.out.println("method - " + getCurrentMethodName());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use limit to limit the number of elements processed
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5) // Limit to the first 5 elements
                .collect(Collectors.toList());

        System.out.println("Limited Numbers: " + limitedNumbers);

        // Use skip to skip a certain number of elements
        List<Integer> skippedNumbers = numbers.stream()
                .skip(5) // Skip the first 5 elements
                .collect(Collectors.toList());

        System.out.println("Skipped Numbers: " + skippedNumbers);
    }

    // M55
    public static void iterateUsingPredicate() {
        System.out.println("method - " + getCurrentMethodName());

        // case - 1
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "grape");
        Predicate<String> startsWithC = str -> str.startsWith("c");
        List<String> filteredWords = words.stream()
                .filter(startsWithC)
                .toList();
        filteredWords.forEach(System.out::println);

        // case - 2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> greaterThan5 = num -> num > 5;

        for (Integer num : numbers) {
            if (greaterThan5.test(num)) { // This line is important, look at `test` call.
                System.out.println(num);
            }
        }

        // case - 3; iterate stream with predicate
        long result = IntStream.iterate(1, n -> n < 1000, n -> n + 1) // IntStream, TypeStream (type can be double, long, int) is powerful can generate numbers, give analytics too!
                .filter(n -> n % 7 == 0)
                .count();
        System.out.println("result " + result);
    }

    // M56
    public static void comparatorExamples() {
        System.out.println("method - " + getCurrentMethodName());

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 25));
        students.add(new Student("Bob", 30));
        students.add(new Student("Carol", 25));
        students.add(new Student("David", 22));

        // Create a comparator for age
        Comparator<Student> byAge = Comparator.comparingInt(Student::getAge);

        // Create a comparator for name
        Comparator<Student> byName = Comparator.comparing(Student::getName);

        // Compose the comparators to sort by age and then by name
        Comparator<Student> ageThenName = byAge.thenComparing(byName); // Super!!

        // Use the comparator to sort the list of people
        List<Student> sortedPeople = students.stream()
                .sorted(ageThenName)
                .collect(Collectors.toList());

        // Print the sorted list
        sortedPeople.forEach(System.out::println);
    }


    /**
     * max, min, average
     */
    //M57
    public static void analytics() {
        System.out.println("method - " + getCurrentMethodName());

        //You can use mapToInt to find maximum, minimum, or average values because the specialized methods like max(), min(), and average() are available for IntStream.
        List<Integer> numbers = Arrays.asList(10, 4, 7, 19, 25, 2, 8, 14);

        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();

        System.out.println(max.getAsInt()); // we know number is present so not checking `ifPresent`

        // Find the minimum value
        OptionalInt min = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();

        System.out.println(min.getAsInt()); // we know number is present so not checking `ifPresent`


        // Calculate the average value
        OptionalDouble average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();

        System.out.println(average.getAsDouble()); // we know number is present so not checking `ifPresent`

    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        boolean allowed = false;

        if (args.length == 0) {
            allowed = true;
        }

        // you can run by giving method name too.
        if (!allowed) {

            JavaLambdaStream javaLambdaStream = new JavaLambdaStream();
            Optional<Method> method = Arrays.stream(JavaLambdaStream.class.getMethods())
                    .filter(m -> m.getName().equalsIgnoreCase(args[0]))
                    .findFirst();
            if (method.isPresent()) {
                method.get().invoke(javaLambdaStream);
            } else {
                System.out.println("No Method found..");
            }

        } else {

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

            betterVersionOfFlatMapToCombineAllStreams(); //33

            compareSortMapByValues(); //34

            compareSortMapByComplexValues(); //35

            compareSortListOfIntegers(); //36

            compareSortDescendingOrder(); //37

            comparatorStringForCustomObjects(); //38

            comparatorMixedForCustomObjects(); //39

            operationsOnNumbers(); //40

            comparatorDoubleForCustomObjects(); //41

            takeWhile(); //42

            dropWhile(); //43

            playWithOptional(); //44

            performanceMinimizeIntermediateOperations(); //45

            performanceUsePrimitives(); //46

            performanceParallelProcessing(); //47

            performanceLazyEvaluation(); //48

            performanceUseCollectorsWisely(); //49

            performanceUnmodifiableList(); //50

            debugStream(); //51

            exceptionHandlingInStream(); //52

            modifyUnmodifiableList(); //53

            limitAndSkip(); // 54

            iterateUsingPredicate(); // 55

            comparatorExamples(); // 56

            analytics();

        }
    }




    public static String value() {
        return "test-value";
    }

}
