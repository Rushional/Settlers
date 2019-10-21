package sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//I'm planning to create a single mutable AudioPlayer for the game.
//Maybe I will change it later on so that every sound is played in it's own AudioInputStream
//But now I'm gonna try and make a single one - sounds simpler.
//If I need to interrupt it, I'll be able to call AudioPlayer.interrupt() or something
//In case I want multiple streams, I will also need to have a currentStream field for my AudioPlayer

public class AudioPlayer {
    private AudioInputStream currentAudioInputStream;

    public void playClip(File clipFile) throws IOException,
            UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        if (!clipFile.exists()) throw new FileNotFoundException();
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

    public void interruptSound() {
        if (currentAudioInputStream != null)
            try {
                if (AudioSystem.getClip() != null)  {
                    AudioSystem.getClip().stop();
                    System.out.println("clip stop");
                    AudioSystem.getClip().close();
                    System.out.println("clip close");
                }
                currentAudioInputStream.close();
                System.out.println("current stream close");
            } catch (IOException ioexception) {
                ioexception.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
    }
}
