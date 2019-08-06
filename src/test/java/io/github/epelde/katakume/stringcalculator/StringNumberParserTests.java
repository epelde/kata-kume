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
    public void empty_string_returns_array_with_zero_as_unique_element() {
        assertThat(parser.parse("").length, equalTo(1));
        assertThat(parser.parse("")[0], equalTo("0"));
    }

}
