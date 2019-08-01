package io.github.epelde.katakume.stringcalculator;

public class StringOfNumbersParser {

    public String[] parse(String input) {
        if (input.isEmpty()) {
            return new String[] { "0" };
        }
        return input.split(",");
    }

}
