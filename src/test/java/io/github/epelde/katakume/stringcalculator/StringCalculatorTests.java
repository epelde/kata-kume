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
    public void a_string_containing_just_one_number_returns_the_number() {
        assertThat(stringCalculator.add("1"), equalTo("1"));
    }

    @Test
    public void a_string_containing_just_one_decimal_number_returns_the_number() {
        assertThat(stringCalculator.add("3.4"), equalTo("3.4"));
    }

    @Test
    public void a_string_containing_two_numbers_returns_both_numbers_sum() {
        assertThat(stringCalculator.add("1,3"), equalTo("4"));
    }

    @Test
    public void a_string_containing_two_decimal_numbers_returns_both_numbers_sum() {
        assertThat(stringCalculator.add("1.1,1.2"), equalTo("2.3"));
    }

    @Test
    public void a_string_containing_many_numbers_returns_the_sum() {
        assertThat(stringCalculator.add("1.1,1.2,1.3,1.4,1.5"), equalTo("6.5"));
    }

    @Test
    public void add_method_also_handles_newline_separator() {
        assertThat(stringCalculator.add("1\n2,3"), equalTo("6"));
    }

}
