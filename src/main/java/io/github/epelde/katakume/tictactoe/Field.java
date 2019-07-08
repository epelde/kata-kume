package io.github.epelde.katakume.tictactoe;

import java.util.Objects;

public class Field {

    private int x;

    private int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return x == field.x && y == field.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
