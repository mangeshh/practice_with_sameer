package java_8_21_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
    String name;
    double salary;

}

public class TypeInferenceUsingVar {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Predicate<Employee> highSalary1 = (Employee e) -> e.salary > 1_00_000;
        // Type Inference, looking at left-hand side.
        Predicate<Employee> highSalary2 = e -> e.salary > 1_00_000;

        // String ram = "Ram";
        // Type Inference, looking at right-hand side.
        var ram = "ram"; // it will be defined as String.

        // Employee e = new Employee();
        // Type Inference, looking at right-hand side. (bytecode is same, nothing changes at runtime!)
        var e = new Employee(); // it will be defined as Employee.

        var listVar = List.of(1, 2, 3, 4);
        for (var i : listVar) {
            System.out.println(i);
        }

        /**
         *
        NOTE = var can not be used, as `method argument` (We will not know type to pass
        looking at the java docs, `return type` (developers will keep changing return type and
        it will cause type incompatibility) and `class instance variables` (reflection issues)
        var can not be used in `construction parameter` and `catch block` catch (var fileNotFoundException)

        var `has to be initialized` while declaration.

        **/

        // confusion!
        //byte b = 0; it will narrow down number zero to byte but if we use var then
        var b = 0; // it will be declared as int type.

        var listWithDiffDataTypes = new ArrayList<>();
        listWithDiffDataTypes.add(1);
        listWithDiffDataTypes.add("one");
        // here we can add string and int because now because of var that list is 'list of object'.
        // but it's good if we do, var list = new ArrayList<String>();

    }

}
