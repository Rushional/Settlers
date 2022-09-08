package client.controllers.services;

import client.models.players.Players;
import client.models.map.MapHexes;
import client.models.services.HarvestRollResources;
import client.views.frame.SettlersFrame;
import client.views.graphics.MapView;
import client.views.inputs.listeners.MapInputRequester;

import java.util.Random;

public class ProcessHarvestStage {
    public static void call(Players players, MapHexes map, SettlersFrame frame, MapInputRequester inputRequester, MapView mapView) {
        Random random = new Random();
        int diceValue = random.nextInt(5) + random.nextInt(5) + 2; // random 0-5 + 1 twice - 2d6
        System.out.println("Rolled " + diceValue);
        if (diceValue == 7) ProcessSevenRoll.call(players, frame, inputRequester, mapView);
        else HarvestRollResources.call(map, diceValue);
    }
}
