package game_view.building_view;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class StartRoadListener extends MouseInputAdapter {
    private int pressedX, pressedY;
    private CountDownLatch latch;
    private PointsLinesGetter pointsLinesGetter;

    StartRoadListener(PointsLinesGetter pointsLinesGetter, CountDownLatch latch) {
        super();
        this.pointsLinesGetter = pointsLinesGetter;
        this.latch = latch;
    }

    public void mousePressed(MouseEvent e)
    {
        Point pressedPoint = e.getPoint();
        pressedX = pressedPoint.x;
        pressedY = pressedPoint.y;
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        int releasedX = releasedPoint.x;
        int releasedY = releasedPoint.y;
        pointsLinesGetter.assignLineCoordinates(pressedX, pressedY, releasedX, releasedY);
        latch.countDown();
    }
}
