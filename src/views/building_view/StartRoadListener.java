package views.building_view;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class StartRoadListener extends MouseInputAdapter {
    private int pressedX, pressedY;
    private PointsLinesGetter pointsLinesGetter;
    private Object monitor;

    StartRoadListener(PointsLinesGetter pointsLinesGetter, Object monitor) {
        super();
        this.pointsLinesGetter = pointsLinesGetter;
        this.monitor = monitor;
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
        pointsLinesGetter.assignCoordinates(pressedX, pressedY, releasedX, releasedY);
        synchronized (monitor) {
            monitor.notify();
        }
    }
}
