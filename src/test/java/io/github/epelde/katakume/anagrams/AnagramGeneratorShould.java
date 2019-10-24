package io.github.epelde.katakume.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramGeneratorShould {

    private AnagramGenerator anagramGenerator;

    @BeforeEach
    public void setUp() {
        anagramGenerator = new AnagramGenerator();
    }

    @Test
    public void generate_empty_collection_when_input_is_empty() {
        Collection<String> result = anagramGenerator.execute("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void generate_one_element_when_input_is_one_char() {
        Collection<String> result = anagramGenerator.execute("a");
        assertEquals(1, result.size());
        assertTrue(result.contains("a"));
    }

    @Test
    public void generate_simplest_anagram() {
        Collection<String> result = anagramGenerator.execute("ab");
        assertEquals(2, result.size());
        assertTrue(result.contains("ab"));
        assertTrue(result.contains("ba"));
    }

    @Test
    public void generate_anagram_for_three_char_input() {
        Collection<String> result = anagramGenerator.execute("abc");
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));

    }
}
