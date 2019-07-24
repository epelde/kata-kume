package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringCalculatorTests {

    @Test
    public void an_empty_string_returns_zero() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.add(""), equalTo("0"));
    }
}
