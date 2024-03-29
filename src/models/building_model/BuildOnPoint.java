package models.building_model;

import exceptions.building_exceptions.*;
import models.hex.HexPoint;
import models.players.Player;

import static models.building_model.BuildingPlayerInteraction.*;

//TODO: refactor to be a service because obviously that's what it was intended to be
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
