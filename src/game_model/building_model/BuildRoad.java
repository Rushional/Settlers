package game_model.building_model;

import exceptions.buildingException;
import exceptions.lineHasRoad;
import game_model.hex.HexLine;
import game_model.Player;

import static game_model.building_model.BuildingPlayerInteraction.validateRoad;

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