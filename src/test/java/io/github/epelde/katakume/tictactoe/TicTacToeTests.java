package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {

    private TicTacToeGame game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    public void A_game_is_not_over_when_started() {
        assertFalse(game.isOver());
    }

    @Test
    public void A_player_can_take_a_field_if_not_already_taken() throws FieldAlreadyTakenException {
        game.play(new Field(1, 1));
        game.play(new Field(1, 2));
    }

    @Test
    public void A_player_can_not_take_an_already_taken_field() throws FieldAlreadyTakenException {
        game.play(new Field(1,1));
        try {
            game.play(new Field(1,1));
            fail("FieldAlreadyTakenException was expected.");
        } catch(FieldAlreadyTakenException expected) {
            assertTrue(true);
        }
    }
}
