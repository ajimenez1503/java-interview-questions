package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise15<T, V> {
    Map<T, V> map;
    int capacity;

    Exercise15(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    V get(T key) {
        V cache = map.get(key);
        if (cache != null) {
            map.remove(key);
            map.put(key, cache);
        }
        return cache;
    }

    void put(T key, V value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key, value);
    }
}