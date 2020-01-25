package interactions;

import building_interface.BuildingGraphicsManager;
import hex.HexPoint;

public class TurnManager {
    private Game game;
    private HexPoint point;
    private BuildingGraphicsManager buildingGraphicsManager;

    TurnManager(Game game, BuildingGraphicsManager buildingGraphicsManager) {
        this.game = game;
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
