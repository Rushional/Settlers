package models;

import models.building_model.StartBuildingModel;
import models.map.MapHexes;

//This class starts the game and determines the whole flow of it
public class GameModel {
    private MapHexes map;
    private Players players;
    private StartBuildingModel startBuildingModel;
    private TurnsModel turnsModel;

    public GameModel() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
//        players = new Players(true, true, true, true);
        startBuildingModel = new StartBuildingModel(players, map);
        turnsModel = new TurnsModel(players);
    }

    public boolean isOngoing() {
        for (int i = 0; i < 4 ; i++) {
            if (players.getPlayerIndex(i).getVictoryPoints() >= 10) return false;
        }
        return true;
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

    public TurnsModel getTurnsModel() {
        return turnsModel;
    }
}
