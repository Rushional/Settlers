package views.graphics;

import models.map.MapHexes;

import java.awt.Graphics2D;
import java.awt.Color;

public class DrawMap {
    private Graphics2D g2d;
    private MapView mapView;


    public DrawMap(Graphics2D g2d, MapView mapView) {
        this.g2d = g2d;
        this.mapView = mapView;
    }

    public void call() {
        g2d.setColor(Color.black);
        for (HexView hexView : mapView.getHexViewsList()) {
            callDrawHex(g2d, hexView);
        }
    }

    void callDrawHex(Graphics2D g2d, HexView hexView) {
        DrawHex drawHex = new DrawHex(g2d, hexView);
        drawHex.call();
    }
}
