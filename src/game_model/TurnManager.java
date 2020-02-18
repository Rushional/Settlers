package game_model;

import game_view.building_view.BuildingGraphicsManager;
import game_model.hex.HexPoint;

public class TurnManager {
    private GameModel gameModel;
    private HexPoint point;
    private BuildingGraphicsManager buildingGraphicsManager;

    TurnManager(GameModel gameModel, BuildingGraphicsManager buildingGraphicsManager) {
        this.gameModel = gameModel;
        this.buildingGraphicsManager = buildingGraphicsManager;
    }

    void activateTurnCycle() {
        buildingGraphicsManager.activateTurnListener();
//        do {
//            //guiActionsProcessor method - drawingArea.replaceListener(new BuildListener());
//            //and then wait for end turn button press
//        } while (!checkWinCondition());
    }

    public void assignPoint(HexPoint point) {
        this.point = point;
    }

    private boolean checkWinCondition() {
        return false;
    }
}
