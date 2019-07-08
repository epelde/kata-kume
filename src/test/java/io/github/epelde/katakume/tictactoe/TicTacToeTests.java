package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicTacToeTests {

    @Test
    public void gameIsNotOverWhenStarted() {
        TicTacToeGame game = new TicTacToeGame();
        assertFalse(game.isOver());
    }
}
