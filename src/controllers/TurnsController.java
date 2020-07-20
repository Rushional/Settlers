package controllers;

import exceptions.buildingException;
import models.GameModel;
import services.ProcessHarvestStage;
import views.GameView;
import views.graphics.ViewIntention;
import views.graphics.ViewIntentionEndTurn;
import views.graphics.gui.ShowPlayersResources;

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
        System.out.println(gameModel.getCurrentPlayer().getColor() + " player's turn!");
        ProcessHarvestStage.call(gameModel.getMap());
        System.out.println();
        ShowPlayersResources.call(gameModel.getCurrentPlayer());
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
