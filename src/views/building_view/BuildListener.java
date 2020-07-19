package views.building_view;

import views.TurnsView;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

import static java.lang.Math.abs;

public class BuildListener extends MouseInputAdapter {
    private PointsLinesGetter pointsLinesGetter;
    private TurnsView turnsView;
    private CountDownLatch latch;
    private int pressedX, pressedY;

    BuildListener(PointsLinesGetter pointsLinesGetter, TurnsView turnsView, CountDownLatch latch) {
        super();
        this.pointsLinesGetter = pointsLinesGetter;
        this.turnsView = turnsView;
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
        int[] coordinates = { pressedX, pressedY, releasedX, releasedY };
        pointsLinesGetter.assignIntentionCoordinates(turnsView, latch, coordinates);
    }
}