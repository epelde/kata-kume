package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringCalculatorTests {

    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void empty_string_input_sums_zero() {
        assertThat(calculator.add(""), equalTo("0"));
    }

    @Test
    public void one_number_input_sums_that_number() {
        assertThat(calculator.add("1"), equalTo("1"));
        assertThat(calculator.add("2"), equalTo("2"));
        assertThat(calculator.add("3.4"), equalTo("3.4"));
    }

    @Test
    public void two_numbers_input_sums_them() {
        assertThat(calculator.add("1,3"), equalTo("4"));
        assertThat(calculator.add("1.1,1.2"), equalTo("2.3"));
        assertThat(calculator.add("11,12"), equalTo("23"));
        assertThat(calculator.add("112,18"), equalTo("130"));
    }

    @Test
    public void many_numbers_input_sums_all_of_them() {
        assertThat(calculator.add("1,2,3,4,5"), equalTo("15"));
        assertThat(calculator.add("1.1,1.2,1.3,1.4,1.5"), equalTo("6.5"));
        assertThat(calculator.add("111,112,113,114,215"), equalTo("665"));
    }

    @Test
    public void add_method_also_handles_newline_as_separator() {
        assertThat(calculator.add("1\n2,3"), equalTo("6"));
        assertThat(calculator.add("1,2\n3,4\n5"), equalTo("15"));
        assertThat(calculator.add("1.1,1.2,1.3\n1.4,1.5"), equalTo("6.5"));
        assertThat(calculator.add("111,112,113,114\n215"), equalTo("665"));
    }

    @Test
    public void a_number_is_always_expected_between_two_separators() {
        assertThat(calculator.add("175.2,\n35"), equalTo("Number expected but '\n' found at position 6."));
        assertThat(calculator.add("175.2,,35"), equalTo("Number expected but ',' found at position 6."));
        assertThat(calculator.add("17,5.2,4,3\n\n5"), equalTo("Number expected but '\n' found at position 11."));
    }

    @Test
    public void input_can_not_end_in_a_separator() {
        assertThat(calculator.add("1,2,"), equalTo("Number expected but EOF found."));
        assertThat(calculator.add("1,2\n3,4\n"), equalTo("Number expected but EOF found."));
    }

}
