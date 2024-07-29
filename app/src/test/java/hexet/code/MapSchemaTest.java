package hexet.code;

import hexlet.code.schemas.map.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MapSchemaTest {
    MapSchema<String, String> schema;

    @BeforeEach
    void setUp() {
        schema = new MapSchema<>();
    }

    @Test
    public void testRequired() {
        boolean actual1 = schema.required().isValid(null);
        assertFalse(actual1);

        schema = new MapSchema<>();
        boolean actual2 = schema.required().isValid(new HashMap<>());
        assertTrue(actual2);
    }

    @Test
    public void testSizeof() {
        boolean actual1 = schema.sizeof(0).isValid(new HashMap<>());
        assertTrue(actual1);

        schema = new MapSchema<>();
        boolean actual2 = schema.sizeof(1).isValid(new HashMap<>());
        assertFalse(actual2);

        schema = new MapSchema<>();
        boolean actual3 = schema.sizeof(1).isValid(new HashMap<>(Map.of("abc", "foo")));
        assertTrue(actual3);
    }
}
