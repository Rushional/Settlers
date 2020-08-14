package controllers.starting_stage;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import views.building_view.BuildingView;

public class UserStartingBuilder extends StartingBuilder {

    public UserStartingBuilder(StartBuildingModel model, BuildingView view) {
        super(model, view);
    }

    HexPoint buildStartingSettlement() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            try {
                settlementPoint = view.requestPoint();
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (exceptions.buildingException buildingException) {
                view.handleStartSettlement(buildingException);
            }
        }
        return settlementPoint;
    };

    void buildStartingRoad(HexPoint settlementPoint) {
        boolean buildSuccessful = false;
        HexLine roadLine;
        while (!buildSuccessful) {
            try {
                roadLine = view.requestLine();
                model.startBuildRoad(roadLine, settlementPoint);
                buildSuccessful = true;
            } catch (buildingException buildingException) {
                view.handleStartRoad(buildingException);
            }
        }
    };
}
