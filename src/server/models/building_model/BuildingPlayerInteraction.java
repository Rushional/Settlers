package server.models.building_model;

import server.exceptions.*;
import server.models.ResourcesSet;
import server.models.players.Player;

import static client.models.ResourcesSet.*;

//This class checks if player can afford building
class BuildingPlayerInteraction {
    static void validateSettlement(Player player) throws notEnoughForSettlement, maximumSettlementsAlready {
        if (!player.getResources().enoughFor(ResourcesSet.settlementSet())) {
            throw new notEnoughForSettlement();
        }
        if (player.getSettlementsAmount() >= 5) throw new maximumSettlementsAlready();
    }

    static void validateRoad(Player player) throws notEnoughForRoad {
        if (!player.getResources().enoughFor(ResourcesSet.roadSet())) throw new notEnoughForRoad();
    }

    static void validateCity(Player player) throws notEnoughForCity, maximumCitiesAlready {
        if (!player.getResources().enoughFor(ResourcesSet.citySet())) throw new notEnoughForCity();
        if (player.getCitiesAmount() >= 4) throw new maximumCitiesAlready();
    }

    static void payForSettlement(Player player) {
        player.subtractResources(settlementSet());
    }

    static void payForRoad(Player player) {
        player.subtractResources(roadSet());
    }

    static void payForCity(Player player) {
        player.subtractResources(citySet());
    }


}
