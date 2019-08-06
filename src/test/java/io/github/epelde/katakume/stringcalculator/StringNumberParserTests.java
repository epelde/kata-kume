package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringNumberParserTests {

    private StringNumberParser parser;

    @BeforeEach
    public void setUp() {
        parser = new StringNumberParser();
    }

    @Test
    public void empty_string_returns_zero_string() {
        String[] result = parser.parse("");

        assertThat(result.length, equalTo(1));
        assertThat(result[0], equalTo("0"));
    }

    @Test
    public void string_containing_one_number_returns_that_number() {
        String[] result = parser.parse("5");

        assertThat(result.length, equalTo(1));
        assertThat(result[0], equalTo("5"));
    }

}
