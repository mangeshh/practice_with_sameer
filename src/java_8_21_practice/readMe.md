
!!! !!!!!! !!!!!!!!! Always go to main method, to understand it better. !!! !!!!!! !!!!!!!!! 


>>> stackoverflow blog start.

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

>>> stackoverflow blog ends.

***
Command to find deprecated classes in application - `javac -Xlint:deprecation `

