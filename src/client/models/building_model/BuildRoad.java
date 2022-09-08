package client.models.building_model;

import client.exceptions.buildingException;
import client.exceptions.lineHasRoad;
import client.models.hex.HexLine;
import client.models.players.Player;
import static client.models.building_model.BuildingPlayerInteraction.payForRoad;
import static client.models.building_model.BuildingPlayerInteraction.validateRoad;

class BuildRoad {
    private Player player;
    private HexLine line;

    BuildRoad(Player player, HexLine line) {
        this.player = player;
        this.line = line;
    }

    void build() throws buildingException {
        if (line.hasRoad()) throw new lineHasRoad();
        validateRoad(player);
        line.addRoad(player);
        payForRoad(player);
    }
}
