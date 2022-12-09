package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise17Test {

    @Test
    void example() {
        Exercise17 minStack = new Exercise17();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        assertEquals(0, minStack.top());    // return 0
        assertEquals(-2, minStack.getMin()); // return -2
    }
}
