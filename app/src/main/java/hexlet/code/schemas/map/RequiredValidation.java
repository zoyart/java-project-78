package hexlet.code.schemas.map;

import hexlet.code.schemas.ValidationStrategy;

import java.util.Map;

public class RequiredValidation<K, V> implements ValidationStrategy<Map<K, V>> {
    @Override
    public boolean validate(Map<K, V> map) {
        return map != null ;
    }
}
