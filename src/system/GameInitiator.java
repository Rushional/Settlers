package system;

import game_controller.BuildingController;
import game_controller.GameController;
import game_view.GameView;
import game_model.GameModel;
import game_view.graphics.EndTurnListener;

public class GameInitiator {
    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;

    public GameInitiator() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel.getMap());
        gameController = new GameController(gameModel, gameView);
        gameController.startGame();
        //to be removed, these were just testing the button
        gameView.getFrame().getControlPanel().removeEndTurnListener();
        gameView.getFrame().getControlPanel().addEndTurnListener
                (new EndTurnListener("The button has been compromised! Initiate evacuation!"));
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
