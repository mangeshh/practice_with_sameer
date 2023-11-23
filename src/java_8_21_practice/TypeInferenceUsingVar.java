package java_8_21_practice;

public class TypeInferenceUsingVar {

/*

1> List<String> list = new ArrayList<>();

2> Predicate<Employee> highSalary = (Employee e) -> e.salary > 1_00_000 ;
   // Type Inference, looking at left-hand side.
   Predicate<Employee> highSalary = e -> e.salary > 1_00_000 ;

3> String ram = "Ram";
   // Type Inference, looking at right-hand side.
   var ram = "ram"

4> Employee e = new Employee();
   // Type Inference, looking at right-hand side. (bytecode is same, nothing changes at runtime!)
   var e = new Employee();

5> var list = List.of(1,2,3,4);
   for (var i : list){
      print(i);
   }

6> NOTE = var can not be used, as `method argument` (We will not know type to pass
   looking at the java docs, `return type` (developers will keep changing return type and
   it will cause type incompatibility) and `class instance variables` (reflection issues)
   var can not be used in `construction parameter` and `catch block` catch (var fileNotFoundException)

7> var `has to be initialized` while declaration.

8> confusion,
   byte b = 0; // it will narrow down number zero to byte but if we use var then
   var b = 0 // it will be declared as int type.

9> if we write
   var list = new ArrayList<>();
   list.add(1);
   list.add("one");
   // here we can add string and int because now because of var that list is 'list of object'.
   Note - but it's good if we do,  var list = new ArrayList<String>();

*/

}
