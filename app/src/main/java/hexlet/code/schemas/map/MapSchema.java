package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    public MapSchema<K, V> required() {
        strategies.put("required", new RequiredValidation<>());
        return this;
    }

    public MapSchema<K, V> sizeof(int size) {
        strategies.put("sizeof", new SizeofValidation<>(size));
        return this;
    }
}
