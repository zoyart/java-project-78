package hexlet.code.schemas.map;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Map;

/**
 * Класс ContainsValidation является стратегией валидации.
 */
public final class SizeofValidation<K, V> implements ValidationStrategy<Map<K, V>> {
    public static final String NAME = "sizeof";
    private final int size;

    public SizeofValidation(int paramSize) {
        this.size = paramSize;
    }

    @Override
    public boolean validate(Map<K, V> map) {
        return map.size() == this.size;
    }
}
