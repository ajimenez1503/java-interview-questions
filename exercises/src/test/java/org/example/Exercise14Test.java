package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise14Test {

    @Test
    void example() {
        Character[][] matrix = new Character[][]{
                {'M', 'S', 'E', 'F'},
                {'R', 'A', 'T', 'D'},
                {'L', 'O', 'N', 'E'},
                {'K', 'A', 'F', 'B'}
        };
        Set<String> result = Exercise14.findWords(matrix, new HashSet<>(Arrays.asList("START", "NOTE", "SAND", "STONED")));
        assertEquals(result, new HashSet<>(Arrays.asList("NOTE", "SAND", "STONED")));
    }
}
