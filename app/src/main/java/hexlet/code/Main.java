package hexlet.code;

import hexlet.code.schemas.numeric.NumberSchema;
import hexlet.code.schemas.string.StringSchema;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        NumberSchema schema = new NumberSchema();
        System.out.println(schema.required().positive().range(1, 5).isValid(0));
    }
}
