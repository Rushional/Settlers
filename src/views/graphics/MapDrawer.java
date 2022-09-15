package views.graphics;

import java.awt.Graphics2D;
import java.awt.Color;

public class MapDrawer {
    private Graphics2D g2d;
    private MapView mapView;


    public MapDrawer(Graphics2D g2d, MapView mapView) {
        this.g2d = g2d;
        this.mapView = mapView;
    }

    public void drawMap() {
        g2d.setColor(Color.black);
        for (HexView hexView : mapView.getHexViewsList()) {
            callHexDrawer(g2d, hexView);
        }
    }

    void callHexDrawer(Graphics2D g2d, HexView hexView) {
        HexDrawer hexDrawer = new HexDrawer(g2d, hexView);
        hexDrawer.drawHex();
    }
}
