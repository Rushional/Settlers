package models;

import java.awt.*;

public class Players {
    private Player redPlayer, bluePlayer, greenPlayer, violetPlayer;
    private Player[] players = new Player[4];
    private short currentPlayer;

    Players(boolean isRedHuman, boolean isBlueHuman, boolean isGreenHuman, boolean isVioletHuman) {
        redPlayer = new Player(new Color(249, 0, 8), isRedHuman);
        bluePlayer = new Player(new Color(45, 65, 139), isBlueHuman);
        greenPlayer = new Player(new Color(0, 180, 0), isGreenHuman);
        violetPlayer = new Player(new Color(145, 90, 167), isVioletHuman);
        players[0] = redPlayer;
        players[1] = bluePlayer;
        players[2] = greenPlayer;
        players[3] = violetPlayer;
        currentPlayer = 0;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public Player getPlayerIndex(int index) {
        return players[index];
    }

    //will be changed to allow for 3 players
    public boolean currentIsLast() {
        return currentPlayer == 3;
    }

    public boolean currentIsFirst() {
        return currentPlayer == 0;
    }

    public Player nextPlayer() {
        if (currentPlayer == 3) currentPlayer = 0;
        else currentPlayer++;
        return players[currentPlayer];
    }

    public Player previousPlayer() {
        if (currentPlayer == 0) currentPlayer = 3;
        else currentPlayer--;
        return players[currentPlayer];
    }

    public Player getRedPlayer() {
        return redPlayer;
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    public Player getGreenPlayer() {
        return greenPlayer;
    }

    public Player getVioletPlayer() {
        return violetPlayer;
    }
}
