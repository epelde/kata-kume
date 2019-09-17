package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramBuilderShould {

    @Test
    void returns_anagram_combination_for_1_char() {
        AnagramBuilder anagramB = new AnagramBuilder();
        Assertions.assertArrayEquals(new String[] {"b"}, anagramB.convert("b"));
    }
}
