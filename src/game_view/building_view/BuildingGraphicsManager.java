package game_view.building_view;

import game_view.graphics.map_graphics.MapPanel;
import java.util.concurrent.CountDownLatch;

public class BuildingGraphicsManager {
    private final int mapLocationX, mapLocationY;
    private MapPanel mapPanel;
    public MapPanel getMapPanel() {
        return mapPanel;
    }

    BuildingGraphicsManager(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        int[] coordinates = mapPanel.getMapCoordinates();
        mapLocationX = coordinates[0];
        mapLocationY = coordinates[1];
    }

    void activateStartSettlementListener(PointsLinesGetter pointsLinesGetter) {
        CountDownLatch startSettlementLatch = new CountDownLatch(1);
        StartSettlementListener startSettlementListener = new StartSettlementListener(pointsLinesGetter, startSettlementLatch);
        mapPanel.replaceListener(startSettlementListener);
        try {
            startSettlementLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void activateStartRoadListener(PointsLinesGetter pointsLinesGetter) {
        CountDownLatch startRoadLatch = new CountDownLatch(1);
        StartRoadListener startRoadListener = new StartRoadListener(pointsLinesGetter, startRoadLatch);
        mapPanel.replaceListener(startRoadListener);
        try
        {
            startRoadLatch.await();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        mapPanel.removeMouseListener(startRoadListener);
    }

    public void activateTurnListener() {
        mapPanel.replaceListener(new BuildListener(mapPanel));
    }

    //TO DO move repainting to another class
    void repaint() {
        mapPanel.repaint();
    }

    int getMapLocationX() {
        return mapLocationX;
    }

    int getMapLocationY() {
        return mapLocationY;
    }
}
