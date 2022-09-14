package views;

import models.map.MapHexes;
import views.graphics.MapView;
import views.graphics.PolygonGeometries;
import views.graphics.Polygons;
import views.sound.BuildingExceptionHandler;
import views.frame.SettlersFrame;
import views.frame.FrameInitiator;
import views.inputs.listeners.ControlInputRequester;
import views.inputs.listeners.MapInputRequester;
import views.sound.AudioPlayer;

public class GameView {
    private BuildingExceptionHandler exceptionsHandler;
    private SettlersFrame frame;
    private MapInputRequester mapInputRequester;
    private ControlInputRequester controlInputRequester;
    private MapView mapView;

    public GameView(MapHexes map) {
        AudioPlayer audioPlayer = new AudioPlayer();
        FrameInitiator frameInitiator = new FrameInitiator();
        mapView = new MapView(new Polygons(), map.getHexes(), new PolygonGeometries());
        frame = frameInitiator.initiateFrame(map, mapView);
        exceptionsHandler = new BuildingExceptionHandler(audioPlayer.getBuildingMessagesPlayer());
        mapInputRequester = new MapInputRequester(frame.getMapPanel(), map);
        controlInputRequester = new ControlInputRequester(frame.getControlPanel());
    }

    public void updateMap() {
        frame.getMapPanel().repaint();
    }

    public SettlersFrame getFrame() {
        return frame;
    }

    public BuildingExceptionHandler getExceptionsHandler() {
        return exceptionsHandler;
    }

    public MapInputRequester getMapInputRequester() {
        return mapInputRequester;
    }

    public ControlInputRequester getControlInputRequester() {
        return controlInputRequester;
    }

    public MapView getMapView() {
        return mapView;
    }
}
