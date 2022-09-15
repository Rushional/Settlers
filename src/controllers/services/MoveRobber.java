package controllers.services;

import exceptions.PointNotInHex;
import models.hex.Hex;
import models.map.MapHexes;
import models.players.Player;
import views.graphics.MapView;
import views.inputs.listeners.MapInputRequester;

public class MoveRobber {
    public static void call(Player player, MapInputRequester inputRequester, MapView mapView, MapHexes map) {
        System.out.println("Ну что, " + player.getColor() + " player, куда двигаем разбойника?");
        System.out.println("Что-что? Тебя ПЛОХО СЛЫШНО!!!");
        System.out.println("Что?.. Оставить на месте?");
        System.out.println("Хорошо!");
        boolean robberMoved = false;
        while (!robberMoved) {
            try {
                Hex robberHex = inputRequester.getRobberHex(mapView);
                if (map.getCurrentRobbedHex() == robberHex) {
                    System.out.println("Нельзя оставить разбойника на месте, нужно его передвинуть");
                }
                else {
                    map.moveRobber(robberHex);
                    robberMoved = true;
                    System.out.println(player.getColor() + " player, ты победил в игре, успешно передвинув разбойника");
                }

            } catch (PointNotInHex pointNotInHexException) {
                System.out.println("Ну куда кликаешь?");
                System.out.println("КУДА ТЫ КЛИКАЕШЬ? НУ ВОТ КУДА? ПО ЛБУ СЕБЕ ТЫКНИ!");
            }
        }
    }
}
