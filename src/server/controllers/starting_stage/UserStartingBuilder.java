package server.controllers.starting_stage;

import client.views.GameView;
import server.models.building_model.StartBuildingModel;
import server.models.hex.HexLine;
import server.models.hex.HexPoint;

class UserStartingBuilder extends StartingBuilder {

    UserStartingBuilder(StartBuildingModel model, GameView view) {
        super(model, view);
    }

    HexPoint buildStartingSettlement() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            try {
                settlementPoint = view.getMapInputRequester().getStartPoint();
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (server.exceptions.buildingException buildingException) {
                view.getExceptionsHandler().handleStartSettlement(buildingException);
            }
        }
        return settlementPoint;
    }

    void buildStartingRoad(HexPoint settlementPoint) {
        boolean buildSuccessful = false;
        HexLine roadLine;
        while (!buildSuccessful) {
            try {
                roadLine = view.getMapInputRequester().getStartLine();
                model.startBuildRoad(roadLine, settlementPoint);
                buildSuccessful = true;
            } catch (server.exceptions.buildingException buildingException) {
                view.getExceptionsHandler().handleStartRoad(buildingException);
            }
        }
    }
}
