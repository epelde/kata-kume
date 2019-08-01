package io.github.epelde.katakume.stringcalculator;

import java.util.Arrays;

public class StringOfNumbersParser {

    private String delimiter;

    StringOfNumbersParser(String... delimiter) {
        this.delimiter = Arrays.stream(delimiter).reduce((sep1, sep2) -> sep1 + "|" + sep2).orElse(",");
    }

    public String[] parse(String input) {
        if (input.isEmpty()) {
            return new String[] { "0" };
        }
        return input.split(delimiter);
    }

}
