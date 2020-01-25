package building_interface;

import building.*;
import exceptions.*;
import graphics.DrawingArea;
import hex.HexLine;
import hex.HexPoint;
import interactions.*;
import map.MapHexes;
import java.util.concurrent.CountDownLatch;

//This class takes interface actions and creates game actions
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

    public void setMapLocationY(int mapLocationY) {
        this.mapLocationY = mapLocationY;
    }
}
