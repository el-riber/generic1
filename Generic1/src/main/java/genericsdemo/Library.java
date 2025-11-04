package genericsdemo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A generic Library for managing items of any type T.
 * nameExtractor tells Library how to get a "name" from T.
 */
public class Library<T> {
    private final List<T> items = new ArrayList<>();
    private final Function<T, String> nameExtractor;

    public Library(Function<T, String> nameExtractor) {
        this.nameExtractor = nameExtractor;
    }

    public void add(T item) {
        items.add(item);
    }

    public boolean removeByName(String name) {
        return items.removeIf(i -> Objects.equals(nameExtractor.apply(i), name));
    }

    public Optional<T> findByName(String name) {
        return items.stream()
                .filter(i -> Objects.equals(nameExtractor.apply(i), name))
                .findFirst();
    }

    public List<T> listAll() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public String toString() {
        return items.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    // Simple record-like classes for demo
    public static class Book {
        public final String title;
        public final String author;

        public Book(String title, String author) {
            this.title = title; this.author = author;
        }
        @Override public String toString() { return "Book{" + title + " by " + author + "}"; }
    }

    public static class Dvd {
        public final String title;
        public final int year;

        public Dvd(String title, int year) {
            this.title = title; this.year = year;
        }
        @Override public String toString() { return "DVD{" + title + " (" + year + ")}"; }
    }
}
