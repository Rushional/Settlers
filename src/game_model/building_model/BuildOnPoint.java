package game_model.building_model;

import exceptions.*;
import game_model.hex.HexPoint;
import game_model.Player;

import static game_model.building_model.BuildingPlayerInteraction.validateCity;
import static game_model.building_model.BuildingPlayerInteraction.validateSettlement;

//This is an action object, it manages building on a point
public class BuildOnPoint {
    private Player player;
    private HexPoint point;

    public BuildOnPoint(Player player, HexPoint point) {
        this.player = player;
        this.point = point;
    }

    public void build() throws maximumCitiesAlready, notEnoughForCity, buildingNearby, noRoadsNearby, pointHasSettlement, cityBuiltAlready, notEnoughForSettlement, maximumSettlementsAlready
    {
        if (!point.hasBuilding()) {
            validateSettlement(player);
            point.addSettlement(player);
            player.increaseSettlementsAmount();
            player.payForSettlement();
        }
        else if (point.getBuilding().isSettlement()) {
            if (point.getSettlement().getPlayer() == player) {
                //build city!
                validateCity(player);
                point.addCity(player);
                player.increaseCitiesAmount();
                player.payForCity();
                System.out.println("Город построен!");
            }
            else throw new pointHasSettlement();
        }
            else throw new cityBuiltAlready();
    }
}
