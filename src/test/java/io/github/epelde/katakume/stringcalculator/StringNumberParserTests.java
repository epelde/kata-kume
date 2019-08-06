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

    @Test
    public void string_containing_two_numbers_returns_two_elements() {
        String[] result = parser.parse("1,2");

        assertThat(result.length, equalTo(2));
        assertThat(result[0], equalTo("1"));
        assertThat(result[1], equalTo("2"));
    }

    @Test
    public void string_containing_many_numbers_is_parsed_to_many_numbers() {
        String[] result = parser.parse("1,2,3,4,5");

        assertThat(result.length, equalTo(5));
        assertThat(result[0], equalTo("1"));
        assertThat(result[1], equalTo("2"));
        assertThat(result[2], equalTo("3"));
        assertThat(result[3], equalTo("4"));
        assertThat(result[4], equalTo("5"));
    }

    @Test
    public void new_line_is_also_valid_separator() {
        String[] result = parser.parse("1,2,3\n4\n5");

        assertThat(result.length, equalTo(5));
        assertThat(result[0], equalTo("1"));
        assertThat(result[1], equalTo("2"));
        assertThat(result[2], equalTo("3"));
        assertThat(result[3], equalTo("4"));
        assertThat(result[4], equalTo("5"));
    }

}
