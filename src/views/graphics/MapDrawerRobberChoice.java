package views.graphics;

import java.awt.*;

public class MapDrawerRobberChoice extends MapDrawer {
    private Point cursorPoint;

    public MapDrawerRobberChoice(Graphics2D g2d, MapView mapView, Point cursorPoint) {
        super(g2d, mapView);
        this.cursorPoint = cursorPoint;
    }


    @Override
    void callHexDrawer(Graphics2D g2d, HexView hexView) {
        HexDrawer hexDrawer = new HexDrawerRobberChoice(g2d, hexView, cursorPoint);
        hexDrawer.drawHex();
    }
}
