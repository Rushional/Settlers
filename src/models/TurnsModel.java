package models;

import exceptions.buildingException;
import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import models.building_model.TurnBuildingModel;
import views.graphics.*;

public class TurnsModel {
    private Players players;
    private TurnBuildingModel turnBuildingModel;

    TurnsModel(Players players) {
        this.players = players;
        this.turnBuildingModel = new TurnBuildingModel(players);
    }

    public void realizeIntention(ViewIntention intention) throws buildingException {
        if (intention.getClass() == ViewIntentionWrongPoint.class) throw new wrongPointCoordinates();
        if (intention.getClass() == ViewIntentionWrongLine.class) throw new wrongRoadCoordinates();
        if (intention.getClass() == ViewIntentionEndTurn.class) {
            players.nextPlayer();
            return;
        }
        if (intention.getClass() == ViewIntentionBuildOnPoint.class) {
            ViewIntentionBuildOnPoint settlementIntention = (ViewIntentionBuildOnPoint)intention;
            turnBuildingModel.buildOnPoint(settlementIntention.getPoint());
            return;
        }
        if (intention.getClass() == ViewIntentionBuildRoad.class) {
            ViewIntentionBuildRoad roadIntention = (ViewIntentionBuildRoad)intention;
            turnBuildingModel.buildRoad(roadIntention.getLine());
        }
    }
}
