package models.building_model;

import exceptions.buildingException;
import exceptions.buildingNearby;
import exceptions.lineHasNoPoint;
import exceptions.pointHasSettlement;
import models.Players;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;

public class StartBuildingModel {
    private Players players;
    private StartBuildingAI startBuildingAI;
    private boolean requiresBuilding;
    private boolean goingForward; //startBuilding - have we reached the last player?

    public StartBuildingModel(Players players, MapHexes map) {
        this.players = players;
        startBuildingAI = new StartBuildingAI(map);
        goingForward = true;
        requiresBuilding = true;
        startBuildingAiActions();
    }

    public void startBuildingAiActions() {
        while (!players.getCurrentPlayer().isHuman() && requiresBuilding) startBuildAi();
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

    private void startBuildAi() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
          settlementPoint = startBuildingAI.chooseStartPoint();
          try {
              startBuildSettlement(settlementPoint);
              buildSuccessful = true;
          } catch (buildingException ignored) {}
        }
        try {
            startBuildRoad(startBuildingAI.chooseStartLine(settlementPoint), settlementPoint);
        } catch (buildingException e) {
            throw new RuntimeException(); //this probably won't ever happen
            //and also this is a "fake" AI method so for now this is enough
        }
    }

    public boolean isRequiresBuilding() {
        return requiresBuilding;
    }
}
