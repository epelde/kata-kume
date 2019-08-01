package io.github.epelde.katakume.stringcalculator;

public class InputNumberParser {

    public String[] parse(String input) {
        if (!input.isEmpty()) {
            return new String[] { input };
        }
        return new String[] { "0" };
    }

}
