package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringNumberParser {

    private final String pattern = ",|\n";

    public String[] parse(String text) throws NumberExpectedException {

        if (text.isEmpty()) {
            return new String[]{"0"};
        }

        try {
            return Arrays.stream(text.split(pattern))
                    .map(numberString -> new BigDecimal(numberString))
                    .map(number -> number.toString())
                    .toArray(String[]::new);
        } catch (NumberFormatException e) {
            throw new NumberExpectedException();
        }
    }
}
