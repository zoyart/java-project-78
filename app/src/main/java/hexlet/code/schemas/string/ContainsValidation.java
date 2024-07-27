package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

public class ContainsValidation implements ValidationStrategy {
    private final String subStr;

    public ContainsValidation(String subStr) {
        this.subStr = subStr;
    }

    public boolean validate(Object input) {
        String str = (String) input;
        return str.contains(subStr);
    }
}
