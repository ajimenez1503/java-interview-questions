package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Exercise6Test {
    @Test
    public void basic() {
        assertTrue(Exercise6.wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void fail() {
        assertFalse(Exercise6.wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    public void advance() {
        assertFalse(Exercise6.wordPattern("aaaa", "dog cat cat dog"));
    }
}
