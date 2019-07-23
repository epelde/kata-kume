package io.github.epelde.katakume.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTests {

    // What happens if position is zero or negative???

    @Test
    public void theFibonacciNumberForTheFirstPositionIsZero() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        assertEquals(0, fibonacciNumber.generate(1));
    }

    @Test
    public void theFibonacciNumberForTheSecondPositionIsOne() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        assertEquals(1, fibonacciNumber.generate(2));
    }

    @Test
    public void theFibonacciNumberForTheThirdSPositionIsOne() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        assertEquals(1, fibonacciNumber.generate(3));
    }

}
