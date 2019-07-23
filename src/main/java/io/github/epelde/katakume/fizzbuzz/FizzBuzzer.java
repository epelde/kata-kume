package io.github.epelde.katakume.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzer {

    public static void main(String[] args) {
        FizzBuzzer fizzBuzzer = new FizzBuzzer();
        IntStream.range(1, 101)
                .boxed()
                .collect(Collectors.toList())
                .forEach(number -> print(fizzBuzzer.echo(number)));
    }

    private static void print(String text) {
        System.out.println(text);
    }

    public String echo(int number) {
        if (isBothMultipleOfThreeAndFive(number)) {
            return "FizzBuzz";
        }

        if (isMultipleOfThree(number)) {
            return "Fizz";
        }

        if (isMultipleOfFive(number)) {
            return "Buzz";
        }

        return Integer.toString(number);
    }

    private boolean isMultipleOfThree(int number) {
        return isNumberMultipleOf(number, 3);
    }

    private boolean isMultipleOfFive(int number) {
        return isNumberMultipleOf(number, 5);
    }

    private boolean isBothMultipleOfThreeAndFive(int number) {
        return isMultipleOfThree(number) && isMultipleOfFive(number);
    }

    private boolean isNumberMultipleOf(int number, int baseNumber) {
        return number % baseNumber == 0;
    }
}
