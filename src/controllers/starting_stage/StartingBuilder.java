package controllers.starting_stage;

import models.building_model.StartBuildingModel;
import models.hex.HexPoint;
import views.building_view.BuildingView;

public abstract class StartingBuilder {
    StartBuildingModel model;
    BuildingView view;

    StartingBuilder(StartBuildingModel model, BuildingView view) {
        this.model = model;
        this.view = view;
    }

    public void buildAtStartPoint() {
        HexPoint settlementPoint = buildStartingSettlement();
        view.showResult();
        buildStartingRoad(settlementPoint);
        view.showResult();
    };

    abstract HexPoint buildStartingSettlement();

    abstract void buildStartingRoad(HexPoint settlementPoint);
}
