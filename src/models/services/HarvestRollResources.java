package models.services;

import models.ResourceType;
import models.ResourcesSet;
import models.hex.Building;
import models.hex.ResourceHex;
import models.map.MapHexes;
import views.services.ShowPlayersResources;

public class HarvestRollResources {
    public static void call(MapHexes map, int diceValue) {
        for(ResourceHex hex : map.getResourceHexes().list()) {
            if (checkIfHexHarvestsThisTurn(hex, diceValue)) {
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

    private static boolean checkIfHexHarvestsThisTurn(ResourceHex hex, int diceValue) {
        return (hex.getDiceValue() == diceValue) && (!hex.isRobbed());
    }
}

