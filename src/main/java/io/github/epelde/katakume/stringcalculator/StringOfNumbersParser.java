package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringOfNumbersParser {

    private String delimiter;

    StringOfNumbersParser(String... delimiter) {
        this.delimiter = Arrays.stream(delimiter).reduce((sep1, sep2) -> sep1 + "|" + sep2).orElse(",");
    }

    public BigDecimal[] parse(String input) {

        if (input.isEmpty()) {
            return new BigDecimal[]{ new BigDecimal("0") };
        }

        return Arrays.stream(input.split(delimiter))
                .map(number -> new BigDecimal(number))
                .toArray(BigDecimal[]::new);
    }

}
