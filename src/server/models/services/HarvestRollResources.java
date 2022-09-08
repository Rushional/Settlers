package server.models.services;

import client.views.services.ShowPlayersResources;
import server.models.ResourceType;
import server.models.ResourcesSet;
import server.models.hex.Building;
import server.models.hex.ResourceHex;
import server.models.map.MapHexes;

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

