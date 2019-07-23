package io.github.epelde.katakume.fibonacci;

public class FibonacciNumber {

    public int generate(int position) {
        if (position == 1) return 0;
        if (position == 2) return 1;
        return generate(position - 1) + generate(position - 2);
    }

}
