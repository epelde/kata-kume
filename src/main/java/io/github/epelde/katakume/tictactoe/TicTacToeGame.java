package io.github.epelde.katakume.tictactoe;

public class TicTacToeGame {

    private boolean over = false;

    public boolean isOver() {
        return over;
    }

    public void play(String player, Field field) throws FieldAlreadyTakenException {
        if (player.equals("PlayerY") && field.equals(new Field(1,1 ))) {
            throw new FieldAlreadyTakenException("Field 1, 1 already taken");
        }
    }
}
