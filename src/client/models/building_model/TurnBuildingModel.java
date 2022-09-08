package client.models.building_model;

import client.exceptions.buildingException;
import client.models.players.Players;
import client.models.hex.HexLine;
import client.models.hex.HexPoint;

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
