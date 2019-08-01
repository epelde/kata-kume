package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputNumberParsingTests {

    private StringOfNumbersParser parser;

    @BeforeEach
    public void setUp() {
        parser = new StringOfNumbersParser(",");
    }

    @Test
    public void empty_string_returns_array_with_just_one_zero() {
        String[] output = parser.parse("");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("0"));
    }

    @Test
    public void string_containing_just_one_number_returns_array_with_the_number() {
        String[] output = parser.parse("1");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("1"));
    }

    @Test
    public void string_containing_just_one_decimal_number_returns_array_with_the_number() {
        String[] output = parser.parse("1.2");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("1.2"));
    }

    @Test
    public void string_containing_two_numbers_returns_array_with_two_numbers() {
        String[] output = parser.parse("1,2");

        assertThat(output.length, equalTo(2));
        assertThat(output[0], equalTo("1"));
        assertThat(output[1], equalTo("2"));
    }

    @Test
    public void string_containing_two_decimal_numbers_returns_array_with_two_numbers() {
        String[] output = parser.parse("1.1,2.2");

        assertThat(output.length, equalTo(2));
        assertThat(output[0], equalTo("1.1"));
        assertThat(output[1], equalTo("2.2"));
    }


}
