package game_view.building_view;

import AI.StartBuildingAI;
import game_model.GameModel;
import game_model.Players;
import game_view.sound.BuildingMessagesPlayer;

//This is a link between a game model and a graphical representation
//This class calls building processors in Game
public class BuildManagersRunner {
    private GameModel gameModel;
    private StartBuildingAI startBuildingAI;
    private BuildingGraphicsManager graphicsManager;
    private BuildingMessagesPlayer messagesPlayer;

    public BuildManagersRunner(GameModel gameModel, BuildingGraphicsManager graphicsManager, BuildingMessagesPlayer messagesPlayer) {
        this.gameModel = gameModel;
        this.graphicsManager = graphicsManager;
        this.messagesPlayer = messagesPlayer;
        Players players = gameModel.getPlayers();
        startBuildingAI = null;
        if (!players.getRedPlayer().isHuman() || !players.getBluePlayer().isHuman() || !players.getGreenPlayer().isHuman() || !players.getVioletPlayer().isHuman())
            startBuildingAI = new StartBuildingAI(gameModel.getMap());
    }

    public void startBuilding() {
        StartBuildingManager startBuildingManager = new StartBuildingManager
                (graphicsManager, startBuildingAI, gameModel.getCurrentPlayer(), messagesPlayer, gameModel.getMap());
        startBuildingManager.requestBuild();
    }
}
