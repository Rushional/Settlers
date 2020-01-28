package building_interface;

import AI.StartBuildingAI;
import interactions.Game;
import interactions.Players;
import sound.BuildingMessagesPlayer;

//This is a link between a game model and a graphical representation
//This class calls building processors in Game
public class BuildManagersRunner {
    private Game game;
    private StartBuildingAI startBuildingAI;
    private BuildingGraphicsManager graphicsManager;
    private BuildingMessagesPlayer messagesPlayer;

    public BuildManagersRunner(Game game, BuildingGraphicsManager graphicsManager, BuildingMessagesPlayer messagesPlayer) {
        this.game = game;
        this.graphicsManager = graphicsManager;
        this.messagesPlayer = messagesPlayer;
        Players players = game.getPlayers();
        startBuildingAI = null;
        if (!players.getRedPlayer().isHuman() || !players.getBluePlayer().isHuman() || !players.getGreenPlayer().isHuman() || !players.getVioletPlayer().isHuman())
            startBuildingAI = new StartBuildingAI(game.getMap());
    }

    public void startBuilding() {
        StartBuildingManager startBuildingManager = new StartBuildingManager
                (graphicsManager, startBuildingAI, game.getCurrentPlayer(), messagesPlayer, game.getMap());
        startBuildingManager.requestBuild();
    }
}
