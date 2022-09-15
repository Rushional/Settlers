package models.building_model;

import exceptions.building_exceptions.buildingException;
import exceptions.building_exceptions.lineHasRoad;
import models.hex.HexLine;
import models.players.Player;
import static models.building_model.BuildingPlayerInteraction.payForRoad;
import static models.building_model.BuildingPlayerInteraction.validateRoad;

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
