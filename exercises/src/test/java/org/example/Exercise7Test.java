package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Exercise7Test {
    @Test
    public void basic() {
        assertEquals(1, Exercise7.searchBruteForce("TEST", "THIS IS A TEST TEXT"));
        assertEquals(1, Exercise7.searchKMP("TEST", "THIS IS A TEST TEXT"));
    }

    @Test
    public void example() {
        assertEquals(2, Exercise7.searchBruteForce("AABA", "AAAAABAAABA"));
        assertEquals(2, Exercise7.searchKMP("AABA", "AAAAABAAABA"));
    }

    @Test
    public void advance() {
        assertEquals(3, Exercise7.searchBruteForce("AABA", "AABAACAADAABAABA"));
        assertEquals(3, Exercise7.searchKMP("AABA", "AABAACAADAABAABA"));
    }
}
