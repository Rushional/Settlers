package client.controllers;

import client.controllers.starting_stage.StartingBuildingController;
import client.models.GameModel;
import client.views.GameView;

public class GameController {
    private StartingBuildingController startingBuildingController;
    private TurnsController turnsController;

    public GameController(GameModel model, GameView view) {
        startingBuildingController = new StartingBuildingController(model.getStartBuildingModel(), view, model.getMap());
        turnsController = new TurnsController(model, view);
    }

    public void startGame() {
        startingBuildingController.startingBuildingStage();
        turnsController.playTurns();
    }
}
