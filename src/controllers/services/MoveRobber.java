package controllers.services;

import models.Player;

public class MoveRobber {
    public static void call(Player player) {
        System.out.println("Ну что, " + player.getColor() + " игрок, куда двигаем разбойников?");
        System.out.println("Что-что? Тебя ПЛОХО СЛЫШНО!!!");
        System.out.println("Что?.. Оставить на месте?");
        System.out.println("Хорошо!");
    }
}
