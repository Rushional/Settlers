package building_interface;

import AI.StartBuildingAI;
import building.StartBuildRoad;
import building.StartBuildSettlement;
import exceptions.buildingException;
import exceptions.lineHasNoPoint;
import interactions.Player;
import building_interface.BuildingGuiActionsProcessor;
import hex.HexLine;
import hex.HexPoint;

public class StartBuildingManager {
    private Player player;
    private HexPoint point;
    private BuildingGuiActionsProcessor actionsProcessor;
    private StartBuildingAI startBuildingAI;
    private HexLine line;

    public StartBuildingManager(BuildingGuiActionsProcessor actionsProcessor, StartBuildingAI startBuildingAI, Player player) {
        this.player = player;
        this.actionsProcessor = actionsProcessor;
        this.startBuildingAI = startBuildingAI;
    }

    public void requestBuild() {
        if (player.isHuman()) {
            boolean buildSettlementAwaiting = true;
            while (buildSettlementAwaiting) {
                actionsProcessor.activateStartSettlementListener(this);
                StartBuildSettlement startBuildSettlement = new StartBuildSettlement(player, point);
                try {
                    startBuildSettlement.build();
                    buildSettlementAwaiting = false;
                } catch (buildingException buildingException) {
                    actionsProcessor.handleStartSettlementExceptions(buildingException);
                }
            }
            actionsProcessor.repaint();
            //build starting road
            boolean buildRoadAwaiting = true;
            while (buildRoadAwaiting) {
                actionsProcessor.activateStartRoadListener(point, this);
                try {
                    if (!line.checkHasPoint(point)) throw new lineHasNoPoint();
                    StartBuildRoad startBuildRoad = new StartBuildRoad(player, line, point);
                    startBuildRoad.build();
                    buildRoadAwaiting = false;
                } catch (buildingException buildingException) {
                    actionsProcessor.handleStartRoadExceptions(buildingException);
                }
            }
            actionsProcessor.repaint();
        }
        else {
            startBuildingAI.startBuildPoint(player);
        }
    }

    void assignPoint(HexPoint point) {
        this.point = point;
    }

    void assignLine(HexLine line) {
        this.line = line;
    }
}
