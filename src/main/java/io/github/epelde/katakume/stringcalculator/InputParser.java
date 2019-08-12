package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private final static char COMMA_SEPARATOR = ',';

    private final static char NEW_LINE_SEPARATOR = '\n';

    public List<BigDecimal> parse(String input) throws EndOfFileException, NumberExpectedException {
        List<BigDecimal> numbers = new ArrayList<>();
        numbers.add(new BigDecimal("0"));

        if (input.isEmpty()) {
            return numbers;
        }

        if (hasSeparatorInLastPosition(input)) {
            throw new EndOfFileException("Number expected but EOF found.");
        }

        int inputLength = input.length();
        int lastSeparatorPosition = 0;

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
            } catch (NumberFormatException e) {
                throw new NumberExpectedException("Number expected but '" + currentCharacter +
                        "' found at position " + index + ".");
            }
        }

        numbers.add(
                convertToNumber(
                        chunkStringNumber(input, lastSeparatorPosition, inputLength)
                )
        );
        return numbers;
    }

    private String chunkStringNumber(String input, int beginIndex, int endIndex) {
        return input.substring(beginIndex, endIndex);
    }

    private BigDecimal convertToNumber(String number) {
        return new BigDecimal(number);
    }

    private boolean hasSeparatorInLastPosition(String input) {
        return input.length() > 0 && isSeparatorCharacter(input.charAt(input.length() - 1));
    }

    private boolean isSeparatorCharacter(char character) {
        return character == COMMA_SEPARATOR || character == NEW_LINE_SEPARATOR;
    }

}
