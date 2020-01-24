package helpers;

import enums.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Map<String, Object> scenarioContext = new HashMap<>();

    public void setContext(Context key, Object value) {
        if (hasKey(key)) {
            scenarioContext.clear();
        }
        scenarioContext.put(key.toString(), value);
    }

    public static Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }


    public Boolean hasKey(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

}