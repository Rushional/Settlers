package game_view;

import game_model.map.MapHexes;
import game_view.building_view.BuildingView;
import game_view.graphics.MapPanel;
import game_view.graphics.FrameInitiator;
import game_view.sound.AudioPlayer;

public class GameView {
    private AudioPlayer audioPlayer;
    private BuildingView buildingView;

    public GameView(MapHexes map) {
        audioPlayer = new AudioPlayer();
        FrameInitiator frameInitiator = new FrameInitiator();
        MapPanel mapPanel = frameInitiator.initiateFrame(map);
        buildingView = new BuildingView(audioPlayer.getBuildingMessagesPlayer(), mapPanel, map);
    }

    public BuildingView getBuildingView() {
        return buildingView;
    }
}
