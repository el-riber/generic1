package genericsdemo;

public interface Processor<T> {
    T process(T input);
}
