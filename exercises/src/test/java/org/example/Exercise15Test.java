package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Exercise15Test {
    @Test
    void example() {
        Exercise15<Integer, String> lRUCache = new Exercise15<>(2);
        lRUCache.put(1, "A");                    // cache is {1="A"}
        assertEquals("A", lRUCache.get(1));    // return "A"
        lRUCache.put(2, "B");                    // cache is {1="A", 2="B"}
        lRUCache.put(3, "D");                    // LRU key was 1, cache is {2="B", 3="D"}
        assertEquals("B", lRUCache.get(2));    // returns "B"
        lRUCache.put(10, "SOMETHING");           // LRU key was 3, cache is {2="B", 10="SOMETHING"}
        assertNull(lRUCache.get(3));    // returns null
        assertEquals("B", lRUCache.get(2));    // returns "B"
        assertEquals("SOMETHING", lRUCache.get(10));   // returns "SOMETHING"
        lRUCache.put(2, "P");                   // Replacing key, cache is {2="P", 10="SOMETHING"}
        lRUCache.put(3, "G");                    // LRU key was 10, cache is {2="P", 3="G"}
        assertNull(lRUCache.get(10));   // returns null
        assertEquals("P", lRUCache.get(2));    // returns "P"
        assertEquals("G", lRUCache.get(3));    // returns "G"
    }
}
