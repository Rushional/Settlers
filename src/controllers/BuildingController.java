package controllers;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import views.building_view.BuildingView;

class BuildingController {
    private StartBuildingModel model;
    private BuildingView view;

    BuildingController(StartBuildingModel model, BuildingView view) {
        this.model = model;
        this.view = view;
    }

    void startingBuildingStage() {
        while (model.isRequiresBuilding()) {
            startBuildSettlement();
            model.startBuildingAiActions();
        }
    }

    private void startBuildSettlement() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            try {
                settlementPoint = view.requestPoint();
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (buildingException buildingException) {
                view.handleStartSettlement(buildingException);
            }
        }
        view.showResult();
        buildSuccessful = false;
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
        view.showResult();
    }
}
