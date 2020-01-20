package interactions;

import building_interface.BuildingGuiActionsProcessor;
import hex.HexPoint;

public class TurnManager {
    private Game game;
    private HexPoint point;
    private BuildingGuiActionsProcessor buildingGuiActionsProcessor;

    TurnManager(Game game, BuildingGuiActionsProcessor buildingGuiActionsProcessor) {
        this.game = game;
        this.buildingGuiActionsProcessor = buildingGuiActionsProcessor;
    }

    void activateTurnCycle() {
        buildingGuiActionsProcessor.activateTurnListener();
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
