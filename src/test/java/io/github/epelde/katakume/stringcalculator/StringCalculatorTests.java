package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringCalculatorTests {

    private StringCalculator calculator;

    private StringOfNumbersParser parser;

    @BeforeEach
    public void setUp() {
        parser = mock(StringOfNumbersParser.class);
        calculator = new StringCalculator(parser);
    }

    @Test
    public void an_empty_string_returns_zero() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("")).thenReturn(new String[] { "0" });

        assertThat(calculator.add(""), equalTo("0"));
    }

    @Test
    public void a_string_containing_just_one_number_returns_the_number() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1")).thenReturn(new String[] { "1" });

        assertThat(calculator.add("1"), equalTo("1"));
    }

    @Test
    public void a_string_containing_just_one_decimal_number_returns_the_number() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("3.4")).thenReturn(new String[] { "3.4" });

        assertThat(calculator.add("3.4"), equalTo("3.4"));
    }

    @Test
    public void a_string_containing_two_numbers_returns_both_numbers_sum() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1,3")).thenReturn(new String[] { "1", "3" });

        assertThat(calculator.add("1,3"), equalTo("4"));
    }

    @Test
    public void a_string_containing_two_decimal_numbers_returns_both_numbers_sum() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1.1,1.2")).thenReturn(new String[] { "1.1", "1.2" });

        assertThat(calculator.add("1.1,1.2"), equalTo("2.3"));
    }

    @Test
    public void a_string_containing_many_numbers_returns_the_sum() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1.1,1.2,1.3,1.4,1.5")).thenReturn(new String[] { "1.1", "1.2", "1.3", "1.4", "1.5" });

        assertThat(calculator.add("1.1,1.2,1.3,1.4,1.5"), equalTo("6.5"));
    }

    @Test
    public void add_method_also_handles_newline_separator() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1\n2,3")).thenReturn(new String[] { "1", "2", "3" });

        assertThat(calculator.add("1\n2,3"), equalTo("6"));
    }

    @Test
    public void add_method_handles_integer_and_decimal_numbers() throws EndOfFileException, NumberExpectedException {
        when(parser.parse("1.2,4\n2.3")).thenReturn(new String[] { "1.2", "4", "2.3" });

        assertThat(calculator.add("1.2,4\n2.3"), equalTo("7.5"));
    }

    @Test
    public void a_number_is_always_expected_between_two_separators() throws EndOfFileException, NumberExpectedException {
        when(parser.parse(any())).thenThrow(new NumberExpectedException());

        assertThat(calculator.add("175.2,\n35"), equalTo("Number expected but '\n' found at position 6."));
    }

    @Test
    public void the_number_can_not_end_in_a_separator() throws EndOfFileException, NumberExpectedException {
        when(parser.parse(any())).thenThrow(new EndOfFileException());

        assertThat(calculator.add("1,3,"), equalTo("Number expected but EOF found."));
    }

}
