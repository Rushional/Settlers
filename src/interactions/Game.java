package interactions;

import AI.StartBuildingAI;
import building_interface.PointsLinesGetter;
import building_interface.StartBuildingManager;
import building_interface.BuildingGraphicsManager;
import map.MapHexes;
import sound.BuildingMessagesPlayer;

//This class starts the game and determines the whole flow of it
public class Game {
    private MapHexes map;
    private Players players;
    //it will become AiManager later
    private StartBuildingAI startBuildingAI;
    private BuildingGraphicsManager buildingGraphicsManager;
    private BuildingMessagesPlayer messagesPlayer;
    private PointsLinesGetter pointsLinesGetter;

    public Game() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
        if (!players.getRedPlayer().isHuman() || !players.getBluePlayer().isHuman() || !players.getGreenPlayer().isHuman() || !players.getVioletPlayer().isHuman())
            startBuildingAI = new StartBuildingAI(map);
    }

    //TO DO this definitely should be removed from this class into some graphic class
    public void assignSystemStuff(BuildingMessagesPlayer messagesPlayer) {
        this.messagesPlayer = messagesPlayer;
    }

    public void addGuiActionsProcessor(BuildingGraphicsManager actionsProcessor)
    {
        this.buildingGraphicsManager = actionsProcessor;
    }

    public void goSettling() {
        startBuilding();
        System.out.println("Players take turns repeatedly...");
//        System.out.println("There will be an end turn button some day...");
        players.nextPlayer();
        TurnManager turnManager = new TurnManager(this, buildingGraphicsManager);
        turnManager.activateTurnCycle();
    }

    //TO DO move output to
    //TO DO make a "startBuilding" method and use it here to make it look better
    private void startBuilding() {
        StartBuildingManager red1 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        red1.requestBuild();
        players.nextPlayer();
        StartBuildingManager blue1 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        blue1.requestBuild();
        players.nextPlayer();
        StartBuildingManager green1 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        green1.requestBuild();
        players.nextPlayer();
        StartBuildingManager violet1 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        violet1.requestBuild();
        StartBuildingManager violet2 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        violet2.requestBuild();
        players.previousPlayer();
        StartBuildingManager green2 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        green2.requestBuild();
        players.previousPlayer();
        StartBuildingManager blue2 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        blue2.requestBuild();
        players.previousPlayer();
        StartBuildingManager red2 = new StartBuildingManager(buildingGraphicsManager, startBuildingAI, getCurrentPlayer(), messagesPlayer, map);
        red2.requestBuild();
    }

    public Players getPlayers() {
        return players;
    }

    //for tests
    public MapHexes getMap() {
        return map;
    }

    public BuildingGraphicsManager getBuildingGraphicsManager() {
        return buildingGraphicsManager;
    }

    public Player getCurrentPlayer() {
        return players.getCurrentPlayer();
    }
}
