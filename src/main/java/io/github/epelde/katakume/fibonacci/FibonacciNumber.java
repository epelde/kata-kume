package io.github.epelde.katakume.fibonacci;

public class FibonacciNumber {

    public int generate(int position) throws InvalidPositionNumberException {
        if (position <= 0) throw new InvalidPositionNumberException();
        if (position <= 2) return position - 1;
        return generate(position - 1) + generate(position - 2);
    }

}
