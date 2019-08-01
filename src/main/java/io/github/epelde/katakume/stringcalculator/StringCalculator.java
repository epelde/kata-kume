package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {

    private StringOfNumbersParser parser;

    StringCalculator(StringOfNumbersParser parser) {
        this.parser = parser;
    }

    private final String SEPARATOR = ",";

    private final String NEWLINE_SEPARATOR = "\n";

    public String add(String number) {

        if (homogenizeSeparators(number).endsWith(SEPARATOR)) {
            return "Number expected but EOF found.";
        }

        try {
            return Arrays.stream(this.parser.parse(number))
                    .reduce("0", (number1, number2) ->
                        sum(number1, number2));
        } catch (NumberExpectedException e) {
            return getNumberExpectedMessage(number);
        }
    }

    private String homogenizeSeparators(String number) {
        return number.replace(NEWLINE_SEPARATOR, SEPARATOR);
    }

    private String sum(String number1, String number2) {
        return new BigDecimal(number1).add(new BigDecimal(number2)).toString();
    }

    private String getNumberExpectedMessage(String number) {
        int position = homogenizeSeparators(number)
                .indexOf(SEPARATOR + SEPARATOR) + 1;
        char character = number.charAt(position);
        return "Number expected but '" + character +
                "' found at position " + position + ".";
    }
}
