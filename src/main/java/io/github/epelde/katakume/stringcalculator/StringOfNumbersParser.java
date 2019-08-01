package io.github.epelde.katakume.stringcalculator;

public class StringOfNumbersParser {

    private String delimiter;

    StringOfNumbersParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parse(String input) {
        if (input.isEmpty()) {
            return new String[] { "0" };
        }
        return input.split(",");
    }

}
