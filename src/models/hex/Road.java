package models.hex;

import models.Player;
import models.PlayerColor;

import java.awt.Color;

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
