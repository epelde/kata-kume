package io.github.epelde.katakume.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class FizzBuzzerTests {

    private FizzBuzzer fizzBuzzer;

    @BeforeEach
    public void setUp() {
        fizzBuzzer = new FizzBuzzer();
    }

    @Test
    public void echoNumbers() {
        assertThat("1", equalTo(fizzBuzzer.echo(1)));
        assertThat("2", equalTo(fizzBuzzer.echo(2)));
        assertThat("4", equalTo(fizzBuzzer.echo(4)));
        assertThat("7", equalTo(fizzBuzzer.echo(7)));
        assertThat("8", equalTo(fizzBuzzer.echo(8)));
        assertThat("11", equalTo(fizzBuzzer.echo(11)));
        assertThat("13", equalTo(fizzBuzzer.echo(13)));
        assertThat("19", equalTo(fizzBuzzer.echo(19)));
    }

    @Test
    public void echoFizzWhenNumberIsMultipleOfThree() {
        assertThat("Fizz", equalTo(fizzBuzzer.echo(3)));
        assertThat("Fizz", equalTo(fizzBuzzer.echo(6)));
        assertThat("Fizz", equalTo(fizzBuzzer.echo(9)));
        assertThat("Fizz", equalTo(fizzBuzzer.echo(99)));
    }

    @Test
    public void echoBuzzWhenNumberIsMultipleOfFive() {
        assertThat("Buzz", equalTo(fizzBuzzer.echo(5)));
        assertThat("Buzz", equalTo(fizzBuzzer.echo(10)));
        assertThat("Buzz", equalTo(fizzBuzzer.echo(100)));
    }

    @Test
    public void echoFizzBuzzWhenNumberIsMultipleOf3And5() {
        assertThat("FizzBuzz", equalTo(fizzBuzzer.echo(15)));
        assertThat("FizzBuzz", equalTo(fizzBuzzer.echo(45)));
        assertThat("FizzBuzz", equalTo(fizzBuzzer.echo(90)));
    }

}
