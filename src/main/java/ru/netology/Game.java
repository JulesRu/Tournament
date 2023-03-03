package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Integer> playersList = new HashMap<>();

    public void register(String name, int strength) {
        playersList.put(name, strength);
    }

    public int round(String playerName1, String playerName2) {

        if (!playersList.containsKey(playerName1)) {
            throw new NotRegisteredException(
                    "К сожалению, соревнование не состоится, так как игрок " + playerName1 + " не зарегистрирован."
            );
        }

        if (!playersList.containsKey(playerName2)) {
            throw new NotRegisteredException(
                    "К сожалению, соревнование не состоится, так как игрок " + playerName2 + " не зарегистрирован."
            );
        }

        if (playersList.get(playerName1) > playersList.get(playerName2)) {
            return 1;
        } else if (playersList.get(playerName1) < playersList.get(playerName2)) {
            return 2;
        }
        return 0;
    }
}
