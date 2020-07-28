package views.building_view;

import views.TurnsView;
import views.graphics.map_graphics.MapPanel;

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
        var monitor = new Object();
        StartSettlementListener startSettlementListener = new StartSettlementListener(pointsLinesGetter, monitor);
        mapPanel.replaceListener(startSettlementListener);
        waitForAction(monitor);
    }

    void activateStartRoadListener(PointsLinesGetter pointsLinesGetter) {
        var monitor = new Object();
        StartRoadListener startRoadListener = new StartRoadListener(pointsLinesGetter, monitor);
        mapPanel.replaceListener(startRoadListener);
        waitForAction(monitor);
        mapPanel.removeMouseListener(startRoadListener);
    }

    void activateTurnListener(PointsLinesGetter pointsLinesGetter, TurnsView turnsView, Object monitor) {
        mapPanel.replaceListener(new BuildListener(pointsLinesGetter, turnsView, monitor));
    }

    private void waitForAction(Object monitor) {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
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
