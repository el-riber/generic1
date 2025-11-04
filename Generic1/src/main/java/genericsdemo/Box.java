package genericsdemo;

public class Box<T> {
    private T value;

    public Box() {}

    public Box(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    // Part 1: Generic method (works for any Box<U>)
    public static <U> void printBox(Box<U> box) {
        System.out.println("Box holds: " + box.get());
    }

    @Override
    public String toString() {
        return "Box{" + String.valueOf(value) + "}";
    }
}
