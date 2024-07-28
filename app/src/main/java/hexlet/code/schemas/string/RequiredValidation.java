package hexlet.code.schemas.string;

import java.util.Objects;

public class RequiredValidation implements StringValidationStrategy<String> {
    @Override
    public boolean validate(String input) {
        if (Objects.isNull(input)) {
            return false;
        }
        return !input.isEmpty();
    }
}
