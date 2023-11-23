package java_8_21_practice;

import java.util.Objects;

public class PracticeRecord {

    /**
    *
    * Constructor: Records have an automatically generated constructor that initializes the components.
    * Records automatically generate accessor methods (getters) for each component.
    * Records automatically provide a sensible equals() and hashCode(), you can override also.
    * Records generate a toString() method.
    *
    *
    * ~~   main purpose of record is to hold immutable data  ~~
    *
    * Records are typically used to model data structures, DTOs (Data Transfer Objects), or other situations where you need a simple container for data.
    *
    **/
    public record Person(String name, int age) {
        // spend sometime and read this method.
        // Objects, Objects, Objects
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age); // Super important method.
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Alice1", 25);
        String name = person1.name();
        int age = person1.age();
        System.out.println(name + ", " + age);
        System.out.println(person1); // Output: Person[name=Alice, age=25]
        System.out.println(person1.equals(person2));

    }
}
