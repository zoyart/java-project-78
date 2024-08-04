package hexlet.code.schemas.numeric;

import hexlet.code.schemas.ValidationStrategy;

public class RequiredValidation implements ValidationStrategy<Integer> {
    public static final String NAME = "required";

    @Override
    public boolean validate(Integer value) {
        return value != null;
    }
}
