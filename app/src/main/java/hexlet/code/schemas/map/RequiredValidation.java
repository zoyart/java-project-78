package hexlet.code.schemas.map;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Map;

/**
 * Класс ContainsValidation является стратегией валидации.
 */
public final class RequiredValidation<K, V> implements ValidationStrategy<Map<K, V>> {
    public static final String NAME = "required";

    @Override
    public boolean validate(Map<K, V> map) {
        return map != null;
    }
}
