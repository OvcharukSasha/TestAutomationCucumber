package utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public <T> void setContext(Context key, T value) {
        scenarioContext.put(key.toString(), value);
    }

}
