package hexlet.code.schemas.numeric;

import hexlet.code.schemas.ValidationStrategy;

public class RangeValidation implements ValidationStrategy<Integer> {
    private final int start;
    private final int end;

    public RangeValidation(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean validate(Integer value) {
        return value >= start && value <= end;
    }
}
