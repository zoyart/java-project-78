package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

/**
 * Класс ContainsValidation является стратегией валидации.
 */
public final class RequiredValidation implements ValidationStrategy<String> {
    public static final String NAME = "required";

    @Override
    public boolean validate(String input) {
        return !input.isEmpty();
    }
}
