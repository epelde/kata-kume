package io.github.epelde.katakume.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTests {

    @Test
    public void theFibonacciNumberForTheFirstPositionIsZero() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        assertEquals(0, fibonacciNumber.generate(1));

    }
}
