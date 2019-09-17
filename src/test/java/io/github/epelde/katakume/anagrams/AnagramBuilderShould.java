package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AnagramBuilderShould {

    private AnagramBuilder builder;

    @BeforeEach
    void setup() {
        builder = new AnagramBuilder();
    }

    @Test
    void returns_anagram_combination_for_1_char() {
        assertArrayEquals(new String[] { "b" }, builder.build("b"));
        assertArrayEquals(new String[] { "a" }, builder.build("a"));
    }

    @Test
    void returns_anagram_combination_for_2_chars() {
        assertArrayEquals(new String[] { "ab", "ba" }, builder.build("ab"));
        assertArrayEquals(new String[] { "ac", "ca" }, builder.build("ac"));
    }

}
