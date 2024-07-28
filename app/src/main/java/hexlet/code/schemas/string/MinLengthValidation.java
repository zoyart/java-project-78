package hexlet.code.schemas.string;

public class MinLengthValidation implements StringValidationStrategy<String> {
    private final int minLength;

    public MinLengthValidation(int minLength) {
        this.minLength = minLength;
    }

    public boolean validate(String input) {
        return input.length() >= minLength;
    }
}
