package interactions;

import building_interface.BuildManagersRunner;
import building_interface.StartBuildingManager;
import building_interface.BuildingGraphicsManager;
import map.MapHexes;
import sound.BuildingMessagesPlayer;

//This class starts the game and determines the whole flow of it
public class Game {
    private MapHexes map;
    private Players players;
    private BuildManagersRunner buildManagersRunner;

    public Game() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
    }
    public void goSettling() {
        startBuilding();
        System.out.println("Players take turns repeatedly...");
        players.nextPlayer();
//        TurnManager turnManager = new TurnManager(this, buildingGraphicsManager);
//        turnManager.activateTurnCycle();
    }

    public void assignBuildManagersRunner(BuildManagersRunner runner) {
        buildManagersRunner = runner;
    }

    private void startBuilding() {
        buildManagersRunner.startBuilding();
        players.nextPlayer();
        buildManagersRunner.startBuilding();
        players.nextPlayer();
        buildManagersRunner.startBuilding();
        players.nextPlayer();
        buildManagersRunner.startBuilding();
        buildManagersRunner.startBuilding();
        players.previousPlayer();
        buildManagersRunner.startBuilding();
        players.previousPlayer();
        buildManagersRunner.startBuilding();
        players.previousPlayer();
        buildManagersRunner.startBuilding();
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
}
