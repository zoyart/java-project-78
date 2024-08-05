package hexlet.code.schemas.numeric;

import hexlet.code.schemas.ValidationStrategy;

public final class PositiveValidation implements ValidationStrategy<Integer> {
    public static final String NAME = "positive";

    @Override
    public boolean validate(Integer value) {
        return value > 0;
    }
}
