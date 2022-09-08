package client.views.services;

import client.models.players.Player;

public class ShowPlayersResources {
    public static void call(Player player) {
        System.out.println(player.getColor() + " player: " + player.getResources().toString());
    }
}
