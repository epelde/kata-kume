package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void There_are_two_players_in_the_game() {
        Assertions.assertEquals(2, Player.values().length);
    }
}
