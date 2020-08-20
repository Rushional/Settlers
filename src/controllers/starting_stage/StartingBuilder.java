package controllers.starting_stage;

import models.building_model.StartBuildingModel;
import models.hex.HexPoint;
import views.GameView;

public abstract class StartingBuilder {
    StartBuildingModel model;
    GameView view;

    StartingBuilder(StartBuildingModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void buildAtStartPoint() {
        HexPoint settlementPoint = buildStartingSettlement();
        view.updateMap();
        buildStartingRoad(settlementPoint);
        view.updateMap();
    };

    abstract HexPoint buildStartingSettlement();

    abstract void buildStartingRoad(HexPoint settlementPoint);
}
