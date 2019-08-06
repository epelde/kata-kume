package io.github.epelde.katakume.stringcalculator;

public class StringNumberParser {

    private final String pattern = ",|\n";

    public String[] parse(String text) {
        if (text.isEmpty()) {
            return new String[] { "0" };
        }
        return text.split(pattern);
    }
}
