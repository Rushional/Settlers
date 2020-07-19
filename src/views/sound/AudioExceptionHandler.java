package views.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;

// This class is created because I don't want to have a bunch of throws bla bla bla in a million different methods,
// but also I don't want to bother with sounds too much. So a bad way is fine for me.
class AudioExceptionHandler {
    private AudioPlayer audioPlayer;

    AudioExceptionHandler(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    void handleIO(IOException exception) {
        if (exception.getClass() == FileNotFoundException.class) System.out.println("File not found");
        else System.out.println("I/O broke");
        exception.printStackTrace();
    }

    void handleUnsupportedFile(Exception exception, AudioInputStream audioInputStream) {
        if (exception.getClass() == UnsupportedAudioFileException.class) System.out.println("Unsupported file");
        else if (exception.getClass() == LineUnavailableException.class) System.out.println("Line unavailable");
        exception.printStackTrace();
        try {
            audioInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(); //THIS IS A TERRIBLE IDEA but idk how to deal with it both neatly and reliably
        }
    }
}
