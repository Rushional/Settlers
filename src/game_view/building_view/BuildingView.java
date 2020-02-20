package game_view.building_view;

import exceptions.buildingException;
import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.map.MapHexes;
import game_view.TurnsView;
import game_view.graphics.map_graphics.MapPanel;
import game_view.sound.BuildingMessagesPlayer;

import java.util.concurrent.CountDownLatch;

//This probably violates(?) SRP, so maybe should be refactored
public class BuildingView {
    private BuildingExceptionHandler handler;
    private PointsLinesGetter pointsLinesGetter;
    private BuildingGraphicsManager graphicsManager;

    public BuildingView
            (BuildingMessagesPlayer buildingMessagesPlayer, MapPanel mapPanel, MapHexes map) {
        handler = new BuildingExceptionHandler(buildingMessagesPlayer);
        graphicsManager = new BuildingGraphicsManager(mapPanel);
        pointsLinesGetter = new PointsLinesGetter(graphicsManager, map, handler);
    }

    public HexPoint requestPoint() throws wrongPointCoordinates {
        return pointsLinesGetter.getPoint();
    }

    public HexLine requestLine() throws wrongRoadCoordinates {
        return pointsLinesGetter.getLine();
    }

    public void waitForIntention(CountDownLatch latch, TurnsView turnsView) {
        pointsLinesGetter.waitForIntention(turnsView, latch);
    }

    public void handleStartSettlement(buildingException buildingException) {
        handler.handleStartSettlement(buildingException);
    }

    public void handleStartRoad(buildingException buildingException) {
        handler.handleStartRoad(buildingException);
    }

    public void handleTurn(buildingException buildingException) {
        handler.handleTurn(buildingException);
    }

    public void showResult() {
        graphicsManager.repaint();
    }
}
