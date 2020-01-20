package interactions;

import AI.StartBuildingAI;
import building_interface.StartBuildingManager;
import building_interface.BuildingGuiActionsProcessor;
import map.MapHexes;

public class Game {
    private MapHexes map;
    private Players players;
    private BuildingGuiActionsProcessor buildingGuiActionsProcessor;
    //it will become AiManager later
    private StartBuildingAI startBuildingAI;

    public Game() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
        if (!players.getRedPlayer().isHuman() || !players.getBluePlayer().isHuman() || !players.getGreenPlayer().isHuman() || !players.getVioletPlayer().isHuman())
            startBuildingAI = new StartBuildingAI(map);
    }

    public void addGuiActionsProcessor(BuildingGuiActionsProcessor actionsProcessor)
    {
        this.buildingGuiActionsProcessor = actionsProcessor;
    }

    public void goSettling() {
        startBuilding();
        System.out.println("Players take turns repeatedly...");
//        System.out.println("There will be an end turn button some day...");
        players.nextPlayer();
        TurnManager turnManager = new TurnManager(this, buildingGuiActionsProcessor);
        turnManager.activateTurnCycle();
    }

    private void startBuilding() {
        StartBuildingManager red1 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        red1.requestBuild();
        players.nextPlayer();
        StartBuildingManager blue1 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        blue1.requestBuild();
        players.nextPlayer();
        StartBuildingManager green1 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        green1.requestBuild();
        players.nextPlayer();
        StartBuildingManager violet1 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        violet1.requestBuild();
        StartBuildingManager violet2 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        violet2.requestBuild();
        players.previousPlayer();
        StartBuildingManager green2 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        green2.requestBuild();
        players.previousPlayer();
        StartBuildingManager blue2 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        blue2.requestBuild();
        players.previousPlayer();
        StartBuildingManager red2 = new StartBuildingManager(buildingGuiActionsProcessor, startBuildingAI, getCurrentPlayer());
        red2.requestBuild();
    }

    public Players getPlayers() {
        return players;
    }

    //for tests
    public MapHexes getMap() {
        return map;
    }

    public BuildingGuiActionsProcessor getBuildingGuiActionsProcessor() {
        return buildingGuiActionsProcessor;
    }

    public Player getCurrentPlayer() {
        return players.getCurrentPlayer();
    }
}
