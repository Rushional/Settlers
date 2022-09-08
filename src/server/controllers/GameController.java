package server.controllers;

import client.views.GameView;
import server.controllers.starting_stage.StartingBuildingController;
import server.models.GameModel;

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
