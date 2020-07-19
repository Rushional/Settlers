package services;

import models.hex.Building;
import models.hex.Hex;
import models.map.MapHexes;

import java.util.Random;

public class ProcessHarvestStage {
    public static void call(MapHexes map) {
        Random random = new Random();
        int diceValue = random.nextInt(5) + random.nextInt(5) + 2;
        System.out.println(diceValue);
        for(Hex hex : map.getHexesList()) {
            if (hex.getDiceValue() == diceValue) {
                System.out.println(hex.toString() + " " + diceValue);
                for (Building building : hex.getBuildings()) {
                    System.out.println(building.getPlayer().getResources().toString());
                    building.getPlayer().addResources(hex.getResource());
                    System.out.println(building.getPlayer().getResources().toString());
                }
            }
        }
    };
}
