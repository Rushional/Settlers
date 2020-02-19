package game_model.building_model;

import exceptions.buildingNearby;
import exceptions.lineHasNoPoint;
import exceptions.pointHasSettlement;
import game_model.Players;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;

public class BuildingModel {
    private StartBuildingManager startBuildingManager;
    //can make some GameStage class where 1 - startBuilding, 2 - turns or whatever
    private boolean startBuildingStage;
    private boolean turnsStage;

    public BuildingModel(Players players) {
        startBuildingManager = new StartBuildingManager(players);
        startBuildingStage = true;
    }

    public void startBuildSettlement(HexPoint point) throws buildingNearby, pointHasSettlement {
        startBuildingManager.startBuildSettlement(point);
    }

    public void startBuildRoad(HexLine line, HexPoint point) throws lineHasNoPoint {
        startBuildingManager.startBuildRoad(line, point);
        if (!startBuildingManager.getRequiresBuilding()) activateTurnsStage();
    }

    private void activateTurnsStage() {
        startBuildingStage = false;
        turnsStage = true;
    }

    public boolean isStartBuildingStage() {
        return startBuildingStage;
    }
}
