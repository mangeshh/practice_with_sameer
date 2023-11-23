package java_8_21_practice;

/**
 *
 * Protected :  Protected is all about visibility.
 * Within the Same Package: If a class member is marked as protected, it is accessible to any class within the same package,
 * regardless of whether they are subclasses or not. Class members marked as protected can also be accessed by subclasses, even if they are in a different package.
 *
 *
 * Sealed classes :
 * Sealing a class allows you to restrict the set of subclasses that can be created.
 * This can help you maintain stronger encapsulation and prevent unintended access or extension of your class.
 *
 */

// the moment we try to access `SealedVsProtected` in subclass `Subclass` by `extends`, we get compile time error.
public sealed class SealedVsProtected permits Subclass1, Subclass2 {

    public void method(){
        System.out.println("hello");
    }
}

final class Subclass {
    // Subclass definition
}

final class Subclass1 extends SealedVsProtected {
    // Subclass definition
}

final class Subclass2 extends SealedVsProtected {
    // Subclass definition
}

