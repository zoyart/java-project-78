package hexlet.code.schemas.numeric;

import hexlet.code.schemas.ValidationStrategy;

/**
 * Класс ContainsValidation является стратегией валидации.
 */
public final class RangeValidation implements ValidationStrategy<Integer> {
    public static final String NAME = "range";
    private final int start;
    private final int end;

    public RangeValidation(int paramStart, int paramEnd) {
        this.start = paramStart;
        this.end = paramEnd;
    }

    @Override
    public boolean validate(Integer input) {
        return input >= start && input <= end;
    }
}
