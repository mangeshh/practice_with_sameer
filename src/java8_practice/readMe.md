While working, I got the warning

The constructor Integer(int) is deprecated, and I couldn't find an alternative constructor/solution online. How can I resolve this issue ?

UPDATE

I will get a similar warning with constructors for other primitive wrapper types; e.g.

The constructor Boolean(boolean) is deprecated
The constructor Byte(byte) is deprecated
The constructor Short(short) is deprecated
The constructor Character(char) is deprecated
The constructor Long(long) is deprecated
The constructor Float(float) is deprecated
The constructor Double(double) is deprecated
Does the same solution apply to these classes as for Integer?

<--- ANSWER --->
You can use

`Integer integer = Integer.valueOf(i);`

From the javadoc of the constructor:

The static factory valueOf(int) is generally a better choice, as it is likely to yield significantly better space and time performance. Constructs a newly allocated Integer object that represents the specified int value.
The main difference is that you won't always get a new instance with valueOf as small Integer instances are cached.
All primitive wrapper types (Boolean, Byte, Char, Short, Integer, Long, Float and Double) have adopted the same pattern. In general, replace:

    new <WrapperType>(<primitiveType>)
with

    <WrapperType>.valueOf(<primitiveType>)

(Note that the caching behavior mentioned above differs with the type and the Java platform, but the Java 9+ deprecation applies notwithstanding these differences.)

***
Command to find deprecated classes in application - `javac -Xlint:deprecation `

*******

Type Inference :

1> List<String> list = new ArrayList<>();

2> Predicate<Employee> highSalary = (Employee e) -> e.salary > 1_00_000 ;
   // Now let's see Type Inference, looking at left-hand side.
   Predicate<Employee> highSalary = e -> e.salary > 1_00_000 ;

3> String ram = "Ram";
   // Now let's see Type Inference, looking at right-hand side.
   var ram = "ram"

4> Employee e = new Employee();
   // Now let's see Type Inference, looking at right-hand side. (bytecode is same, nothing changes at runtime!)
   var e = new Employee();

5> var list = List.of(1,2,3,4);
   for (var i : list){
      print(i);
   }

6> NOTE = var can not be used, as method argument (we will not know type to pass
   looking at the java docs, return type (developers will keep changing return type and 
   it will cause type incompatibility) and class instance variables (reflection issues)
   var can not be used in construction parameter and catch block catch (var fileNotFoundException)
   
7> var has to be initialized while declaration.

8> confusion, say
   byte b = 0; // it will narrow down number zero to byte but if we use var then
   var b = 0 // it will be declared as int type.

9> if we write
   var list = new ArrayList<>();
   list.add(1);
   list.add("one");
   // here we can add string and int because now because of var that list is 'list of object'.
   Note - but it's good if we do,  var list = new ArrayList<String>();

10> 