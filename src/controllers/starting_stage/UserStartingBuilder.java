package controllers.starting_stage;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import views.GameView;

class UserStartingBuilder extends StartingBuilder {

    UserStartingBuilder(StartBuildingModel model, GameView view) {
        super(model, view);
    }

    HexPoint buildStartingSettlement() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            try {
                settlementPoint = view.getMapInputRequester().inputStartPoint();
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (exceptions.buildingException buildingException) {
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
                roadLine = view.getMapInputRequester().inputStartLine();
                model.startBuildRoad(roadLine, settlementPoint);
                buildSuccessful = true;
            } catch (buildingException buildingException) {
                view.getExceptionsHandler().handleStartRoad(buildingException);
            }
        }
    }
}
