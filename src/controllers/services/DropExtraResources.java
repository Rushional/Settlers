package controllers.services;

import models.Player;

public class DropExtraResources {
    public static void call(Player player) {
        System.out.println("FBI! OPEN UP!");
        System.out.println(player.getColor() + " игрок арестован и приговаривается к вечной лекции по матану.");
    }
}
