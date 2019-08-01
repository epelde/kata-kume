package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringOfNumbersParser {

    private final String DEFAULT_DELIMITERS = ",|\n";

    public String[] parse(String input) throws NumberExpectedException, EndOfFileException {

        if (input.isEmpty()) {
            return new String[]{"0"};
        }

        if (input.endsWith(",") || input.endsWith("\n")) {
            throw new EndOfFileException();
        }

        try {
            return Arrays.stream(input.split(DEFAULT_DELIMITERS))
                    .map(number -> new BigDecimal(number).toString())
                    .toArray(String[]::new);
        } catch(NumberFormatException e) {
            throw new NumberExpectedException();
        }
    }

}
