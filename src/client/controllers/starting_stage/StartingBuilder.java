package client.controllers.starting_stage;

import client.models.building_model.StartBuildingModel;
import client.models.hex.HexPoint;
import client.views.GameView;

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
