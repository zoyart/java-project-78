package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {
    List<ValidationStrategy> strategies = new ArrayList<>();

    public StringSchema required() {
        strategies.add(new RequiredValidation());
        return this;
    }

    public StringSchema minLength(int minLength) {
        strategies.add(new MinLengthValidation(minLength));
        return this;
    }

    public StringSchema contains(String subStr) {
        strategies.add(new ContainsValidation(subStr));
        return this;
    }

    public boolean isValid(String input) {
        for (ValidationStrategy validationStrategy : strategies) {
            if (!validationStrategy.validate(input)) {
                return false;
            }
        }
        return true;
    }
}
