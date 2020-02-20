package system;

import game_controller.GameController;
import game_view.GameView;
import game_model.GameModel;

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
