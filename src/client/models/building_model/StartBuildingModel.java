package client.models.building_model;

import client.exceptions.buildingNearby;
import client.exceptions.lineHasNoPoint;
import client.exceptions.pointHasSettlement;
import client.models.players.Players;
import client.models.hex.HexLine;
import client.models.hex.HexPoint;

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
