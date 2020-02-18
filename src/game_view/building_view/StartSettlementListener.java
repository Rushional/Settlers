package game_view.building_view;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class StartSettlementListener extends MouseInputAdapter {
    private PointsLinesGetter pointsLinesGetter;
    private CountDownLatch latch;

    StartSettlementListener(PointsLinesGetter pointsLinesGetter, CountDownLatch latch)
    {
        super();
        this.latch = latch;
        this.pointsLinesGetter = pointsLinesGetter;
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        int releasedX = releasedPoint.x;
        int releasedY = releasedPoint.y;
        pointsLinesGetter.assignPointCoordinates(releasedX, releasedY);
        latch.countDown();
    }
}
