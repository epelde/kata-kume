package io.github.epelde.katakume.stringcalculator;

public class StringNumberParser {

    public String[] parse(String text) {
        if (text.isEmpty()) {
            return new String[] { "0" };
        }
        return new String[] { text };
    }
}
