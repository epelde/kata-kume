package io.github.epelde.katakume.anagrams;

public class AnagramBuilder {

    public String[] build(String input) {
        if (input.length() == 1) {
            return new String[] { input };
        } else {
            return new String[] { input, input.substring(1, 2) + input.substring(0, 1)};
        }
    }
}
