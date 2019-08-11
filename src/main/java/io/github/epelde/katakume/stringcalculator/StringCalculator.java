package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringCalculator {

    private final static char COMMA_SEPARATOR = ',';

    private final static char NEW_LINE_SEPARATOR = '\n';

    public String add(String input) {

        List<BigDecimal> numbers = new ArrayList<>();
        int sepPosition = 0;

        for (int index = 0; index < input.length(); index++) {
            if (isSeparatorCharacter(input.charAt(index))) {
                numbers.add(convertToNumber(input.substring(sepPosition, index)));
                sepPosition = index + 1;
            }

            if (index == input.length() - 1) {
                numbers.add(convertToNumber(input.substring(sepPosition)));
            }
        }

        return sumNumbers(numbers.stream()).toString();
    }

    private BigDecimal convertToNumber(String number) {
        return new BigDecimal(number);
    }

    private boolean isSeparatorCharacter(char character) {
        return character == COMMA_SEPARATOR || character == NEW_LINE_SEPARATOR;
    }

    private BigDecimal sumNumbers(Stream<BigDecimal> numbers) {
        return numbers.reduce(new BigDecimal("0"), (number1, number2) -> number1.add(number2));
    }
}
