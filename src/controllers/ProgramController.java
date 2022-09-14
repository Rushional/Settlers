package controllers;

import views.GameView;
import models.GameModel;

public class ProgramController {
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;

    public ProgramController() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel.getMap());
        gameController = new GameController(gameModel, gameView);
        gameController.startGame();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
