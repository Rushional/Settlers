package controllers.services;

import models.Player;
import models.Players;
import views.services.ShowPlayerResourcesAmounts;
import views.services.ShowPlayersResources;

import java.util.LinkedList;
import java.util.List;

public class ProcessSevenRoll {
    public static void call(Players players) {
        List<Player> playersList = players.getPlayersList();
//        check if anyone has more than seven resources
//        get a list of those who does
        List<Player> abusersOfWorkingClass = new LinkedList<>();
        for (Player player : playersList) {
            ShowPlayerResourcesAmounts.call(player);
            if (player.getResources().getTotalAmount() >= 7) {
                abusersOfWorkingClass.add(player);
            }
        }
//        make those who does drop extra resources
        for (Player player : abusersOfWorkingClass) {
            DropExtraResources.call(player);
        }
        MoveRobber.call(players.getCurrentPlayer());
//        now the ROLLER moves the ROBBER
    }
}
