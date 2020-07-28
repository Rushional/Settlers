package views.building_view;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class StartSettlementListener extends MouseInputAdapter {
    private PointsLinesGetter pointsLinesGetter;
    private Object monitor;
    private int pressedX, pressedY;

    StartSettlementListener(PointsLinesGetter pointsLinesGetter, Object monitor)
    {
        super();
        this.monitor = monitor;
        this.pointsLinesGetter = pointsLinesGetter;
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
