package io.github.epelde.katakume.stringcalculator;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class StringCalculator {


    private InputParser inputParser;

    public StringCalculator(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public String add(String input) {
        try {
            return sumNumbers(this.inputParser.parse(input).stream()).toString();
        } catch (NumberExpectedException | EndOfFileException e) {
            return e.getMessage();
        }
    }

    private BigDecimal sumNumbers(Stream<BigDecimal> numbers) {
        return numbers.reduce(new BigDecimal("0"), (number1, number2) -> number1.add(number2));
    }

}
