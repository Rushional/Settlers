package client.views.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private AudioInputStream currentAudioInputStream;

    private AudioExceptionHandler audioExceptionHandler;
    public AudioInputStream getCurrentAudioInputStream() {
        return currentAudioInputStream;
    }

    private BuildingMessagesPlayer buildingMessagesPlayer;
    public BuildingMessagesPlayer getBuildingMessagesPlayer() {
        return buildingMessagesPlayer;
    }

    public AudioPlayer() {
        audioExceptionHandler = new AudioExceptionHandler(this);
        buildingMessagesPlayer = new BuildingMessagesPlayer(this);
    }

    void playClip(File clipFile) {
        if (currentAudioInputStream != null)
            interruptSound();
        AudioListener listener = new AudioListener();
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(clipFile);
            currentAudioInputStream = audioInputStream;
            Clip clip = AudioSystem.getClip();
            clip.addLineListener(listener);
            clip.open(audioInputStream);
            try {
                clip.start();
                listener.waitUntilDone();
            } catch (InterruptedException interruptedException) {
                clip.close();
            }
        } catch (IOException inputOutputException) {
            audioExceptionHandler.handleIO(inputOutputException);
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            audioExceptionHandler.handleUnsupportedFile(e, audioInputStream);
        }
    }

    class AudioListener implements LineListener {
        private boolean done = false;
        @Override public synchronized void update(LineEvent event) {
            LineEvent.Type eventType = event.getType();
            if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
                done = true;
                notifyAll();
            }
        }
        synchronized void waitUntilDone() throws InterruptedException {
            while (!done) { wait(); }
        }
    }

    //Not sure if it works sadly, but don't want to delve into sounds too much, it's not important
    //It definitely runs, but it doesn't interrupt anything
    private void interruptSound() {
        if (currentAudioInputStream != null) {
            System.out.println("Well current one exists");
            try {
                if (AudioSystem.getClip() != null) {
                    AudioSystem.getClip().stop();
                    AudioSystem.getClip().close();
                }
                currentAudioInputStream.close();
            } catch (IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Well AudioInputStream doesn't even exist!");
    }
}
