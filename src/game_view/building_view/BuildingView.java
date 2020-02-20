package game_view.building_view;

import exceptions.buildingException;
import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.map.MapHexes;
import game_view.graphics.map_graphics.MapPanel;
import game_view.sound.BuildingMessagesPlayer;

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

    public HexPoint askForPoint() throws wrongPointCoordinates {
        return pointsLinesGetter.getPoint();
    }

    public HexLine askForLine() throws wrongRoadCoordinates {
        return pointsLinesGetter.getLine();
    }

    public void handleStartSettlement(buildingException buildingException) {
        handler.handleStartSettlement(buildingException);
    }

    public void handleStartRoad(buildingException buildingException) {
        handler.handleStartRoad(buildingException);
    }

    //this will be refactored when I change graphics, but now it's okay
    public void showResult() {
        graphicsManager.repaint();
    }
}
