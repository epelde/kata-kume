package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    @Test
    public void A_game_is_not_over_when_started() {
        TicTacToeGame game = new TicTacToeGame();
        assertFalse(game.isOver());
    }

    @Test
    public void A_player_can_take_a_field_if_not_already_taken() throws FieldAlreadyTakenException {
        TicTacToeGame game = new TicTacToeGame();
        game.play("PlayerX", 1, 1);

        try {
            game.play("PlayerY", 1, 1);
            fail("FieldAlreadyTakenException was expected.");
        } catch(FieldAlreadyTakenException expected) {
            assertTrue(true);
        }
    }
}
