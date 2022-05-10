package org.example;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Exercise9Test {
    @Test
    public void example1() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, Exercise9.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    public void example2() {
        assertArrayEquals(new int[]{1}, Exercise9.maxSlidingWindow(new int[]{1}, 1));
    }

    @Test
    public void example3() {
        assertArrayEquals(new int[]{11}, Exercise9.maxSlidingWindow(new int[]{9, 11}, 2));
    }

    @Test
    public void example4() {
        assertArrayEquals(new int[]{4, 7}, Exercise9.maxSlidingWindow(new int[]{2, 4, 7}, 2));
    }

    @Test
    public void example5() {
        assertArrayEquals(new int[]{3, 3, 2, 5}, Exercise9.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
    }

    @Test
    public void example6() {
        assertArrayEquals(new int[]{10, 10, 9, 2}, Exercise9.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5));
    }
}
