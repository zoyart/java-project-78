package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

public class MinLengthValidation implements ValidationStrategy<String> {
    public static final String NAME = "minLength";
    private final int minLength;

    public MinLengthValidation(int minLength) {
        this.minLength = minLength;
    }

    public boolean validate(String input) {
        return input.length() >= minLength;
    }
}
