package server.models.building_model;

import server.exceptions.buildingNearby;
import server.exceptions.lineHasNoPoint;
import server.exceptions.pointHasSettlement;
import server.models.hex.HexLine;
import server.models.hex.HexPoint;
import server.models.players.Players;

public class StartBuildingModel {
    private Players players;
    private boolean requiresBuilding;
    private boolean goingForward; //startBuilding - have we reached the last player?

    public StartBuildingModel(Players players) {
        this.players = players;
        goingForward = true;
        requiresBuilding = true;
    }

    public void startBuildSettlement(HexPoint point) throws buildingNearby, pointHasSettlement {
        var startBuildSettlement = new StartBuildSettlement(players.getCurrentPlayer(), point);
        startBuildSettlement.build();
    }

    public void startBuildRoad(HexLine line, HexPoint point) throws lineHasNoPoint {
        var startBuildRoad = new StartBuildRoad(players.getCurrentPlayer(), line, point);
        startBuildRoad.build();
        if (goingForward) {
            if (players.currentIsLast()) goingForward = false;
            else players.nextPlayer();
        }
        else
            if (!players.currentIsFirst()) players.previousPlayer();
            else requiresBuilding = false;
    }

    public boolean isRequiresBuilding() {
        return requiresBuilding;
    }

    public Players getPlayers() {
        return players;
    }
}
