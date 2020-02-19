package game_model;

import game_model.building_model.BuildingModel;
import game_model.map.MapHexes;

//This class starts the game and determines the whole flow of it
public class GameModel {
    private MapHexes map;
    private Players players;
    private BuildingModel buildingModel;

    public GameModel() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
        buildingModel = new BuildingModel(players);
    }

    public Players getPlayers() {
        return players;
    }

    public MapHexes getMap() {
        return map;
    }

    public Player getCurrentPlayer() {
        return players.getCurrentPlayer();
    }

    public BuildingModel getBuildingModel() {
        return buildingModel;
    }
}
