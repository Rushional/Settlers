package client.views;

import client.models.map.MapHexes;
import client.views.graphics.MapView;
import client.views.graphics.PolygonGeometries;
import client.views.graphics.Polygons;
import client.views.sound.BuildingExceptionHandler;
import client.views.frame.SettlersFrame;
import client.views.frame.FrameInitiator;
import client.views.inputs.listeners.ControlInputRequester;
import client.views.inputs.listeners.MapInputRequester;
import client.views.sound.AudioPlayer;

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
