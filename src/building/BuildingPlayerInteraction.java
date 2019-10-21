package building;

import exceptions.*;
import interactions.Player;
import interactions.ResourcesSet;

//This class checks if player can add a settlement
public class BuildingPlayerInteraction {
    public static void validateSettlement(Player player) throws notEnoughForSettlement, maximumSettlementsAlready {
        if (!player.getResources().enoughFor(ResourcesSet.settlementSet())) throw new notEnoughForSettlement();
        if (player.getSettlementsAmount() >= 5) throw new maximumSettlementsAlready();
    }

    public static void validateRoad(Player player) throws notEnoughForRoad {
        if (!player.getResources().enoughFor(ResourcesSet.settlementSet())) throw new notEnoughForRoad();
    }

    public static void validateCity(Player player) throws notEnoughForCity, maximumCitiesAlready {
        if (!player.getResources().enoughFor(ResourcesSet.citySet())) throw new notEnoughForCity();
        if (player.getCitiesAmount() >= 4) throw new maximumCitiesAlready();
    }
}
