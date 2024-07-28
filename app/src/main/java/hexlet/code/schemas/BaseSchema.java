package hexlet.code.schemas;

import hexlet.code.schemas.string.StringValidationStrategy;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema<T> {
    protected Map<String, StringValidationStrategy<T>> strategies = new HashMap<>();

    /**
     * Проверяет, соответствует ли входная строка всем стратегиям валидации.
     *
     * @param input Входная строка для проверки.
     * @return true, если входная строка проходит все стратегии валидации, иначе false.
     */
    public boolean isValid(T input) {
        for (Map.Entry<String, StringValidationStrategy<T>> entry : strategies.entrySet()) {
            StringValidationStrategy<T> validationStrategy = entry.getValue();
            if (!validationStrategy.validate(input)) {
                return false;
            }
        }
        return true;
    }
}
