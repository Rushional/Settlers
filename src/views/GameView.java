package views;

import models.map.MapHexes;
import views.building_view.BuildingExceptionHandler;
import views.frame.SettlersFrame;
import views.frame.FrameInitiator;
import views.graphics.ViewUpdater;
import views.listeners.ControlInputRequester;
import views.listeners.MapInputRequester;
import views.sound.AudioPlayer;

public class GameView {
    private BuildingExceptionHandler exceptionsHandler;
    private SettlersFrame frame;
    private MapInputRequester mapInputRequester;
    private ControlInputRequester controlInputRequester;

    public GameView(MapHexes map) {
        AudioPlayer audioPlayer = new AudioPlayer();
        FrameInitiator frameInitiator = new FrameInitiator();
        frame = frameInitiator.initiateFrame(map);
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

}
