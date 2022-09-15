package models;

import exceptions.building_exceptions.buildingException;
import exceptions.building_exceptions.wrongPointCoordinates;
import exceptions.building_exceptions.wrongRoadCoordinates;
import models.building_model.TurnBuildingModel;
import models.players.Players;
import views.inputs.intentions.*;

public class TurnsModel {
    private Players players;
    private TurnBuildingModel turnBuildingModel;

    TurnsModel(Players players) {
        this.players = players;
        this.turnBuildingModel = new TurnBuildingModel(players);
    }

    public void realizeIntention(ViewIntention intention) throws buildingException {
        if (intention instanceof ViewIntentionWrongPoint) throw new wrongPointCoordinates();
        if (intention instanceof ViewIntentionWrongLine) throw new wrongRoadCoordinates();
        if (intention instanceof ViewIntentionEndTurn) {
            players.nextPlayer();
            return;
        }
        if (intention instanceof ViewIntentionBuildOnPoint) {
            ViewIntentionBuildOnPoint settlementIntention = (ViewIntentionBuildOnPoint)intention;
            turnBuildingModel.buildOnPoint(settlementIntention.getPoint());
            return;
        }
        if (intention instanceof ViewIntentionBuildRoad) {
            ViewIntentionBuildRoad roadIntention = (ViewIntentionBuildRoad)intention;
            turnBuildingModel.buildRoad(roadIntention.getLine());
        }
    }
}
