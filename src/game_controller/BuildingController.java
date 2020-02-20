package game_controller;

import exceptions.buildingException;
import game_model.building_model.StartBuildingModel;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_view.building_view.BuildingView;

public class BuildingController {
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
                settlementPoint = view.askForPoint();
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
                roadLine = view.askForLine();
                model.startBuildRoad(roadLine, settlementPoint);
                buildSuccessful = true;
            } catch (buildingException buildingException) {
                view.handleStartRoad(buildingException);
            }
        }
        view.showResult();
    }
}
