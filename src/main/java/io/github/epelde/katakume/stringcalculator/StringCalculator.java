package io.github.epelde.katakume.stringcalculator;

public class StringCalculator {

    public String add(String number) {
        String[] numbers = number.split(",");
        if (numbers.length == 1) {
            return numbers[0].equals("") ? "0" : numbers[0];
        }
        return String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
    }
}
