package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public String add(String input) {

        if (input.isEmpty()) {
            return "0";
        }

        if (!input.contains(",")) {
            return input;
        }

        List<BigDecimal> numbers = new ArrayList<>();
        int sepPosition = 0;

        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            if (c == ',') {
                numbers.add(convertToNumber(input.substring(sepPosition, index)));
                sepPosition = index;
            }

            if (index == input.length() - 1) {
                numbers.add(convertToNumber(input.substring(sepPosition + 1)));
            }
        }

        return numbers.stream().reduce(new BigDecimal("0"), (number1, number2) -> number1.add(number2)).toString();
    }

    private BigDecimal convertToNumber(String number) {
        return new BigDecimal(number);
    }
}
