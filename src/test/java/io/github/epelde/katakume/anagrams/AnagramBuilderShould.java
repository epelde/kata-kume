package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AnagramBuilderShould {

    @Test
    void returns_anagram_combination_for_1_char() {
        AnagramBuilder builder = new AnagramBuilder();
        assertArrayEquals(new String[] { "b" }, builder.build("b"));
        assertArrayEquals(new String[] { "a" }, builder.build("a"));
    }

    @Test
    void returns_anagram_combination_for_2_chars() {
        AnagramBuilder builder = new AnagramBuilder();
        assertArrayEquals(new String[] { "ab", "ba" }, builder.build("ab"));
        assertArrayEquals(new String[] { "ac", "ca" }, builder.build("ac"));
    }

}
