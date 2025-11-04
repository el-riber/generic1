package genericsdemo;

// Only accepts Number or its subclasses
public class NumberBox<T extends Number> extends Box<T> {

    public NumberBox() {}

    public NumberBox(T value) {
        super(value);
    }

    // Part 2: Wildcards — accept any Box whose type extends Number
    public static void printNumberBox(Box<? extends Number> box) {
        Number n = box.get();
        // Show a useful numeric operation to prove it's a Number
        double asDouble = (n == null) ? Double.NaN : n.doubleValue();
        System.out.println("NumberBox holds (as double): " + asDouble);
    }
}
