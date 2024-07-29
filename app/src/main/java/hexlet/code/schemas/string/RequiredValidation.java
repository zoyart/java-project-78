package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Objects;

public class RequiredValidation implements ValidationStrategy<String> {
    @Override
    public boolean validate(String input) {
        if (Objects.isNull(input)) {
            return false;
        }
        return !input.isEmpty();
    }
}
