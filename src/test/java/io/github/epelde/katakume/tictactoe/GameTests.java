package io.github.epelde.katakume.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    @Test
    public void There_are_two_players_in_the_game() {
        Assertions.assertEquals(2, Player.values().length);
    }

    @Test
    public void A_game_is_not_over_when_it_starts() {
        Game game = new Game();
        Assertions.assertFalse(game.isOver());
    }

    @Test
    public void test() {
        Game game = new Game();
        game.take(1, 1);
    }
}
