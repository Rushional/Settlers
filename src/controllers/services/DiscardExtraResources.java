package controllers.services;

import models.Player;
import models.ResourcesSet;
import views.graphics.SettlersFrame;
import views.services.RequestResourcesToDiscard;

public class DiscardExtraResources {
    public static void call(Player player, SettlersFrame frame) {
        System.out.println("FBI! OPEN UP!");
        System.out.println(player.getColor() + " игрок арестован и приговаривается к ВЕЧНОЙ ЛЕКЦИИ");
        System.out.println("Выберите предмет, по которому будет вечная лекция, или ОТДАВАЙТЕ ОВЦУ ");
        ResourcesSet discardSet = RequestResourcesToDiscard.call(frame);
        if (discardSet.getSheep() == 1) {
            System.out.println("Ваша овца КОНФИСКОВАНА");
            System.out.println("Если у вас нет овцы, вы должны правительству ОДНУ ОВЦУ");
        }
        else {
            System.out.println("TIME ENOUGH AT LAST!");
            System.out.println("Теперь вы сможете раскрыть ВСЕ ЗАГАДКИ ВСЕЛЕННОЙ");
            System.out.println("Но никогда не сможете покинуть лекцию...");
            System.out.println("Потому что препод ПРОВЕРЯЕТ ПОСЕЩАЕМОСТЬ");
        }
    }
}
