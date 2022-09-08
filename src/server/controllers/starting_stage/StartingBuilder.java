package server.controllers.starting_stage;

import client.views.GameView;
import server.models.building_model.StartBuildingModel;
import server.models.hex.HexPoint;

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
