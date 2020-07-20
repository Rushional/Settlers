package models;

import java.awt.*;

public class Players {
    private Player redPlayer, bluePlayer, greenPlayer, purplePlayer;
    private Player[] players = new Player[4];
    private short currentPlayer;

    Players(boolean isRedHuman, boolean isBlueHuman, boolean isGreenHuman, boolean isPurpleHuman) {
        redPlayer = new Player(PlayerColor.Red, isRedHuman);
        bluePlayer = new Player(PlayerColor.Blue, isBlueHuman);
        greenPlayer = new Player(PlayerColor.Green, isGreenHuman);
        purplePlayer = new Player(PlayerColor.Purple, isPurpleHuman);
        players[0] = redPlayer;
        players[1] = bluePlayer;
        players[2] = greenPlayer;
        players[3] = purplePlayer;
        currentPlayer = 0;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public Player getPlayerIndex(int index) {
        return players[index];
    }

//    TODO: change to allow for 3 players
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

    public Player getPurplePlayer() {
        return purplePlayer;
    }
}
