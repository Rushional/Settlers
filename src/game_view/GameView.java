package game_view;

import game_model.map.MapHexes;
import game_view.building_view.BuildingView;
import game_view.graphics.SettlersFrame;
import game_view.graphics.FrameInitiator;
import game_view.sound.AudioPlayer;

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

    public void showTurnResult() {
        buildingView.showResult();
    }
}
