package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringOfNumbersParser {

    private final String DEFAULT_DELIMITER = ",|\n";

    public BigDecimal[] parse(String input) {

        if (input.isEmpty()) {
            return new BigDecimal[]{ new BigDecimal("0") };
        }

        return Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(number -> new BigDecimal(number))
                .toArray(BigDecimal[]::new);
    }

}
