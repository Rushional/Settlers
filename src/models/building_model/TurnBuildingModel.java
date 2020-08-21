package models.building_model;

import exceptions.buildingException;
import models.players.Players;
import models.hex.HexLine;
import models.hex.HexPoint;

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
