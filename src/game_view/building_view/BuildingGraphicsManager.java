package game_view.building_view;

import game_view.graphics.DrawingArea;
import java.util.concurrent.CountDownLatch;

public class BuildingGraphicsManager {
    private int mapLocationX, mapLocationY;
    private final static int pointDetectionRadius = 15;
    private DrawingArea drawingArea;
    public DrawingArea getDrawingArea() {
        return drawingArea;
    }

    public BuildingGraphicsManager(DrawingArea drawingArea, int mapLocationX, int mapLocationY) {
        this.drawingArea = drawingArea;
        this.mapLocationX = mapLocationX;
        this.mapLocationY = mapLocationY;
    }

    void activateStartSettlementListener(PointsLinesGetter pointsLinesGetter) {
        CountDownLatch startSettlementLatch = new CountDownLatch(1);
        StartSettlementListener startSettlementListener = new StartSettlementListener(pointsLinesGetter, startSettlementLatch);
        drawingArea.replaceListener(startSettlementListener);
        try {
            startSettlementLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void activateStartRoadListener(PointsLinesGetter pointsLinesGetter) {
        CountDownLatch startRoadLatch = new CountDownLatch(1);
        StartRoadListener startRoadListener = new StartRoadListener(pointsLinesGetter, startRoadLatch);
        drawingArea.replaceListener(startRoadListener);
        try
        {
            startRoadLatch.await();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        drawingArea.removeMouseListener(startRoadListener);
    }

    public void activateTurnListener() {
        drawingArea.replaceListener(new BuildListener(drawingArea));
    }

    //TO DO move repainting to another class
    void repaint() {
        drawingArea.repaint();
    }

    int getMapLocationX() {
        return mapLocationX;
    }

    int getMapLocationY() {
        return mapLocationY;
    }
}
