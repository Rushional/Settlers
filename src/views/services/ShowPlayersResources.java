package views.services;

import models.players.Player;

public class ShowPlayersResources {
    public static void call(Player player) {
        System.out.println(player.getColor() + " player: " + player.getResources().toString());
    }
}
