package views;

import models.map.MapHexes;
import views.building_view.BuildingView;
import views.graphics.SettlersFrame;
import views.graphics.FrameInitiator;
import views.sound.AudioPlayer;

public class GameView {
    private AudioPlayer audioPlayer;
    private BuildingView buildingView;
    private ControlView controlView;
    private TurnsView turnsView;
    private SettlersFrame frame;

    public GameView(MapHexes map) {
        audioPlayer = new AudioPlayer();
        FrameInitiator frameInitiator = new FrameInitiator();
        frame = frameInitiator.initiateFrame(map);
        buildingView = new BuildingView(audioPlayer.getBuildingMessagesPlayer(), frame.getMapPanel(), map);
        controlView = new ControlView(frame.getControlPanel());
        turnsView = new TurnsView(buildingView, controlView);
    }

    public BuildingView getBuildingView() {
        return buildingView;
    }

    public TurnsView getTurnsView() {
        return turnsView;
    }

    public SettlersFrame getFrame() {
        return frame;
    }

    public void showTurnResult() {
        buildingView.showResult();
    }
}
