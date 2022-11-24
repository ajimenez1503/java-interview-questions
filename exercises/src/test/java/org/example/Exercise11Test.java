package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise11Test {
    @Test
    public void example1() {
        assertEquals(9, Exercise11.maxWordCount(getClass().getClassLoader().getResource("Exercise11/file1.txt").getPath()));
    }
}
