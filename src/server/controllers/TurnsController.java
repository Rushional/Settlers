package server.controllers;

import client.views.GameView;
import client.views.inputs.intentions.ViewIntention;
import client.views.inputs.intentions.ViewIntentionEndTurn;
import client.views.inputs.listeners.RequestTurnIntention;
import client.views.services.ShowPlayersResources;
import server.controllers.services.ProcessHarvestStage;
import server.models.GameModel;

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
        ProcessHarvestStage.call(gameModel.getPlayers(), gameModel.getMap(), gameView.getFrame(),
                gameView.getMapInputRequester(), gameView.getMapView());
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
        } catch (server.exceptions.buildingException buildingException) {
            gameView.getExceptionsHandler().handleTurn(buildingException);
        }
        gameView.updateMap();
    }
}
