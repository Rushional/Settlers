package services;

import models.ResourcesSet;
import models.hex.Building;
import models.hex.Hex;
import models.map.MapHexes;

import java.util.Random;

public class ProcessHarvestStage {
    public static void call(MapHexes map) {
        Random random = new Random();
        int diceValue = random.nextInt(5) + random.nextInt(5) + 2;
        System.out.println("Rolled " + diceValue);
        for(Hex hex : map.getHexesList()) {
            if (hex.getDiceValue() == diceValue) {
//                System.out.println(hex.toString() + " " + diceValue);
                System.out.println("Hex type is " + hex.getClass().getSimpleName());
                for (Building building : hex.getBuildings()) {
                    System.out.println(building.getPlayer().getResources().toString());
                    ResourcesSet resourcesToAdd = hex.getResource();
                    building.getPlayer().addResources(resourcesToAdd);
//                    Give two resources if it's a city, and not a settlement
                    if (building.isCity()) {
                        building.getPlayer().addResources(resourcesToAdd);
                    }
                    System.out.println(building.getPlayer().getResources().toString());
                }
            }
        }
    };
}
