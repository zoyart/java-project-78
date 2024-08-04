package hexlet.code.schemas;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class BaseSchema<T> {
    protected Map<String, ValidationStrategy<T>> strategies = new HashMap<>();

    /**
     * Проверяет, соответствует ли входная строка всем стратегиям валидации.
     *
     * @param dataToValidate Входная строка для проверки.
     * @return true, если входная строка проходит все стратегии валидации, иначе false.
     */
    public boolean isValid(T dataToValidate) {
        return validateData(dataToValidate, strategies);
    }

    /**
     * Проверяет, соответствует ли переданное значение всем заданным стратегиям валидации.
     *
     * @param <R>                Тип данных для валидации.
     * @param dataToValidate     Значение для валидации.
     * @param strategiesForData  Стратегии валидации, где ключ - строка, а значение - стратегия валидации.
     * @return true, если значение проходит все стратегии валидации, иначе false.
     */
    protected <R> boolean validateData(
            R dataToValidate,
            Map<String, ValidationStrategy<R>> strategiesForData) {
        /*
        Обработка null.
        1. Если данные == null и нет правила required, значит любые проверки будут true, можем сразу возвращать true
        2. Если данные == null и есть правило required, сразу возвращаем false, так как другие
           проверки не смогут работать с null.
         */
        if (dataToValidate == null) {
            return !strategiesForData.containsKey("required");
        }

        for (Map.Entry<String, ValidationStrategy<R>> entry : strategiesForData.entrySet()) {
            ValidationStrategy<R> validationStrategy = entry.getValue();
            if (!validationStrategy.validate(dataToValidate)) {
                return false;
            }
        }

        return true;
    }
}
