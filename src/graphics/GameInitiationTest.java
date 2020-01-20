package graphics;

import interactions.Game;
import org.junit.jupiter.api.Test;
import system.GameInitiator;

import static org.junit.jupiter.api.Assertions.*;

class GameInitiationTest {

    @Test
    void initiateGameTest() {
        GameInitiator gameInitiator = new GameInitiator();
        Game game = gameInitiator.getGame();
        assertTrue(game.getPlayers() != null);
        assertTrue(game.getBuildingGuiActionsProcessor() != null);
        assertTrue(game.getCurrentPlayer() != null);
        assertTrue(game.getMap() != null);
        DrawingArea drawingArea = game.getBuildingGuiActionsProcessor().getDrawingArea();
        assertTrue(drawingArea.getBuildingGuiActionsProcessor() != null);
        assertTrue(drawingArea.getCurrentPlayer() != null);
        //assertTrue(drawingArea.getDrawer() != null);
        assertTrue(drawingArea.getGame() != null);
        assertTrue(drawingArea.getMap() != null);
    }
}