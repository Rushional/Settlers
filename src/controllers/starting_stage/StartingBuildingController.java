package controllers.starting_stage;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;
import views.building_view.BuildingView;
import views.services.ShowPlayersResources;

import java.util.ArrayList;
import java.util.List;

public class StartingBuildingController {
    StartBuildingModel model;
    BuildingView view;
    MapHexes map;

// MapHexes is only needed if I'm going to create StubBuilders.
// It's the easiest way to make StubBuilders possible, so I'll leave it in the constructor for all cases,
// Even for situations when I don't need to have access to map at all
    public StartingBuildingController(StartBuildingModel model, BuildingView view, MapHexes map) {
        this.map = map;
        this.model = model;
        this.view = view;
    }

    public void startingBuildingStage() {
        List<StartingBuilder> buildersList = new ArrayList<>();
        buildersList.add(new UserStartingBuilder(model, view));
        buildersList.add(new StubStartingBuilder(map, model, view));
        buildersList.add(new UserStartingBuilder(model, view));
        buildersList.add(new StubStartingBuilder(map, model, view));
        while (model.isRequiresBuilding()) {
            System.out.println(model.getPlayers().getCurrentPlayer().getColor() + " player's turn to build a settlement!");
            int currentIndex = model.getPlayers().getCurrentIndex();
            buildersList.get(currentIndex).buildAtStartPoint();
        }
    }
}
