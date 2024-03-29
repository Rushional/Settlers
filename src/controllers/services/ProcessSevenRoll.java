package controllers.services;

import models.map.MapHexes;
import models.players.Player;
import models.players.Players;
import views.frame.SettlersFrame;
import views.graphics.MapView;
import views.inputs.listeners.MapInputRequester;
import views.services.ShowPlayerResourcesAmounts;

import java.util.LinkedList;
import java.util.List;

public class ProcessSevenRoll {
    public static void call(Players players, SettlersFrame frame, MapInputRequester inputRequester, MapView mapView, MapHexes map) {
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
//        now the ROLLER moves the ROBBER, ohhhhh yeah!!!!
        frame.getMapPanel().setStateRobber();
        MoveRobber.call(players.getCurrentPlayer(), inputRequester, mapView, map);
        frame.getMapPanel().setStateUsual();
        frame.getMapPanel().repaint();
    }
}
