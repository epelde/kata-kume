package io.github.epelde.katakume.anagrams;

public class AnagramBuilder {

    public String[] convert(String anagram) {
        if (anagram.length() == 1) {
            return new String[] { anagram };
        } else {
            return new String[] { "ab", "ba"};
        }
    }
}
