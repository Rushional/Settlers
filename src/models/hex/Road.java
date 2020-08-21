package models.hex;

import models.players.Player;
import models.players.PlayerColor;

public class Road {
    private Player player;

    Road(Player player) {
        this.player = player;
    }

    public PlayerColor getColor() {
        return player.getColor();
    }

    public Player getPlayer() {
        return player;
    }
}
