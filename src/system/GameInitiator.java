package system;

import controllers.GameController;
import services.ProcessHarvestStage;
import views.GameView;
import models.GameModel;

public class GameInitiator {
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;

    public GameInitiator() {
        gameModel = new GameModel();
        ProcessHarvestStage.call(gameModel.getMap());
        ProcessHarvestStage.call(gameModel.getMap());
        ProcessHarvestStage.call(gameModel.getMap());
        gameView = new GameView(gameModel.getMap());
        gameController = new GameController(gameModel, gameView);
        gameController.startGame();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
