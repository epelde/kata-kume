package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;

public class StringCalculator {

    public String add(String number) {
        String[] numbers = number.split(",");
        if (numbers.length == 1) {
            return numbers[0].equals("") ? "0" : numbers[0];
        }
        return new BigDecimal(numbers[0]).add(new BigDecimal(numbers[1])).toString();
    }
}
