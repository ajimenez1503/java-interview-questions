package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Exercise2.countImpl1;
import static org.example.Exercise2.countImpl2;
import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    @Test
    public void basic() {
        try {
            assertEquals((Integer) 5, countImpl1(new ArrayList<Integer>(Arrays.asList(1, 3, 4))));
            assertEquals((Integer) 5, countImpl2(new ArrayList<Integer>(Arrays.asList(1, 3, 4))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void descriptionExample() {
        try {
            assertEquals((Integer) 9, countImpl1(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
            assertEquals((Integer) 9, countImpl2(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void fourConsecutiveElements() {
        try {
            assertEquals((Integer) 16, countImpl1(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
            assertEquals((Integer) 16, countImpl2(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void exceptionTesting() {
        try {
            countImpl1(new ArrayList<Integer>());
        } catch (Exception e) {
            assertEquals("Cannot pass empty list", e.getMessage());
        }
        try {
            countImpl2(new ArrayList<Integer>());
        } catch (Exception e) {
            assertEquals("Cannot pass empty list", e.getMessage());
        }
    }

    @Test
    public void list1Elements() {
        try {
            assertEquals((Integer) 1, countImpl1(new ArrayList<Integer>(Arrays.asList(1))));
            assertEquals((Integer) 1, countImpl2(new ArrayList<Integer>(Arrays.asList(1))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
