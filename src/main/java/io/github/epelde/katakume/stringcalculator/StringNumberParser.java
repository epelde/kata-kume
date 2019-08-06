package io.github.epelde.katakume.stringcalculator;

import java.util.regex.PatternSyntaxException;

public class StringNumberParser {

    private final String pattern = ",|\n";

    public String[] parse(String text) throws NumberExpectedException {

        if (text.isEmpty()) {
            return new String[]{"0"};
        }

        try {
            return text.split(pattern);
        } catch (PatternSyntaxException e) {
            throw new NumberExpectedException();
        }
    }
}
