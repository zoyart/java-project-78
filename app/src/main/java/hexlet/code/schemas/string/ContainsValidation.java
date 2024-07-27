package hexlet.code.schemas.string;

import hexlet.code.schemas.ValidationStrategy;

/**
 * Класс ContainsValidation является стратегией валидации.
 */
public class ContainsValidation implements ValidationStrategy {
    private final String subStr;

    public ContainsValidation(String subStr) {
        this.subStr = subStr;
    }

    /**
     * Метод проверяет, имеется ли подстрока в строке.
     *
     * @param input проверяемая строка.
     * @return возвращает true если в строке имеется подстрока и false если её нет.
     */
    public boolean validate(Object input) {
        String str = (String) input;
        return str.contains(subStr);
    }
}
