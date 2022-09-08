package client.models.hex;

import client.models.players.Player;
import client.models.players.PlayerColor;

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
