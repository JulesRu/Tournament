package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> playersList = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : playersList) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(
                    "К сожалению, соревнование не состоится, так как игрок " + playerName1 + " не зарегистрирован."
            );
        }

        if (player2 == null) {
            throw new NotRegisteredException(
                    "К сожалению, соревнование не состоится, так как игрок " + playerName2 + " не зарегистрирован."
            );
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player2.getStrength() > player1.getStrength()) {
            return 2;
        }
        return 0;
    }
}
