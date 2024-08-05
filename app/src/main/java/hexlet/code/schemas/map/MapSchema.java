package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.ValidationStrategy;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    private final Map<K, BaseSchema<V>> strategiesForKeys = new HashMap<>();

    public MapSchema<K, V> required() {
        super.strategies.put(RequiredValidation.NAME, new RequiredValidation<>());
        return this;
    }

    public MapSchema<K, V> sizeof(int size) {
        super.strategies.put(SizeofValidation.NAME, new SizeofValidation<>(size));
        return this;
    }

    public void shape(Map<K, BaseSchema<V>> schemas) {
        this.strategiesForKeys.putAll(schemas);
    }

    @Override
    public boolean isValid(Map<K, V> dataToValidate) {
        // Проверка установленных стратегий для самого Map
        boolean checkValidationStrategiesForMap = validateData(dataToValidate, super.strategies);

        // Проверка всех "ключ->стратегия" для значений в Map
        boolean checkValidationStrategiesForKeys = strategiesForKeys.entrySet().stream()
                .allMatch((entry) -> {
                    if (!dataToValidate.containsKey(entry.getKey())) {
                        return true;
                    }

                    V keyDataToValidate = dataToValidate.get(entry.getKey());
                    Map<String, ValidationStrategy<V>> strategies = entry.getValue().getStrategies();

                    return validateData(keyDataToValidate, strategies);
                });

        return checkValidationStrategiesForMap && checkValidationStrategiesForKeys;
    }
}
