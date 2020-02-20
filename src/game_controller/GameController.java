package game_controller;

import game_model.GameModel;
import game_view.GameView;

public class GameController {
    private BuildingController buildingController;
    private TurnsController turnsController;

    public GameController(GameModel model, GameView view) {
        buildingController = new BuildingController(model.getStartBuildingModel(), view.getBuildingView());
        turnsController = new TurnsController(model, view);
    }

    public void startGame() {
        buildingController.startingBuildingStage();
        turnsController.playTurns();
    }
}
