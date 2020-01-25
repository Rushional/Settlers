package sound;

import java.io.File;

public class BuildingMessagesPlayer {
    private AudioPlayer audioPlayer;

    BuildingMessagesPlayer(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public void playWrongPointCoordinates() {
        audioPlayer.playClip(new File("src\\building_messages\\wrongPointCoordinates.wav"));
    }

    public void playException() {
        audioPlayer.playClip(new File("src\\building_messages\\warn.wav"));
    }
}
