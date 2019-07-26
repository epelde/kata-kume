package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.Arrays;

public class StringCalculator {

    public String add(String number) {
        String[] numbers = number.split(",");
        if (numbers.length == 1) {
            return numbers[0].equals("") ? "0" : numbers[0];
        }

        return Arrays.stream(numbers).reduce("0", (number1, number2) ->
            new BigDecimal(number1).add(new BigDecimal(number2)).toString()
        );
    }
}
