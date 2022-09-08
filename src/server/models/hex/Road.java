package server.models.hex;

import server.models.players.Player;
import server.models.players.PlayerColor;

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
