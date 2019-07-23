package io.github.epelde.katakume.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonacciNumberTests {

    private FibonacciNumber fibonacciNumber;

    @BeforeEach
    public void setup() {
        fibonacciNumber = new FibonacciNumber();
    }

    // What happens if position is zero or negative???

    @Test
    public void theFibonacciNumberForTheFirstPositionIsZero() {
        assertThat(fibonacciNumber.generate(1), equalTo(0));
    }

    @Test
    public void theFibonacciNumberForTheSecondPositionIsOne() {
        assertThat(fibonacciNumber.generate(2), equalTo(1));
    }

    @Test
    public void theFibonacciNumberForTheThirdPositionIsOne() {
        assertThat(fibonacciNumber.generate(3), equalTo(1));
    }

    @Test
    public void generateFibonacciNumberForVariousPositions() {
        assertThat(fibonacciNumber.generate(4), equalTo(2));
        assertThat(fibonacciNumber.generate(5), equalTo(3));
        assertThat(fibonacciNumber.generate(6), equalTo(5));
        assertThat(fibonacciNumber.generate(7), equalTo(8));
        assertThat(fibonacciNumber.generate(8), equalTo(13));
        assertThat(fibonacciNumber.generate(9), equalTo(21));
        assertThat(fibonacciNumber.generate(10), equalTo(34));
    }


}
