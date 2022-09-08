package server.models.building_model;

import server.exceptions.buildingException;
import server.exceptions.lineHasRoad;
import server.models.hex.HexLine;
import server.models.players.Player;

import static server.models.building_model.BuildingPlayerInteraction.payForRoad;
import static server.models.building_model.BuildingPlayerInteraction.validateRoad;

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
