package views.graphics;

import views.frame.MapPanel;

public class ViewUpdater {
    private MapPanel mapPanel;

    public ViewUpdater(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    public void updateMap() {
        mapPanel.repaint();
    }
}
