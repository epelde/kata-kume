package io.github.epelde.katakume.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegExpExploratoryTests {

    private StringParser parser;

    @BeforeEach
    public void setUp() {
        parser = new StringParser();
    }

    @Test
    public void dumb_test() {
        assertThat(parser.parse("").length, equalTo(1));
        assertThat(parser.parse("")[0], equalTo("0"));
    }

}
