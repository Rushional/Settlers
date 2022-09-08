package server.models.building_model;

import server.exceptions.buildingNearby;
import server.exceptions.pointHasSettlement;
import server.models.hex.HexPoint;
import server.models.players.Player;

//This is an action object, it manages building on a point at the start of the game
class StartBuildSettlement {
    private Player player;
    private HexPoint point;

    StartBuildSettlement(Player player, HexPoint point) {
        this.player = player;
        this.point = point;
    }

    void build() throws buildingNearby, pointHasSettlement
    {
        if (!point.hasBuilding()) {
            point.startAddSettlement(player);
            player.increaseSettlementsAmount();
            player.addVictoryPoint();
        }
        else throw new pointHasSettlement();
    }
}