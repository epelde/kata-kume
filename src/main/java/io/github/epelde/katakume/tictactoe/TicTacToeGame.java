package io.github.epelde.katakume.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private boolean over = false;

    private List<Field> fields;

    public TicTacToeGame() {
        fields = new ArrayList<>(9);
    }

    public boolean isOver() {
        return this.fields.size() >= 9;
    }

    public void play(Field field) throws FieldAlreadyTakenException {
        if (!isOver() && fields.contains(field)) {
            throw new FieldAlreadyTakenException(field.toString() + "is already taken");
        }
        fields.add(field);
    }
}
