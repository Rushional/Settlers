package server.models.building_model;

import server.exceptions.*;
import server.models.hex.HexPoint;
import server.models.players.Player;

import static server.models.building_model.BuildingPlayerInteraction.*;

//This is an action object, it manages building on a point
class BuildOnPoint {
    private Player player;
    private HexPoint point;

    BuildOnPoint(Player player, HexPoint point) {
        this.player = player;
        this.point = point;
    }

    void build() throws maximumCitiesAlready, notEnoughForCity, buildingNearby, noRoadsNearby, pointHasSettlement, cityBuiltAlready, notEnoughForSettlement, maximumSettlementsAlready
    {
        if (!point.hasBuilding()) {
            validateSettlement(player);
            point.addSettlement(player);
            player.increaseSettlementsAmount();
            payForSettlement(player);
            player.addVictoryPoint();
        }
        else if (point.getBuilding().isSettlement()) {
            if (point.getSettlement().getPlayer() == player) {
                validateCity(player);
                point.addCity(player);
                player.increaseCitiesAmount();
                payForCity(player);
                player.addVictoryPoint();
            }
            else throw new pointHasSettlement();
        }
            else throw new cityBuiltAlready();
    }
}
