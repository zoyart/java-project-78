package hexlet.code.schemas.string;

import hexlet.code.schemas.BaseSchema;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        strategies.put("required", new RequiredValidation());
        return this;
    }

    public StringSchema minLength(int minLength) {
        strategies.put("minLength", new MinLengthValidation(minLength));
        return this;
    }

    public StringSchema contains(String subStr) {
        strategies.put("contains", new ContainsValidation(subStr));
        return this;
    }
}
