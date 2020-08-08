package views.services;

import models.Player;

public class ShowPlayerResourcesAmounts {
    public static void call(Player player) {
        System.out.println(player.getColor() + " player: " + player.getResources().getTotalAmount() + " ресурсов");
    }
}
