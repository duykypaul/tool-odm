package org.example;

import java.util.Map;

public class DTO {
    private String key;
    private Map<Integer, String> valueUpdates;

    public DTO(String key, Map<Integer, String> valueUpdates) {
        this.key = key;
        this.valueUpdates = valueUpdates;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<Integer, String> getValueUpdates() {
        return valueUpdates;
    }

    public void setValueUpdates(Map<Integer, String> valueUpdates) {
        this.valueUpdates = valueUpdates;
    }
}
