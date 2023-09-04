package starter.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final Map<Object, Object> data = new HashMap<>();

    public void save(Object key, Object value) {
        data.put(key, value);
    }

    public Object get(Object key) {
        return data.get(key);
    }

    public <T> T getAs(Object key, Class<T> type) {
        return type.cast(data.get(key));
    }
}
