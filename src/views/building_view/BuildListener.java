package views.building_view;

import views.TurnsView;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class BuildListener extends MouseInputAdapter {
    private PointsLinesGetter pointsLinesGetter;
    private TurnsView turnsView;
    private Object monitor;
    private int pressedX, pressedY;

    BuildListener(PointsLinesGetter pointsLinesGetter, TurnsView turnsView, Object monitor) {
        super();
        this.pointsLinesGetter = pointsLinesGetter;
        this.turnsView = turnsView;
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
        int[] coordinates = { pressedX, pressedY, releasedX, releasedY };
        pointsLinesGetter.assignIntentionCoordinates(turnsView, monitor, coordinates);
    }
}