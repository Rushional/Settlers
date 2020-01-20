package building_interface;

import exceptions.buildingException;
import exceptions.pointHasSettlement;
import exceptions.buildingNearby;
import exceptions.wrongPointCoordinates;
import graphics.DrawingArea;
import sound.AudioPlayer;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

import static java.lang.Math.abs;

public class StartSettlementListener extends MouseInputAdapter {
    private Point pressedPoint, releasedPoint;
    private int pressedX, pressedY, releasedX, releasedY;
    private DrawingArea drawingArea;
    private CountDownLatch latch;
    private StartBuildingManager startBuildingManager;
    private BuildingExceptionHandler buildingExceptionHandler;

    StartSettlementListener(DrawingArea drawingArea, CountDownLatch latch, StartBuildingManager startBuildingManager, AudioPlayer audioPlayer)
    {
        super();
        this.drawingArea = drawingArea;
        this.latch = latch;
        this.startBuildingManager = startBuildingManager;
        buildingExceptionHandler = new BuildingExceptionHandler(audioPlayer);
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
                startBuildingManager.assignPoint(drawingArea.getBuildingGuiActionsProcessor().pointByCoordinates(releasedX, releasedY));
                latch.countDown();
            } catch (buildingException buildingException) {
                buildingExceptionHandler.handleStartSettlement(buildingException);
            }
        }
        else
            System.out.println("Сначала нужно построить поселение, для этого нужно кликнуть на точку");
    }
}
