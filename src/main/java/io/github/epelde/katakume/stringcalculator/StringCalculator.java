package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    private final String SEPARATOR = ",";

    private final String NEWLINE_SEPARATOR = "\n";

    public String add(String number) {

        if (number.isEmpty()) {
            return "0";
        }

        if (homogenizeSeparators(number).endsWith(SEPARATOR)) {
            return "Number expected but EOF found.";
        }

        try {
            return getStreamOfStringNumbers(number)
                    .reduce("0", (number1, number2) ->
                            sumTwoStringNumbers(number1, number2));
        } catch (NumberFormatException e) {
            return getNumberExpectedMessage(number);
        }
    }

    private Stream<String> getStreamOfStringNumbers(String number) {
        return Arrays.stream(homogenizeSeparators(number).split(SEPARATOR));
    }

    private String homogenizeSeparators(String number) {
        return number.replace(NEWLINE_SEPARATOR, SEPARATOR);
    }

    private String sumTwoStringNumbers(String number1, String number2) {
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
