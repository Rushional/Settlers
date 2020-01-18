package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AudioPlayer {
    private AudioInputStream currentAudioInputStream;

    private boolean isPlaying;
    public boolean getIsPlaying() {
        return isPlaying;
    }

    public AudioPlayer() {
        isPlaying = false;
    }

    public void playClip(File clipFile) throws IOException,
            UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        isPlaying = true;
        if (!clipFile.exists()) throw new FileNotFoundException();
        if (currentAudioInputStream != null)
            interruptSound();
        AudioListener listener = new AudioListener();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(clipFile);
        currentAudioInputStream = audioInputStream;
        try {
            Clip clip = AudioSystem.getClip();
            clip.addLineListener(listener);
            clip.open(audioInputStream);
            try {
                clip.start();
                listener.waitUntilDone();
            } finally {
                clip.close();
            }
        } finally {
            audioInputStream.close();
            currentAudioInputStream = null;
            isPlaying = false;
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
        public synchronized void waitUntilDone() throws InterruptedException {
            while (!done) { wait(); }
        }
    }

    private void interruptSound() {
        if (currentAudioInputStream != null) {
            System.out.println("Well current one exists");
            try {
                if (AudioSystem.getClip() != null) {
                    AudioSystem.getClip().stop();
                    AudioSystem.getClip().close();
                }
                currentAudioInputStream.close();
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }
        else System.out.println("Well AudioInputStream doesn't even exist!");
    }
}
