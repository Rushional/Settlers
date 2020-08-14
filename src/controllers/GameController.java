package controllers;

import controllers.starting_stage.StartingBuildingController;
import models.GameModel;
import models.map.MapHexes;
import views.GameView;

public class GameController {
    private StartingBuildingController startingBuildingController;
    private TurnsController turnsController;

    public GameController(GameModel model, GameView view) {
//        real one:
//        buildingController = new BuildingController(model.getStartBuildingModel(), view.getBuildingView());
//        Stub:
        startingBuildingController = new StartingBuildingController(model.getStartBuildingModel(), view.getBuildingView(), model.getMap());
        turnsController = new TurnsController(model, view);
    }

    public void startGame() {
        startingBuildingController.startingBuildingStage();
        turnsController.playTurns();
    }
}
