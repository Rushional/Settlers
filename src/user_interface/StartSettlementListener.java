package user_interface;

import com.sun.tools.javac.Main;
import exceptions.buildingException;
import exceptions.pointHasSettlement;
import exceptions.buildingNearby;
import exceptions.wrongPointCoordinates;
import graphics.DrawingArea;
import building.StartBuildingManager;

import javax.sound.sampled.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static java.lang.Math.abs;

public class StartSettlementListener extends MouseInputAdapter {
    private Point pressedPoint, releasedPoint;
    private int pressedX, pressedY, releasedX, releasedY;
    private DrawingArea drawingArea;
    private CountDownLatch latch;
    private StartBuildingManager startBuildingManager;

    public StartSettlementListener(DrawingArea drawingArea, CountDownLatch latch, StartBuildingManager startBuildingManager)
    {
        super();
        this.drawingArea = drawingArea;
        this.latch = latch;
        this.startBuildingManager = startBuildingManager;
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
        pressedX = pressedPoint.x;
        pressedY = pressedPoint.y;
    }

    public void mouseReleased(MouseEvent e)
    {
        releasedPoint = e.getPoint();
        releasedX = releasedPoint.x;
        releasedY = releasedPoint.y;
        if ((abs(releasedX - pressedX) < 15) && (abs(releasedY - pressedY) < 15)) {
            try {
                startBuildingManager.assignPoint(drawingArea.getGuiActionsProcessor().pointByCoordinates(releasedX, releasedY));
                latch.countDown();
            } catch (buildingException buildingException) {
                handleBuildingException(buildingException);
            }
        }
        else
            System.out.println("Сначала нужно построить поселение, для этого нужно кликнуть на точку");
    }

    private void handleBuildingException(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) {
            System.out.println("Здесь нет точки");
            //playSound("\\src\\warn.wav");

            File warnWav = new File("src\\warn.wav");
//            if (!warnWav.exists()) System.out.println("I DON'T EXIST! I DON'T EXIST!");
//            try {
//                playClip(warnWav);
//            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
//                System.out.println("Формат плохой");
//            } catch (IOException e) {
//                System.out.println("i/o broke");
//            } catch (LineUnavailableException lineUnavailableException) {
//                System.out.println("ЛИНИЯ ЗАНЯТА ОБЛОМ НЕЛЬЗЯ");
//            } catch (InterruptedException interruptedException) {
//                System.out.println("INTERRUPTED");
//            }
            try {
                drawingArea.getAudioPlayer().playClip(warnWav);
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                System.out.println("Формат плохой");
            } catch (IOException e) {
                System.out.println("i/o broke");
            } catch (LineUnavailableException lineUnavailableException) {
                System.out.println("ЛИНИЯ ЗАНЯТА ОБЛОМ НЕЛЬЗЯ");
            } catch (InterruptedException interruptedException) {
                System.out.println("INTERRUPTED");
            }
        }
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == pointHasSettlement.class) System.out.println("В этом месте уже есть поселение");
    }

    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream(/*"/path/to/sounds/" + */url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    System.out.println("b");
                }
            }
        }).start();
    }

    private static void playClip(File clipFile) throws IOException,
            UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
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

        AudioListener listener = new AudioListener();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(clipFile);
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
}
