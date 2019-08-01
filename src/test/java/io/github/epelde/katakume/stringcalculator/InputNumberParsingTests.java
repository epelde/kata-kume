package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputNumberParsingTests {

    private InputNumberParser parser;

    @BeforeEach
    public void setUp() {
        parser = new InputNumberParser();
    }

    @Test
    public void empty_string_returns_array_with_just_one_zero() {
        String[] output = parser.parse("");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("0"));
    }
}
