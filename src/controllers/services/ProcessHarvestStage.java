package controllers.services;

import models.Players;
import models.map.MapHexes;
import models.services.HarvestRollResources;

import java.util.Random;

public class ProcessHarvestStage {
    public static void call(Players players, MapHexes map) {
        Random random = new Random();
        int diceValue = random.nextInt(5) + random.nextInt(5) + 2; // random 0-5 + 1 twice - 2d6
        System.out.println("Rolled " + diceValue);
        if (diceValue == 7) ProcessSevenRoll.call(players);
        else HarvestRollResources.call(map, diceValue);
    }
}
