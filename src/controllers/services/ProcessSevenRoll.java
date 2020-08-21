package controllers.services;

import models.players.Player;
import models.players.Players;
import views.frame.SettlersFrame;
import views.services.ShowPlayerResourcesAmounts;

import java.util.LinkedList;
import java.util.List;

public class ProcessSevenRoll {
    public static void call(Players players, SettlersFrame frame) {
        List<Player> playersList = players.getPlayersList();
//        check if anyone has seven or more resources
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
            DiscardExtraResources.call(player, frame);
        }
        MoveRobber.call(players.getCurrentPlayer());
//        now the ROLLER moves the ROBBER
    }
}
