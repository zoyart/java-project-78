package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.map.MapSchema;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema<Float, String> schema = v.map();

        Map<Float, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put(0.1f, v.string().required());
        schemas.put(0.2f, v.string().required().minLength(2));

        schema.shape(schemas);

        Map<Float, String> human1 = new HashMap<>();
        human1.put(0.1f, "John");
        human1.put(0.2f, "Smith");
        schema.isValid(human1); // true
    }

}
