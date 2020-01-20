package building;

import exceptions.buildingException;
import exceptions.lineHasRoad;
import hex.HexLine;
import interactions.Player;

import static building.BuildingPlayerInteraction.validateRoad;

public class BuildRoad {
    private Player player;
    private HexLine line;

    public BuildRoad(Player player, HexLine line) {
        this.player = player;
        this.line = line;
    }

    public void build() throws buildingException {
        if (line.hasRoad()) throw new lineHasRoad();
        validateRoad(player);
        line.addRoad(player);
        player.payForRoad();
    }
}
