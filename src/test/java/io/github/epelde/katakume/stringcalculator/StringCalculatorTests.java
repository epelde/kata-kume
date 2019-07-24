package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringCalculatorTests {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void an_empty_string_returns_zero() {
        assertThat(stringCalculator.add(""), equalTo("0"));
    }

    @Test
    public void a_string_containing_one_number_returns_the_number() {
        assertThat(stringCalculator.add("1"), equalTo("1"));
        assertThat(stringCalculator.add("2"), equalTo("2"));
        assertThat(stringCalculator.add("3"), equalTo("3"));
    }

    @Test
    public void a_string_containing_two_numbers_returns_the_sum() {
        assertThat(stringCalculator.add("1,3"), equalTo("4"));
    }


}
