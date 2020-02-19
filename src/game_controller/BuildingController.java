package game_controller;

import exceptions.buildingException;
import game_model.building_model.BuildingModel;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_view.building_view.BuildingView;

public class BuildingController {
    private BuildingModel model;
    private BuildingView view;

    public BuildingController(BuildingModel model, BuildingView view) {
        this.model = model;
        this.view = view;
    }

    public void initiateGame() {
        startingBuildingStage();
        //turns
    }

    public void startingBuildingStage() {
        while (model.isStartBuildingStage()) {
            startBuildSettlement();
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
                roadLine = view.askForLine(settlementPoint); //restricts to only neighbour lines
                model.startBuildRoad(roadLine, settlementPoint);
                buildSuccessful = true;
            } catch (buildingException buildingException) {
                view.handleStartRoad(buildingException);
            }
        }
        view.showResult();
    }
}
