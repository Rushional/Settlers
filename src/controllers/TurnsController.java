package controllers;

import exceptions.buildingException;
import models.GameModel;
import services.ProcessHarvestStage;
import views.GameView;
import views.graphics.ViewIntention;
import views.graphics.ViewIntentionEndTurn;

class TurnsController {
    private GameModel gameModel;
    private GameView gameView;

    TurnsController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    void playTurns() {
        while (gameModel.isOngoing()) {
            processTurn();
        }
    }

    private void processTurn() {
        ProcessHarvestStage.call(gameModel.getMap());
        ViewIntention intention = gameView.getTurnsView().requestIntention();
        while (!(intention instanceof ViewIntentionEndTurn)) {
            processIntention(intention);
            intention = gameView.getTurnsView().requestIntention();
        }
//        end turn
        processIntention(intention);
    }

    private void processIntention(ViewIntention intention) {
        try {
            gameModel.getTurnsModel().realizeIntention(intention);
        } catch (buildingException buildingException) {
            gameView.getBuildingView().handleTurn(buildingException);
        }
        gameView.showTurnResult();
    }
}
