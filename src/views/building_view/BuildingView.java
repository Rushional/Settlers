package views.building_view;

import exceptions.buildingException;
import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;
import views.TurnsView;
import views.graphics.map_graphics.MapPanel;
import views.sound.BuildingMessagesPlayer;

//This probably violates(?) SRP, so maybe should be refactored
public class BuildingView {
    private BuildingExceptionHandler handler;
    private PointsLinesGetter pointsLinesGetter;
    private BuildingGraphicsManager graphicsManager;

    public BuildingView
            (BuildingMessagesPlayer buildingMessagesPlayer, MapPanel mapPanel, MapHexes map) {
        handler = new BuildingExceptionHandler(buildingMessagesPlayer);
        graphicsManager = new BuildingGraphicsManager(mapPanel);
        pointsLinesGetter = new PointsLinesGetter(graphicsManager, map);
    }

    public HexPoint requestPoint() throws wrongPointCoordinates {
        return pointsLinesGetter.getPoint();
    }

    public HexLine requestLine() throws wrongRoadCoordinates {
        return pointsLinesGetter.getLine();
    }

    public void waitForIntention(Object monitor, TurnsView turnsView) {
        pointsLinesGetter.waitForIntention(turnsView, monitor);
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
