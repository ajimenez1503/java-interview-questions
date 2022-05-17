package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Exercise10Test {
    @Test
    public void example1() {
        assertEquals(
                Arrays.asList(new Integer[]{1, 2, 1, 1, 0, 2, 1, 0, 0, 1, 1}),
                Exercise10.calc_buckets(new int[]{90, 11, 3, 35, 17, 28, 64, 53, 52, 110}, 11, 10));
    }
}