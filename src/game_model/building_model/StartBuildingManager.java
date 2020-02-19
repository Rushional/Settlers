package game_model.building_model;

import exceptions.buildingNearby;
import exceptions.lineHasNoPoint;
import exceptions.pointHasSettlement;
import game_model.Players;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;

class StartBuildingManager {
    private Players players;
    private boolean requiresBuilding;
    private boolean goingForward; //startBuilding - have we reached the last player?

    StartBuildingManager(Players players) {
        this.players = players;
        goingForward = true;
        requiresBuilding = true;
    }

    void startBuildSettlement(HexPoint point) throws buildingNearby, pointHasSettlement {
        StartBuildSettlement startBuildSettlement = new StartBuildSettlement(players.getCurrentPlayer(), point);
        startBuildSettlement.build();
    }

    void startBuildRoad(HexLine line, HexPoint point) throws lineHasNoPoint {
        StartBuildRoad startBuildRoad = new StartBuildRoad(players.getCurrentPlayer(), line, point);
        startBuildRoad.build();
        if (goingForward) {
            if (players.currentIsLast()) goingForward = false;
            else players.nextPlayer();
        }
        else
            if (!players.currentIsFirst()) players.previousPlayer();
            else requiresBuilding = false;
    }

    boolean getRequiresBuilding() {
        return requiresBuilding;
    }
}
