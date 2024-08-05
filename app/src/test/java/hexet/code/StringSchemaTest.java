package hexet.code;

import hexlet.code.schemas.string.StringSchema;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    public void setUp() {
        schema = new StringSchema();
    }

    @Test
    public void testRequiredValidation() {
        boolean actual1 = schema.isValid("");
        assertTrue(actual1);

        schema = new StringSchema();
        boolean actual2 = schema.isValid(null);
        assertTrue(actual2);

        schema = new StringSchema();
        boolean actual3 = schema.required().isValid(null);
        assertFalse(actual3);

        schema = new StringSchema();
        boolean actual4 = schema.required().isValid("");
        assertFalse(actual4);

        schema = new StringSchema();
        boolean actual5 = schema.required().isValid("abc");
        assertTrue(actual5);
    }

    @Test
    public void testMinLengthValidation() {
        boolean actual1 = schema.minLength(3).isValid("abc");
        assertTrue(actual1);

        schema = new StringSchema();
        boolean actual2 = schema.minLength(3).isValid("abcdf");
        assertTrue(actual2);

        schema = new StringSchema();
        boolean actual3 = schema.minLength(3).isValid("a");
        assertFalse(actual3);
    }

    @Test
    public void testContainsValidation() {
        boolean actual1 = schema.contains("text").isValid("Some text");
        assertTrue(actual1);

        schema = new StringSchema();
        boolean actual2 = schema.contains("Other").isValid("Some text");
        assertFalse(actual2);
    }

    @Test
    public void testInteractionRules() {
        boolean actual1 = schema.required().contains("xt").minLength(4).isValid("Text");
        assertTrue(actual1);

        schema = new StringSchema();
        boolean actual2 = schema.required().contains("text").minLength(10).isValid("Some text");
        assertFalse(actual2);
    }

    @Test
    public void testOverwritingParameters() {
        boolean actual1 = schema.required()
                .contains("bla")
                .minLength(100)
                .contains("abc")
                .minLength(5)
                .isValid("abcdf");
        assertTrue(actual1);
    }
}
