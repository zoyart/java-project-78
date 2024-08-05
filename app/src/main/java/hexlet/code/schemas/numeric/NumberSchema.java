package hexlet.code.schemas.numeric;

import hexlet.code.schemas.BaseSchema;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        super.strategies.put(RequiredValidation.NAME, new RequiredValidation());
        return this;
    }

    public NumberSchema positive() {
        super.strategies.put(PositiveValidation.NAME, new PositiveValidation());
        return this;
    }

    public NumberSchema range(int start, int end) {
        super.strategies.put(RangeValidation.NAME, new RangeValidation(start, end));
        return this;
    }
}
