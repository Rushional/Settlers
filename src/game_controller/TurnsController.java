package game_controller;

import exceptions.buildingException;
import game_model.GameModel;
import game_view.GameView;

class TurnsController {
    private GameModel gameModel;
    private GameView gameView;

    TurnsController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    void playTurns() {
        gameModel.getPlayers().nextPlayer();
        while (gameModel.isOngoing()) {
            try {
                gameModel.getTurnsModel().realizeIntention(gameView.getTurnsView().requestIntention());
            } catch (buildingException buildingException) {
                gameView.getBuildingView().handleTurn(buildingException);
            }
            gameView.showTurnResult();
        }
    }
}
