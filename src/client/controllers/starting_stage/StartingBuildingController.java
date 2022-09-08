package client.controllers.starting_stage;

import client.models.building_model.StartBuildingModel;
import client.models.map.MapHexes;
import client.views.GameView;

import java.util.ArrayList;
import java.util.List;

public class StartingBuildingController {
    private StartBuildingModel model;
    private GameView view;
    private MapHexes map;

// MapHexes is only needed if I'm going to create StubBuilders.
// It's the easiest way to make StubBuilders possible, so I'll leave it in the constructor for all cases,
// Even for situations when I don't need to have access to map at all
    public StartingBuildingController(StartBuildingModel model, GameView view, MapHexes map) {
        this.map = map;
        this.model = model;
        this.view = view;
    }

    public void startingBuildingStage() {
        List<StartingBuilder> buildersList = new ArrayList<>();
//        Make 4 players - either real or stubs
//        buildersList.add(new UserStartingBuilder(model, view));
        buildersList.add(new StubStartingBuilder(model, view, map));
//        buildersList.add(new UserStartingBuilder(model, view));
        buildersList.add(new StubStartingBuilder(model, view, map));
        buildersList.add(new StubStartingBuilder(model, view, map));
        buildersList.add(new StubStartingBuilder(model, view, map));
        while (model.isRequiresBuilding()) {
            System.out.println(model.getPlayers().getCurrentPlayer().getColor() + " player's turn to build a settlement!");
            int currentIndex = model.getPlayers().getCurrentIndex();
            buildersList.get(currentIndex).buildAtStartPoint();
        }
    }
}
