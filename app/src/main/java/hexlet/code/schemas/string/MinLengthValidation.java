package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

public class MinLengthValidation implements ValidationStrategy {
    private final int minLength;

    public MinLengthValidation(int minLength) {
        this.minLength = minLength;
    }

    public boolean validate(Object input) {
        String str = (String) input;
        return str.length() >= minLength;
    }
}
