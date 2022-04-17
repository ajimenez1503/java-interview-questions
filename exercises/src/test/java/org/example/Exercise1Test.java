package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Exercise1SecondMax.find2Max;
import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    @Test
    public void basic()
    {
        try {
            assertEquals((Integer)  3, find2Max(new ArrayList<Integer>(Arrays.asList(1,3,4))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void exceptionTesting() {
        try {
            find2Max(new ArrayList<Integer>());
        } catch (Exception e) {
            assertEquals("Cannot pass empty list", e.getMessage());
        }
    }

    @Test
    public void list1Elements()
    {
        try {
            assertEquals((Integer)  1, find2Max(new ArrayList<Integer>(Arrays.asList(1))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void list2Elements()
    {
        try {
            assertEquals((Integer)  1, find2Max(new ArrayList<Integer>(Arrays.asList(1, 2))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void listNegative()
    {
        try {
            assertEquals((Integer)  2, find2Max(new ArrayList<Integer>(Arrays.asList(-100, 0, 3, 1, 2))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
