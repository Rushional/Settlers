package models.hex;

import models.Player;

import java.awt.Color;

public class Road {
    private Player player;

    Road(Player player) {
        this.player = player;
    }

    public Color getColor() {
        return player.getColor();
    }

    public Player getPlayer() {
        return player;
    }
}
