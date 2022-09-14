package controllers.services;

import exceptions.PointNotInHex;
import models.hex.Hex;
import models.players.Player;
import views.graphics.MapView;
import views.inputs.listeners.MapInputRequester;

public class MoveRobber {
    public static void call(Player player, MapInputRequester inputRequester, MapView mapView) {
        System.out.println("Ну что, " + player.getColor() + " player, куда двигаем разбойников?");
        System.out.println("Что-что? Тебя ПЛОХО СЛЫШНО!!!");
        System.out.println("Что?.. Оставить на месте?");
        System.out.println("Хорошо!");
        try {
            Hex robberHex = inputRequester.getRobberHex(mapView);
            System.out.println(player.getColor() + " player, ты ткнул в " + robberHex + ", что бы это ни значило...");
            System.out.println("Поздравляю тебя?..");
            System.out.println("............");
        } catch (PointNotInHex pointNotInHexException) {
            System.out.println("Хаха, ну куда кликаешь?");
            System.out.println("КУДА ТЫ КЛИКАЕШЬ? НУ ВОТ КУДА? ПО ЛБУ СЕБЕ ТЫКНИ!");
        }
    }
}
