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
        assertNotNull(game.getPlayers());
        assertNotNull(game.getBuildingGraphicsManager());
        assertNotNull(game.getCurrentPlayer());
        assertNotNull(game.getMap());
        DrawingArea drawingArea = game.getBuildingGraphicsManager().getDrawingArea();
        assertNotNull(drawingArea.getBuildingGraphicsManager());
        assertNotNull(drawingArea.getCurrentPlayer());
        //assertTrue(drawingArea.getDrawer() != null);
        assertNotNull(drawingArea.getGame());
        assertNotNull(drawingArea.getMap());
    }
}