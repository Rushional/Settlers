package game_model.hex;

import game_model.Player;
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

    public Color getColor() {
        return player.getColor();
    }
}
