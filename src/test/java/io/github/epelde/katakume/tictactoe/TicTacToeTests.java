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
        game.play(new Field(1, 1));
        game.play(new Field(1, 2));
    }

    @Test
    public void A_player_can_not_take_an_already_taken_field() throws FieldAlreadyTakenException {
        TicTacToeGame game = new TicTacToeGame();
        game.play(new Field(1,1));
        try {
            game.play(new Field(1,1));
            fail("FieldAlreadyTakenException was expected.");
        } catch(FieldAlreadyTakenException expected) {
            assertTrue(true);
        }
    }

    @Test
    public void A_game_has_a_nine_fields_grid() throws FieldAlreadyTakenException {
        TicTacToeGame game = new TicTacToeGame();
        game.play(new Field(1,1));
        game.play(new Field(1,2));
        game.play(new Field(1,3));
        game.play(new Field(2,1));
        game.play(new Field(2,2));
        game.play(new Field(2,3));
        game.play(new Field(3,1));
        game.play(new Field(3,2));
        game.play(new Field(3,3));
        assertTrue(true);
    }
}
