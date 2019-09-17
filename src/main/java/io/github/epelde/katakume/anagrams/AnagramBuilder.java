package io.github.epelde.katakume.anagrams;

public class AnagramBuilder {

    public String[] build(String anagram) {
        if (anagram.length() == 1) {
            return new String[] { anagram };
        } else {
            return new String[] { anagram, anagram.substring(1, 2) + anagram.substring(0, 1)};
        }
    }
}
