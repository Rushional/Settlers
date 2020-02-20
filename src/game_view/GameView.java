package game_view;

import game_model.map.MapHexes;
import game_view.building_view.BuildingView;
import game_view.graphics.SettlersFrame;
import game_view.graphics.map_graphics.MapPanel;
import game_view.graphics.FrameInitiator;
import game_view.sound.AudioPlayer;

public class GameView {
    private AudioPlayer audioPlayer;
    private BuildingView buildingView;
    private SettlersFrame frame;

    public GameView(MapHexes map) {
        audioPlayer = new AudioPlayer();
        FrameInitiator frameInitiator = new FrameInitiator();
        frame = frameInitiator.initiateFrame(map);
        buildingView = new BuildingView(audioPlayer.getBuildingMessagesPlayer(), frame.getMapPanel(), map);
    }

    public BuildingView getBuildingView() {
        return buildingView;
    }

    //for now just to test

    public SettlersFrame getFrame() {
        return frame;
    }
}
