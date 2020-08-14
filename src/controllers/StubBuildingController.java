package controllers;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;
import views.building_view.BuildingView;
import views.services.ShowPlayersResources;


// This class mocks the starting building stage, so that everything happens automatically
// and so testing is easier
public class StubBuildingController extends BuildingController {
    private StartBuildingInputMocker inputMocker;

    public StubBuildingController(StartBuildingModel model, BuildingView view, MapHexes map) {
        super(model, view);
        inputMocker = new StartBuildingInputMocker(map);
    }

    void startingBuildingStage() {
        while (model.isRequiresBuilding()) {
            System.out.println(model.getPlayers().getCurrentPlayer().getColor() + " player's turn to build a settlement!");
            startBuildSettlementStub();
        }
    }

    private void startBuildSettlementPlayer() {
//        Building the starting settlement
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
        view.showResult();
//        Building the starting road
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
        ShowPlayersResources.call(model.getPlayers().getCurrentPlayer());
    }

    private void startBuildSettlementStub() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            settlementPoint = inputMocker.chooseStartPoint();
            try {
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (buildingException ignored) {}
        }
        try {
            model.startBuildRoad(inputMocker.chooseStartLine(settlementPoint), settlementPoint);
        } catch (buildingException e) {
            throw new RuntimeException(); //this probably won't ever happen
            //and also this is a stub so for now this is enough
        }
    }
}
