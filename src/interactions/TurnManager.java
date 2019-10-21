package interactions;

import user_interface.GuiActionsProcessor;
import hex.HexPoint;

public class TurnManager {
    private Game game;
    private HexPoint point;
    private GuiActionsProcessor guiActionsProcessor;

    public TurnManager(Game game, GuiActionsProcessor guiActionsProcessor) {
        this.game = game;
        this.guiActionsProcessor = guiActionsProcessor;
    }

    public void activateTurnCycle() {
        guiActionsProcessor.activateTurnListener();
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
