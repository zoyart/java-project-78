package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema<T> {
    protected Map<String, ValidationStrategy<T>> strategies = new HashMap<>();

    /**
     * Проверяет, соответствует ли входная строка всем стратегиям валидации.
     *
     * @param input Входная строка для проверки.
     * @return true, если входная строка проходит все стратегии валидации, иначе false.
     */
    public boolean isValid(T input) {
        for (Map.Entry<String, ValidationStrategy<T>> entry : strategies.entrySet()) {
            ValidationStrategy<T> validationStrategy = entry.getValue();
            if (!validationStrategy.validate(input)) {
                return false;
            }
        }
        return true;
    }
}
