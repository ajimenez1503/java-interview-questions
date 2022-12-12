package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise18Test {

    @Test
    void example() {
        Exercise18 s = new Exercise18(2, 1000);
        assertTrue(s.isAllowed("userId"));
        assertTrue(s.isAllowed("userId"));
        assertFalse(s.isAllowed("userId"));
        try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
        assertTrue(s.isAllowed("userId"));
        s.isAllowed("userId"); // It can return true or false
        assertFalse(s.isAllowed("userId"));
    }
}
