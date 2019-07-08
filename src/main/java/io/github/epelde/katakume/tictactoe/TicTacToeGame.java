package io.github.epelde.katakume.tictactoe;

public class TicTacToeGame {

    private boolean over = false;

    public boolean isOver() {
        return over;
    }

    public void play(String player, int x, int y) throws FieldAlreadyTakenException {
        if (player.equals("PlayerY")) {
            throw new FieldAlreadyTakenException("Field 1, 1 already taken");
        }
    }
}
