package game_view.building_view;

import AI.StartBuildingAI;
import game_model.building_model.StartBuildRoad;
import game_model.building_model.StartBuildSettlement;
import exceptions.buildingException;
import exceptions.lineHasNoPoint;
import game_model.Player;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.map.MapHexes;
import game_view.sound.BuildingMessagesPlayer;

//TO BE DELETED
class StartBuildingView {
    private Player player;
    private BuildingGraphicsManager graphicsManager;
    private StartBuildingAI startBuildingAI;
    private BuildingExceptionHandler buildingExceptionHandler;
    private PointsLinesGetter pointsLinesGetter;

    StartBuildingView(BuildingGraphicsManager graphicsManager,
                      StartBuildingAI startBuildingAI, Player player, BuildingMessagesPlayer messagePlayer,
                      MapHexes map) {
        this.player = player;
        this.graphicsManager = graphicsManager;
        this.startBuildingAI = startBuildingAI;
        buildingExceptionHandler = new BuildingExceptionHandler(messagePlayer);
        pointsLinesGetter = new PointsLinesGetter(graphicsManager, map, buildingExceptionHandler);
    }

    void requestBuild() {
        if (player.isHuman()) {
            //build starting settlement
            HexPoint point = null;
            boolean buildSettlementAwaiting = true;
            while (buildSettlementAwaiting) {
                try {
                    point = pointsLinesGetter.getPoint();
                    StartBuildSettlement startBuildSettlement = new StartBuildSettlement(player, point);
                    startBuildSettlement.build();
                    buildSettlementAwaiting = false;
                } catch (buildingException buildingException) {
                    buildingExceptionHandler.handleStartSettlement(buildingException);
                }
            }
            graphicsManager.repaint();
            //build starting road
            HexLine line;
            boolean buildRoadAwaiting = true;
            while (buildRoadAwaiting) {
                line = pointsLinesGetter.getLine(point);
                try {
                    if (!line.checkHasPoint(point)) throw new lineHasNoPoint();
                    StartBuildRoad startBuildRoad = new StartBuildRoad(player, line, point);
                    startBuildRoad.build();
                    buildRoadAwaiting = false;
                } catch (buildingException buildingException) {
                    buildingExceptionHandler.handleStartRoad(buildingException);
                }
            }
            graphicsManager.repaint();
        }
        else {
            startBuildingAI.startBuildPoint(player);
        }
    }
}
