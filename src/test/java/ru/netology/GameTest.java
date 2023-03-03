package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void roundIfFirstPlayerWins() {

        Game game = new Game();

        game.register("father Brown", 65);
        game.register("Flambeau", 37);

        assertEquals(1, game.round("father Brown", "Flambeau"));

    }

    @Test
    public void roundIfSecondPLayerWins() {

        Game game = new Game();
        game.register("Flambeau", 37);
        game.register("father Brown", 65);

        assertEquals(2, game.round("Flambeau", "father Brown"));

    }

    @Test
    public void roundIfDraw() {

        Game game = new Game();

        game.register("Flambeau", 37);
        game.register("Sid", 37);

        assertEquals(0, game.round("Flambeau", "Sid"));

    }

    @Test
    public void roundIfOneNotRegistered() {

        Game game = new Game();

        game.register("Flambeau", 37);

        assertThrows(NotRegisteredException.class, () -> game.round("Mrs McCarthy", "Flambeau"));
    }

    @Test
    public void roundIfSecondNotRegistered() {

        Game game = new Game();
        game.register("Sid", 37);

        assertThrows(NotRegisteredException.class, () -> game.round("Sid", "Inspector Mallory"));
    }
}
