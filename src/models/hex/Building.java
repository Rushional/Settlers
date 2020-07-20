package models.hex;

import models.Player;
import models.PlayerColor;

import java.awt.Color;

public abstract class Building {
    private Player player;

    Building(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isSettlement() {
        return (getClass() == Settlement.class);
    }

    public boolean isCity() {
        return (getClass() == City.class);
    }

    public PlayerColor getColor() {
        return player.getColor();
    }
}
