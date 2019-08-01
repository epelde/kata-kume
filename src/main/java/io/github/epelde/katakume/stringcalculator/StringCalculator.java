package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {

    private final String SEPARATOR = ",";

    private final String NEWLINE_SEPARATOR = "\n";

    public String add(String number) {

        if (number.isEmpty()) {
            return "0";
        }

        if (!number.contains(SEPARATOR)) {
            return number;
        }

        return Arrays.stream(number.replace(NEWLINE_SEPARATOR, SEPARATOR)
                .split(SEPARATOR))
                .reduce("", (number1, number2) ->
                        stringToNumber(number1).add(stringToNumber(number2)).toString()
                );
    }

    private BigDecimal stringToNumber(String number) {
        try {
            return new BigDecimal(number);
        } catch (NumberFormatException exception) {
            return new BigDecimal("0");
        }
    }
}
