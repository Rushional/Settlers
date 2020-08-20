package controllers;

import controllers.services.ProcessHarvestStage;
import exceptions.buildingException;
import models.GameModel;
import views.GameView;
import views.listeners.*;
import views.services.ShowPlayersResources;

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
        ProcessHarvestStage.call(gameModel.getPlayers(), gameModel.getMap(), gameView.getFrame());
        System.out.println();
        ShowPlayersResources.call(gameModel.getCurrentPlayer());
        ViewIntention intention = RequestTurnIntention.call(gameView.getMapInputRequester(), gameView.getControlInputRequester());
//        var intention = gameView.getTurnsView().requestIntention();
        while (!(intention instanceof ViewIntentionEndTurn)) {
            processIntention(intention);
//            intention = gameView.get().requestIntention();
            intention = RequestTurnIntention.call(gameView.getMapInputRequester(), gameView.getControlInputRequester());
        }
//        end turn
        processIntention(intention);
        System.out.println();
    }

    private void processIntention(ViewIntention intention) {
        try {
            gameModel.getTurnsModel().realizeIntention(intention);
        } catch (buildingException buildingException) {
            System.out.println("I'm trying my best to handle a building exception here");
            gameView.getExceptionsHandler().handleTurn(buildingException);
        }
        gameView.updateMap();
    }
}
