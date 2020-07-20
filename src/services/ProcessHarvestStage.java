package services;

import models.ResourceType;
import models.ResourcesSet;
import models.hex.Building;
import models.hex.ResourceHex;
import models.map.MapHexes;
import views.graphics.gui.ShowPlayersResources;

import java.util.Random;

public class ProcessHarvestStage {
    public static void call(MapHexes map) {
        Random random = new Random();
        int diceValue = random.nextInt(5) + random.nextInt(5) + 2;
        System.out.println("Rolled " + diceValue);
        for(ResourceHex hex : map.getResourceHexesList()) {
            if (hex.getDiceValue() == diceValue) {
                System.out.println("Hex type is " + hex.getResourceType());
                for (Building building : hex.getBuildings()) {
//                    ShowPlayersResources.call(building.getPlayer());
                    ResourceType resourcesToAdd = hex.getResourceType();
                    if (building.isSettlement()) {
                        building.getPlayer().addResources(ResourcesSet.getOneOf(resourcesToAdd));
                    }
                    else {
                        building.getPlayer().addResources(ResourcesSet.getTwoOf(resourcesToAdd));
                    }
                    ShowPlayersResources.call(building.getPlayer());
                }
            }
        }
    }
}

