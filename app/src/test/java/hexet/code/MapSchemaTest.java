package hexet.code;

import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.map.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MapSchemaTest {
    MapSchema schema;
    Validator validator;

    @BeforeEach
    void setUp() {
        schema = new MapSchema();
        validator = new Validator();
    }

    @Test
    public void testRequired() {
        boolean actual1 = schema.required().isValid(null);
        assertFalse(actual1);

        schema = new MapSchema();
        boolean actual2 = schema.required().isValid(new HashMap<>());
        assertTrue(actual2);
    }

    @Test
    public void testSizeof() {
        boolean actual1 = schema.sizeof(0).isValid(new HashMap<>());
        assertTrue(actual1);

        schema = new MapSchema();
        boolean actual2 = schema.sizeof(1).isValid(new HashMap<>());
        assertFalse(actual2);

        schema = new MapSchema();
        boolean actual3 = schema.sizeof(1).isValid(new HashMap<>(Map.of("abc", "foo")));
        assertTrue(actual3);
    }

    @Test
    public void testKeyValidation1() {
        var mapSchema = new Validator().<String, String>map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", validator.string().required().minLength(5));
        schemas.put("lastName", validator.string().minLength(3));

        mapSchema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "Artur");
        human1.put("lastName", null);

        // Так как нет required у lastName валидации, то при значении null любая валидация должна быть true.
        boolean actual1 = mapSchema.isValid(human1);
        assertTrue(actual1);
    }

    @Test
    public void testKeyValidation2() {
        var mapSchema = new Validator().<String, Integer>map();

        Map<String, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put("firstName", validator.number().required().range(1, 6));
        schemas.put("lastName", validator.number().required().positive());

        mapSchema.shape(schemas);

        Map<String, Integer> human1 = new HashMap<>();
        human1.put("firstName", 5);
        human1.put("lastName", null);

        boolean actual1 = mapSchema.isValid(human1);
        assertFalse(actual1);
    }
}
