package client.models.services;

import client.models.ResourceType;
import client.models.ResourcesSet;
import client.models.hex.Building;
import client.models.hex.ResourceHex;
import client.models.map.MapHexes;
import client.views.services.ShowPlayersResources;

public class HarvestRollResources {
    public static void call(MapHexes map, int diceValue) {
        for(ResourceHex hex : map.getResourceHexes().list()) {
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

