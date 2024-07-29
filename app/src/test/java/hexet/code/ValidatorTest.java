package hexet.code;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import hexlet.code.Validator;
import hexlet.code.schemas.numeric.NumberSchema;
import hexlet.code.schemas.string.StringSchema;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void testCreateSchemas() {
        Validator validator = new Validator();
        var stringSchema = validator.string();
        var numberSchema = validator.number();
        assertInstanceOf(StringSchema.class, stringSchema);
        assertInstanceOf(NumberSchema.class, numberSchema);
    }
}
