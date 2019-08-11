package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringCalculator {

    private final static char COMMA_SEPARATOR = ',';

    private final static char NEW_LINE_SEPARATOR = '\n';

    public String add(String input) {
        int inputStringLength = input.length();

        if (inputStringLength > 0 && isSeparatorCharacter(input.charAt(inputStringLength - 1))) {
            return "Number expected but EOF found.";
        }

        List<BigDecimal> numbers = new ArrayList<>();
        int sepPosition = 0;

        for (int index = 0; index < inputStringLength; index++) {
            try {
                if (isSeparatorCharacter(input.charAt(index))) {
                    numbers.add(convertToNumber(input.substring(sepPosition, index)));
                    sepPosition = index + 1;
                }

                if (index == inputStringLength - 1) {
                    numbers.add(convertToNumber(input.substring(sepPosition)));
                }
            } catch(NumberFormatException e) {
                return "Number expected but '" + input.charAt(index) + "' found at position " + index + ".";
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
