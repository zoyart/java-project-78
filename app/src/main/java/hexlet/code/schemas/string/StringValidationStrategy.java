package hexlet.code.schemas.string;

public interface StringValidationStrategy<T> {
    boolean validate(T value);
}
