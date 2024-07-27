package hexlet.code;

import hexlet.code.schemas.string.StringSchema;

public class Validator {
    /**
     * Возвращает объект класса StringSchema, который предоставляет методы для валидации строк.
     *
     * @return экземпляр класса StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }
}
