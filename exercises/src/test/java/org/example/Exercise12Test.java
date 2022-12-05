package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise12Test {

    @Test
    public void example1() {
        assertEquals("6321", Exercise12.removeX("56321", '5'));
    }

    @Test
    public void example2() {
        assertEquals("96230", Exercise12.removeX("936230", '3'));
    }
}
