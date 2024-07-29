package hexlet.code.schemas.numeric;

import hexlet.code.schemas.BaseSchema;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        strategies.put("required", new RequiredValidation());
        return this;
    }

    public NumberSchema positive() {
        strategies.put("positive", new PositiveValidation());
        return this;
    }

    public NumberSchema range(int start, int end) {
        strategies.put("range", new RangeValidation(start, end));
        return this;
    }
}
