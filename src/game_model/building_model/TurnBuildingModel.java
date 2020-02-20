package game_model.building_model;

import exceptions.buildingException;
import game_model.Players;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;

public class TurnBuildingModel {
    private Players players;

    public TurnBuildingModel(Players players) {
        this.players = players;
    }

    public void buildOnPoint(HexPoint point) throws buildingException {
        var buildOnPoint = new BuildOnPoint(players.getCurrentPlayer(), point);
        buildOnPoint.build();
    }

    public void buildRoad(HexLine line) throws buildingException {
        var buildRoad = new BuildRoad(players.getCurrentPlayer(), line);
        buildRoad.build();
    }
}
