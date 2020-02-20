package system;

import game_controller.BuildingController;
import game_view.GameView;
import game_model.GameModel;

public class GameInitiator {
    private GameModel gameModel;
    private GameView gameView;

    public GameInitiator() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel.getMap());
        var buildingController = new BuildingController(gameModel.getStartBuildingModel(), gameView.getBuildingView());
        buildingController.initiateGame();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
