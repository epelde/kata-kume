package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
        String[] anagram = builder.build("ab");
        assertEquals(2, anagram.length);
        assertTrue(Arrays.asList(anagram).contains("ab"));
        assertTrue(Arrays.asList(anagram).contains("ba"));
    }

}
