package controllers;

import models.GameModel;
import views.GameView;

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