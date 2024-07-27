package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

import java.util.HashMap;
import java.util.Map;

public class StringSchema {
    Map<String, ValidationStrategy> strategies = new HashMap<>();

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

    public boolean isValid(String input) {
        for (Map.Entry<String, ValidationStrategy> entry : strategies.entrySet()) {
            ValidationStrategy validationStrategy = entry.getValue();
            if (!validationStrategy.validate(input)) {
                return false;
            }
        }
        return true;
    }
}
