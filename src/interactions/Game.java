package interactions;

import AI.StartBuildingAI;
import building.StartBuildingManager;
import user_interface.GuiActionsProcessor;
import map.MapHexes;

public class Game {
    private MapHexes map;
    private Players players;
    private GuiActionsProcessor guiActionsProcessor;
    //it will become AiManager later
    private StartBuildingAI startBuildingAI;

    public Game() {
        map = new MapHexes();
        players = new Players(false, true, false, false);
        if (!players.getRedPlayer().isHuman() || !players.getBluePlayer().isHuman() || !players.getGreenPlayer().isHuman() || !players.getVioletPlayer().isHuman())
            startBuildingAI = new StartBuildingAI(map);
    }

    public void addGuiActionsProcessor(GuiActionsProcessor actionsProcessor)
    {
        this.guiActionsProcessor = actionsProcessor;
    }

    public void goSettling() {
        startBuilding();
        System.out.println("Players take turns repeatedly...");
//        System.out.println("There will be an end turn button some day...");
        players.nextPlayer();
        TurnManager turnManager = new TurnManager(this, guiActionsProcessor);
        turnManager.activateTurnCycle();
    }

    private void startBuilding() {
        StartBuildingManager red1 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        red1.requestBuild();
        players.nextPlayer();
        StartBuildingManager blue1 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        blue1.requestBuild();
        players.nextPlayer();
        StartBuildingManager green1 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        green1.requestBuild();
        players.nextPlayer();
        StartBuildingManager violet1 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        violet1.requestBuild();
        StartBuildingManager violet2 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        violet2.requestBuild();
        players.previousPlayer();
        StartBuildingManager green2 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        green2.requestBuild();
        players.previousPlayer();
        StartBuildingManager blue2 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        blue2.requestBuild();
        players.previousPlayer();
        StartBuildingManager red2 = new StartBuildingManager(guiActionsProcessor, startBuildingAI, getCurrentPlayer());
        red2.requestBuild();
    }

    public Players getPlayers() {
        return players;
    }

    //for tests
    public MapHexes getMap() {
        return map;
    }

    public GuiActionsProcessor getGuiActionsProcessor() {
        return guiActionsProcessor;
    }

    public Player getCurrentPlayer() {
        return players.getCurrentPlayer();
    }
}
