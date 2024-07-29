package hexlet.code.schemas.numeric;

import hexlet.code.schemas.ValidationStrategy;

public class PositiveValidation implements ValidationStrategy<Integer> {
    @Override
    public boolean validate(Integer value) {
        return value > 0;
    }
}