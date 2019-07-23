package io.github.epelde.katakume.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSequenceTests {

    @Test
    public void theFibonacciSeqForTheFirstPositionIsZero() {
        FibonacciSeq fibonacciSeq = new FibonacciSeq();
        assertEquals(0, fibonacciSeq.generate(1));

    }
}
