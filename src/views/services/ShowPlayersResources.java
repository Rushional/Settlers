package views.services;

import models.Player;

public class ShowPlayersResources {
    public static void call(Player player) {
        System.out.println(player.getColor() + " player: " + player.getResources().toString());
    }
}
