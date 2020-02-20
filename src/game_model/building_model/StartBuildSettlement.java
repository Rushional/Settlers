package game_model.building_model;

import exceptions.buildingNearby;
import exceptions.pointHasSettlement;
import game_model.hex.HexPoint;
import game_model.Player;

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