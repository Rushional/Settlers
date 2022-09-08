package server.models.building_model;

import server.exceptions.buildingException;
import server.models.hex.HexLine;
import server.models.hex.HexPoint;
import server.models.players.Players;

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
