package user_interface;

import exceptions.*;
import graphics.DrawingArea;
import hex.HexPoint;
import interactions.Player;
import building.StartBuildingManager;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class StartRoadListener extends MouseInputAdapter {
    private Point pressedPoint, releasedPoint;
    private int pressedX, pressedY, releasedX, releasedY;
    private DrawingArea drawingArea;
    private Player humanPlayer;
    private HexPoint point;
    private CountDownLatch latch;
    private StartBuildingManager startBuildingManager;

    public StartRoadListener(DrawingArea drawingArea, CountDownLatch latch, HexPoint point, StartBuildingManager startBuildingManager) {
        super();
        this.startBuildingManager = startBuildingManager;
        this.drawingArea = drawingArea;
        this.humanPlayer = drawingArea.getCurrentPlayer();
        this.latch = latch;
        this.point = point;
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
        try {
            startBuildingManager.assignLine(drawingArea.getGuiActionsProcessor().lineByCoordinates(pressedX, pressedY, releasedX, releasedY));
            latch.countDown();
        } catch (buildingException buildingException) {
            handleBuildingException(buildingException);
        }
    }

    private void handleBuildingException(buildingException buildingException) {
        if (buildingException.getClass() == wrongRoadCoordinates.class) System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
        if (buildingException.getClass() == lineHasRoad.class) System.out.println("В этом месте уже есть дорога");
        if (buildingException.getClass() == lineHasNoPoint.class) System.out.println("Дорогу нужно построить рядом с новым поселением");
    }
}
