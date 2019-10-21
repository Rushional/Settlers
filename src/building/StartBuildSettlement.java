package building;

import exceptions.buildingNearby;
import exceptions.pointHasSettlement;
import hex.HexPoint;
import interactions.Player;

//This is an action object, it manages building on a point at the start of the game
public class StartBuildSettlement {
    private Player player;
    private HexPoint point;

    public StartBuildSettlement(Player player, HexPoint point) {
        this.player = player;
        this.point = point;
    }

    public void build() throws buildingNearby, pointHasSettlement
    {
        if (!point.hasBuilding()) {
            point.startAddSettlement(player);
            player.increaseSettlementsAmount();
        }
        else throw new pointHasSettlement();
    }
}