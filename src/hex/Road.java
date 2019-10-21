package hex;

import interactions.Player;

import java.awt.Color;

public class Road {
    private Player player;

    public Road(Player player) {
        this.player = player;
    }

    public Color getColor() {
        return player.getColor();
    }

    public Player getPlayer() {
        return player;
    }
}
