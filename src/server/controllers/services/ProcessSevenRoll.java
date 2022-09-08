package server.controllers.services;

import client.views.frame.SettlersFrame;
import client.views.graphics.MapView;
import client.views.inputs.listeners.MapInputRequester;
import client.views.services.ShowPlayerResourcesAmounts;
import server.models.players.Player;
import server.models.players.Players;

import java.util.LinkedList;
import java.util.List;

public class ProcessSevenRoll {
    public static void call(Players players, SettlersFrame frame, MapInputRequester inputRequester, MapView mapView) {
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
        MoveRobber.call(players.getCurrentPlayer(), inputRequester, mapView);
        frame.getMapPanel().setStateUsual();
        frame.getMapPanel().repaint();
    }
}
