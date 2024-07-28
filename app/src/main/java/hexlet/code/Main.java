package hexlet.code;

import hexlet.code.schemas.string.StringSchema;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringSchema schema = new StringSchema();
        System.out.println(schema.minLength(4).isValid("afg"));
    }
}
