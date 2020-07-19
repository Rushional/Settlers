package controllers;

import exceptions.buildingException;
import models.GameModel;
import views.GameView;

class TurnsController {
    private GameModel gameModel;
    private GameView gameView;

    TurnsController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    void playTurns() {
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
