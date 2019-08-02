package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class InputNumberParsingTests {

    private StringOfNumbersParser parser;

    @BeforeEach
    public void setUp() {
        parser = new StringOfNumbersParser();
    }

    @Test
    public void empty_string_returns_array_with_just_one_zero() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("0"));
    }

    @Test
    public void string_containing_just_one_number_returns_array_with_the_number() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("1"));
    }

    @Test
    public void string_containing_just_one_decimal_number_returns_array_with_the_number() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1.2");

        assertThat(output.length, equalTo(1));
        assertThat(output[0], equalTo("1.2"));
    }

    @Test
    public void string_containing_two_numbers_returns_array_with_two_numbers() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1,2");

        assertThat(output.length, equalTo(2));
        assertThat(output[0], equalTo("1"));
        assertThat(output[1], equalTo("2"));
    }

    @Test
    public void string_containing_two_decimal_numbers_returns_array_with_two_numbers() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1.1,2.2");

        assertThat(output.length, equalTo(2));
        assertThat(output[0], equalTo("1.1"));
        assertThat(output[1], equalTo("2.2"));
    }

    @Test
    public void string_can_contain_many_numbers() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1.1,2.2,3,4,5.5");

        assertThat(output.length, equalTo(5));
        assertThat(output[0], equalTo("1.1"));
        assertThat(output[1], equalTo("2.2"));
        assertThat(output[2], equalTo("3"));
        assertThat(output[3], equalTo("4"));
        assertThat(output[4], equalTo("5.5"));
    }

    @Test
    public void new_line_can_also_be_a_valid_delimiter() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1.1\n2.2\n3\n4\n5.5");

        assertThat(output.length, equalTo(5));
        assertThat(output[0], equalTo("1.1"));
        assertThat(output[1], equalTo("2.2"));
        assertThat(output[2], equalTo("3"));
        assertThat(output[3], equalTo("4"));
        assertThat(output[4], equalTo("5.5"));
    }

    @Test
    public void string_can_have_different_delimiters_mixed() throws NumberExpectedException, EndOfFileException {
        String[] output = parser.parse("1.1\n2.2,3,4\n5.5");

        assertThat(output.length, equalTo(5));
        assertThat(output[0], equalTo("1.1"));
        assertThat(output[1], equalTo("2.2"));
        assertThat(output[2], equalTo("3"));
        assertThat(output[3], equalTo("4"));
        assertThat(output[4], equalTo("5.5"));
    }

    @Test
    public void number_exception_expected_when_no_number_between_delimiters() throws EndOfFileException {
        try {
            parser.parse("175.2,\n35");
            fail("NumberExpectedException was expected");
        } catch(NumberExpectedException expected) {
            assertTrue(true);
        }
    }

    @Test
    public void when_string_misses_number_in_last_position_EOF_exception_expected() throws NumberExpectedException {
        try {
            parser.parse("1,3,");
            fail("EndOfFileException was expected");
        } catch (EndOfFileException expected) {
            assertTrue(true);
        }

    }

}
