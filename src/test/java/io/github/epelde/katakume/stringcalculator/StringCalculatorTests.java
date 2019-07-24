package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTests {

    @Test
    public void dummy_add_test() {
        StringCalculator stringCalculator = new StringCalculator();
        String theValue = stringCalculator.add("");
        assertTrue(theValue.equals("theValue"));
    }
}
