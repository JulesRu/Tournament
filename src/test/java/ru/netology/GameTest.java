package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Player player1 = new Player(1, "Flambeau", 37);
    Player player2 = new Player(23, "father Brown", 65);
    Player player3 = new Player(4, "Sid", 37);

    @Test
    public void roundIfFirstPlayerWins() {

        Game game = new Game();

        game.register(player2);
        game.register(player3);

        assertEquals(1, game.round("father Brown", "Sid"));

    }

    @Test
    public void roundIfSecondPLayerWins() {

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        assertEquals(2, game.round("Flambeau", "father Brown"));

    }

    @Test
    public void roundIfDraw() {

        Game game = new Game();

        game.register(player1);
        game.register(player3);

        assertEquals(0, game.round("Flambeau", "Sid"));

    }

    @Test
    public void roundIfOneNotRegistered() {

        Game game = new Game();

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> game.round("Flambeau", "Mrs McCarthy"));
    }

    @Test
    public void roundIfSecondNotRegistered() {

        Game game = new Game();
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> game.round("Sid", "Inspector Mallory"));
    }
}
