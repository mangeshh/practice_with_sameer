package java_8_21_practice;

/**
 * Protected :  Protected is all about visibility.
 * Within the Same Package: If a class member is marked as protected, it is accessible to any class within the same package,
 * regardless of whether they are subclasses or not. Class members marked as protected can also be accessed by subclasses, even if they are in a different package.
 * <p>
 * <p>
 * Sealed classes :
 * Sealing a class allows you to restrict the set of subclasses that can be created.
 * This can help you maintain stronger encapsulation and prevent unintended access or extension of your class.
 * <p>
 * Note - Unlike Scala, Java does not allow nested classes within sealed classes.
 */

// the moment we try to access `SealedVsProtected` in subclass `Subclass` by `extends`, we get compile time error.
public sealed class SealedVsProtected permits Subclass1, Subclass2 {

    public String method() {
        return "running..";
    }

    /**
     * pattern matching in sealed class.
     * @param shape
     * @return
     */
    public static String getDescription(SealedVsProtected shape) {
        return switch (shape) {
            case Subclass1 c -> "This is a SealedVsProtected with return value " + c.method();
            case Subclass2 s -> "This is a SealedVsProtected with return value " + s.method();
            default -> "Unknown shape";
        };
    }

    public static void main(String[] args) {
        Subclass1 subclass1 = new Subclass1();
        System.out.println(getDescription(subclass1));
    }
}

final class Subclass {
    // Subclass definition
}

final class Subclass1 extends SealedVsProtected {
    public String method() {
        return "running.. Subclass1";
    }
}

final class Subclass2 extends SealedVsProtected {
    public String method() {
        return "running.. Subclass2";
    }
}


