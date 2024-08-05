package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.map.MapSchema;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        System.out.println(schema.isValid(human1));
         // true
    }
}
