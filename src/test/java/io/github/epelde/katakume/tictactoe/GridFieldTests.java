package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridFieldTests {

    @Test
    public void A_grid_field_is_initially_not_taken() {
        GridField field = new GridField();
        Assertions.assertFalse(field.isTaken());
    }

    @Test
    public void A_player_can_take_a_field_if_not_already_taken() throws FieldAlreadyTakenException {
        GridField field = new GridField();
        field.take(Player.PLAYER_X);
        Assertions.assertTrue(field.isTaken());
    }

    @Test
    public void A_player_can_not_take_a_field_if_already_taken() throws FieldAlreadyTakenException {
        GridField field = new GridField();
        field.take(Player.PLAYER_X);
        try {
            field.take(Player.PLAYER_O);
            Assertions.fail("A FieldAlreadyTakenException was expected");
        } catch(FieldAlreadyTakenException expected) {
            Assertions.assertTrue(true);
            Assertions.assertEquals("Field already taken by PLAYER_X", expected.getMessage());
        }

    }

}
