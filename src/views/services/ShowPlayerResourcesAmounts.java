package views.services;

import models.players.Player;

public class ShowPlayerResourcesAmounts {
    public static void call(Player player) {
        System.out.println(player.getColor() + " player: " + player.getResources().getTotalAmount() + " ресурсов");
    }
}
