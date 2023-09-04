package starter.context;

import java.util.Arrays;

public enum DataKeys {
    RESPONSE;

    public static DataKeys getByName(String name) {
        return Arrays.stream(DataKeys.values()).filter(d -> d.name().equals(name)).findFirst().orElse(null);
    }
}
