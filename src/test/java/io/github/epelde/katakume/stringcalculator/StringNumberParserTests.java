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
        assertThat(parser.parse("").length, equalTo(1));
        assertThat(parser.parse("")[0], equalTo("0"));
    }

    @Test
    public void string_containing_one_number_returns_that_number() {
        assertThat(parser.parse("5").length, equalTo(1));
        assertThat(parser.parse("5")[0], equalTo("5"));
    }

}
