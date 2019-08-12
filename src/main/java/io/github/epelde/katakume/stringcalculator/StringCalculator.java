package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringCalculator {

    private final static char COMMA_SEPARATOR = ',';

    private final static char NEW_LINE_SEPARATOR = '\n';

    public String add(String input) {

        if (input.isEmpty()) {
            return "0";
        }

        if (hasSeparatorInLastPosition(input)) {
            return "Number expected but EOF found.";
        }

        int inputLength = input.length();
        int lastSeparatorPosition = 0;
        List<BigDecimal> numbers = new ArrayList<>();

        for (int index = 0; index < inputLength; index++) {
            char currentCharacter = input.charAt(index);

            try {
                if (isSeparatorCharacter(currentCharacter)) {
                    numbers.add(
                            convertToNumber(
                                    chunkStringNumber(input, lastSeparatorPosition, index)
                            )
                    );
                    lastSeparatorPosition = index + 1;
                }

                if (index == inputLength - 1) {
                    numbers.add(
                            convertToNumber(
                                    chunkStringNumber(input, lastSeparatorPosition, inputLength)
                            )
                    );
                }
            } catch (NumberFormatException e) {
                return "Number expected but '" + currentCharacter + "' found at position " + index + ".";
            }
        }

        return sumNumbers(numbers.stream()).toString();
    }

    private String chunkStringNumber(String input, int beginIndex, int endIndex) {
        return input.substring(beginIndex, endIndex);
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

    private boolean hasSeparatorInLastPosition(String input) {
        return isSeparatorCharacter(input.charAt(input.length() - 1));
    }
}
