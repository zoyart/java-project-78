package hexlet.code.schemas;

public interface ValidationStrategy<T> {
    boolean validate(T value);
}
