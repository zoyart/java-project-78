package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Objects;

public class RequiredValidation implements ValidationStrategy {
    @Override
    public boolean validate(Object input) {
        if (Objects.isNull(input)) {
            return false;
        }
        return !input.equals("");
    }
}
