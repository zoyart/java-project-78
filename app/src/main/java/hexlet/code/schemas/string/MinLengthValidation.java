package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

/**
 * Класс MinLengthValidation является стратегией валидации.
 */
public final class MinLengthValidation implements ValidationStrategy<String> {
    public static final String NAME = "minLength";
    private final int minLength;

    public MinLengthValidation(int paramMinLength) {
        this.minLength = paramMinLength;
    }

    public boolean validate(String input) {
        return input.length() >= minLength;
    }
}
