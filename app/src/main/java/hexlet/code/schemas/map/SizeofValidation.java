package hexlet.code.schemas.map;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Map;

public class SizeofValidation<K, V> implements ValidationStrategy<Map<K, V>> {
    private final int size;

    public SizeofValidation(int size) {
        this.size = size;
    }

    @Override
    public boolean validate(Map<K, V> map) {
        return map.size() == size;
    }
}
