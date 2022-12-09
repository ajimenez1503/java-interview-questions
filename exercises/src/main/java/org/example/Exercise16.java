package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercise16 {

    private Map<String, TreeMap<Integer, String>> timeMap;

    public Exercise16() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        Integer closerTimestamp = timeMap.get(key).floorKey(timestamp);
        if (closerTimestamp == null) {
            return "";
        }

        return timeMap.get(key).get(closerTimestamp);
    }
}
