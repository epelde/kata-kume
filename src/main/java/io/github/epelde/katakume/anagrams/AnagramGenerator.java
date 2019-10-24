package io.github.epelde.katakume.anagrams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AnagramGenerator {

    public Collection<String> execute(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        if (input.length() == 1) {
            return Arrays.asList(new String[] { input });
        }

        if (input.length() == 2) {
            return Arrays.asList(new String[] {
                    String.valueOf(input.charAt(0)).concat(String.valueOf(input.charAt(1))),
                    String.valueOf(input.charAt(1)).concat(String.valueOf(input.charAt(0)))
            });
        }

        return Arrays.asList(new String[] {
                String.valueOf(input.charAt(0)).concat(String.valueOf(input.charAt(1))).concat(String.valueOf(input.charAt(2))),
                String.valueOf(input.charAt(0)).concat(String.valueOf(input.charAt(2))).concat(String.valueOf(input.charAt(1))),
                String.valueOf(input.charAt(1)).concat(String.valueOf(input.charAt(0))).concat(String.valueOf(input.charAt(2))),
                String.valueOf(input.charAt(1)).concat(String.valueOf(input.charAt(2))).concat(String.valueOf(input.charAt(0))),
                String.valueOf(input.charAt(2)).concat(String.valueOf(input.charAt(0))).concat(String.valueOf(input.charAt(1))),
                String.valueOf(input.charAt(2)).concat(String.valueOf(input.charAt(1))).concat(String.valueOf(input.charAt(0)))
        });

    }
}
