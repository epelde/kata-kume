package io.github.epelde.katakume.anagrams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AnagramGenerator {

    public Collection<String> execute(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new String[] { input });
    }
}
