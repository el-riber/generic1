package genericsdemo;

public class Main {
    public static void main(String[] args) {
        // ===== Part 1: Understanding Generics =====
        // Generic class Box<T>
        Box<Integer> intBox = new Box<>(42);
        Box<String> stringBox = new Box<>("Hello Generics");

        // set/get demo
        System.out.println("intBox.get() = " + intBox.get());
        System.out.println("stringBox.get() = " + stringBox.get());

        // Generic method inside Box
        Box.printBox(intBox);
        Box.printBox(stringBox);

        // Bounded type parameters with NumberBox<T extends Number>
        NumberBox<Integer> nbInt = new NumberBox<>(10);
        NumberBox<Double> nbDouble = new NumberBox<>(3.1415);
        System.out.println("nbInt = " + nbInt);
        System.out.println("nbDouble = " + nbDouble);

        // Compile-time safety demo (uncomment to see the error):
        // NumberBox<String> nbBad = new NumberBox<>("not a number"); // ❌ won't compile

        // ===== Part 2: Advanced Usage =====
        // Wildcards: accept any Box<? extends Number>
        NumberBox.printNumberBox(nbInt);
        NumberBox.printNumberBox(nbDouble);

        // Generic interface + implementation
        Processor<String> rev = new StringProcessor();
        String original = "Generics are powerful!";
        String reversed = rev.process(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        // ===== Part 3: Practical Application =====
        // A generic Library<T> that can manage different item types
        Library<Library.Book> bookLibrary =
                new Library<>(book -> book.title);
        bookLibrary.add(new Library.Book("Clean Code", "Robert C. Martin"));
        bookLibrary.add(new Library.Book("Effective Java", "Joshua Bloch"));

        System.out.println("Books: " + bookLibrary);
        System.out.println("Find 'Clean Code': " + bookLibrary.findByName("Clean Code").orElse(null));
        System.out.println("Remove 'Effective Java': " + bookLibrary.removeByName("Effective Java"));
        System.out.println("Books after removal: " + bookLibrary);

        Library<Library.Dvd> dvdLibrary =
                new Library<>(dvd -> dvd.title);
        dvdLibrary.add(new Library.Dvd("Inception", 2010));
        dvdLibrary.add(new Library.Dvd("The Matrix", 1999));

        System.out.println("DVDs: " + dvdLibrary);
        System.out.println("Find 'Inception': " + dvdLibrary.findByName("Inception").orElse(null));
        System.out.println("Remove 'Unknown' (should be false): " + dvdLibrary.removeByName("Unknown"));
        System.out.println("DVDs after failed removal: " + dvdLibrary);

        // ===== Suggested edge checks for your demo =====
        // Empty Box printing
        Box<String> empty = new Box<>();
        Box.printBox(empty);

        // Null-safe reverse
        System.out.println("Reverse null: " + rev.process(null));

        // Large number in NumberBox
        NumberBox<Long> nbLong = new NumberBox<>(1234567890123456789L);
        NumberBox.printNumberBox(nbLong);
    }
}
