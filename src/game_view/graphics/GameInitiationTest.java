package game_view.graphics;

import game_model.GameModel;
import org.junit.jupiter.api.Test;
import system.GameInitiator;

import static org.junit.jupiter.api.Assertions.*;

class GameInitiationTest {

    @Test
    void initiateGameTest() {
        GameInitiator gameInitiator = new GameInitiator();
        GameModel gameModel = gameInitiator.getGameModel();
        assertNotNull(gameModel.getPlayers());
        assertNotNull(gameModel.getCurrentPlayer());
        assertNotNull(gameModel.getMap());
        DrawingArea drawingArea = gameInitiator.getDrawingArea();
        assertNotNull(drawingArea.getBuildingGraphicsManager());
        assertNotNull(drawingArea.getMap());
    }
}