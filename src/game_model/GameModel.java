package game_model;

import game_model.building_model.StartBuildingModel;
import game_model.map.MapHexes;

//This class starts the game and determines the whole flow of it
public class GameModel {
    private MapHexes map;
    private Players players;
    private StartBuildingModel startBuildingModel;

    public GameModel() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
        startBuildingModel = new StartBuildingModel(players, map);
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

    public StartBuildingModel getStartBuildingModel() {
        return startBuildingModel;
    }
}
