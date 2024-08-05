package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

public final class RequiredValidation implements ValidationStrategy<String> {
    public static final String NAME = "required";

    @Override
    public boolean validate(String input) {
        return !input.isEmpty();
    }
}
