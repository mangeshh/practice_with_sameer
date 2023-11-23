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
public sealed class PracticeSealedClass permits Subclass1, Subclass2 {

    public String method() {
        return "running..";
    }

    /**
     * pattern matching in sealed class.
     *
     * @param shape
     * @return
     */
    public static String getDescription(PracticeSealedClass shape) {
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

@SuppressWarnings("unused")
final class Subclass {
    // Subclass definition
}

final class Subclass1 extends PracticeSealedClass {
    public String method() {
        return "running.. Subclass1";
    }
}

// Super Important.
non-sealed class Subclass2 extends PracticeSealedClass {
    public String method() {
        return "running.. Subclass2";
    }
}

/**
 * if we extend subclass, extending sealed class, then need to use either
 * sealed, non-sealed or final. (mandatory).
 */
class TestSeal extends Subclass2 {
    public void test() {
        System.out.println("because Subclass2 is non-sealed (declared before class), we can extend it");
    }
}


