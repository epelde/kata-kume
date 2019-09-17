package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AnagramBuilderShould {

    @Test
    void returns_anagram_combination_for_1_char() {
        AnagramBuilder anagramB = new AnagramBuilder();
        assertArrayEquals(new String[] { "b" }, anagramB.convert("b"));
        assertArrayEquals(new String[] { "a" }, anagramB.convert("a"));
    }

    @Test
    void returns_anagram_combination_for_2_chars() {
        AnagramBuilder anagramB = new AnagramBuilder();
        assertArrayEquals(new String[] { "ab", "ba" }, anagramB.convert("ab"));
        assertArrayEquals(new String[] { "ac", "ca" }, anagramB.convert("ac"));
    }

}
