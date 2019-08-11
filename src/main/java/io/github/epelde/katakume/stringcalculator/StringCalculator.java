package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {

    private StringOfNumbersParser parser;

    StringCalculator(StringOfNumbersParser parser) {
        this.parser = parser;
    }

    public String add(String input) {
        try {
            return Arrays.stream(this.parser.parse(input))
                    .reduce("0", (number1, number2) ->
                        sum(number1, number2));
        } catch (NumberExpectedException e) {
            return "Number expected but '\n' found at position 6.";
        } catch (EndOfFileException e) {
            return "Number expected but EOF found.";
        }
    }

    private String sum(String number1, String number2) {
        return new BigDecimal(number1).add(new BigDecimal(number2)).toString();
    }

}
