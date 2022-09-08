package client.system;

import client.controllers.GameController;
import client.views.GameView;
import client.models.GameModel;

public class GameInitiator {
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;

    public GameInitiator() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel.getMap());
        gameController = new GameController(gameModel, gameView);
        gameController.startGame();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
