package org.example;

import org.example.exercise4.LoadBalancer;
import org.example.exercise4.Node;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Exercise5Test {
    @Test
    public void basic() {
        assertEquals(3, Exercise5.coinChangeImpl1(new int[]{1, 2, 5}, 11));
        assertEquals(3, Exercise5.coinChangeImpl2(new int[]{1, 2, 5}, 11));

    }

    @Test
    public void fail() {
        assertEquals(-1, Exercise5.coinChangeImpl1(new int[]{2}, 3));
        assertEquals(-1, Exercise5.coinChangeImpl2(new int[]{2}, 3));

    }


    @Test
    public void amount0() {
        assertEquals(0, Exercise5.coinChangeImpl1(new int[]{1,2,5}, 0));
        assertEquals(0, Exercise5.coinChangeImpl2(new int[]{1,2,5}, 0));
    }

    @Test
    public void advance() {
        assertEquals(2, Exercise5.coinChangeImpl1(new int[]{2,3,4}, 5));
        assertEquals(2, Exercise5.coinChangeImpl2(new int[]{2,3,4}, 5));
    }
}
