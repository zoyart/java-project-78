package hexlet.code.schemas.string;

import hexlet.code.schemas.BaseSchema;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        super.strategies.put(RequiredValidation.NAME, new RequiredValidation());
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.strategies.put(MinLengthValidation.NAME, new MinLengthValidation(minLength));
        return this;
    }

    public StringSchema contains(String subStr) {
        super.strategies.put(ContainsValidation.NAME, new ContainsValidation(subStr));
        return this;
    }
}
